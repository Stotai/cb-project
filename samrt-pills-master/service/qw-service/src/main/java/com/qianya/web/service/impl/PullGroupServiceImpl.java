package com.qianya.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.qianya.cbEnum.CustomerStatusEnum;
import com.qianya.common.JsonResultT;
import com.qianya.constant.MqConstant;
import com.qianya.entity.*;
import com.qianya.mapper.CustomerMapper;
import com.qianya.mapper.PullConfigMapper;
import com.qianya.mapper.PullGroupMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.PullConfigDtoIn;
import com.qianya.model.in.PullGroupDetailDtoIn;
import com.qianya.model.in.PullGroupDtoIn;
import com.qianya.util.CommonPage;
import com.qianya.util.DateUtil;
import com.qianya.util.GrainBeanUtils;
import com.qianya.util.StringUtil;
import com.qianya.web.mapper.PullGroupExMapper;
import com.qianya.web.service.LoginService;
import com.qianya.web.service.PullGroupService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-16  13:45
 * @Description: 拉群相关
 */
@Service
public class PullGroupServiceImpl implements PullGroupService {

    @Autowired
    private LoginService loginService;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private PullGroupMapper pullGroupMapper;
    @Autowired
    private PullGroupExMapper pullGroupExMapper;
    @Autowired
    private PullConfigMapper pullConfigMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    @Transactional
    public JsonResultT<?> addPull(PullGroupDtoIn pullGroupDtoIn) {
        //获取登录对象
        IUserDo iUserDo = loginService.selectUser();
        PullGroup pullGroup= GrainBeanUtils.convert(pullGroupDtoIn,PullGroup.class);
        //获取明细保存 先把拉群写进去
        List<PullGroupDetailDtoIn>  pullGroupOpDetailList=pullGroupDtoIn.getDetailDtoInList();
        PullGroupDetailDtoIn pullGroupOpDetail=new PullGroupDetailDtoIn();
        pullGroupOpDetail.setItemType(8);
        pullGroupOpDetail.setWaitSeconds(1);
        pullGroupOpDetail.setSort(99);
        pullGroupOpDetail.setGroupIds(pullGroupDtoIn.getGroupIds().stream().collect(Collectors.joining(",")));
        pullGroupOpDetailList.add(pullGroupOpDetail);
        //明细
        List<PullCustRelation>  pullCustRelationList=new ArrayList<>();
        //处理记录
        if (!CollectionUtils.isEmpty(pullGroupDtoIn.getCustomerIds())) {
            List<String> customerIds = pullGroupDtoIn.getCustomerIds();
            for (String customerId : customerIds) {
                PullCustRelation moEntity = new PullCustRelation();
                moEntity.setCustWxId(customerId);
                moEntity.setStatus(0);
                pullCustRelationList.add(moEntity);
            }
        } else {
            //拉取所有的客戶
            CustomerCriteria customerCriteria = new CustomerCriteria();
            customerCriteria.createCriteria().andEpriseWxIdEqualTo(iUserDo.getExriseWxId()).andIsDelEqualTo(0).andStatusEqualTo(CustomerStatusEnum.ACCEPTED.getCode())
                    .andZombieFlagEqualTo(0);
            List<Customer> customerList = customerMapper.selectByExample(customerCriteria);
            if (!CollectionUtils.isEmpty(customerList)) {
                for (Customer customer : customerList) {
                    PullCustRelation moEntity = new PullCustRelation();
                    moEntity.setCustWxId(customer.getCustWxId());
                    moEntity.setStatus(0);
                    pullCustRelationList.add(moEntity);
                }
            }
        }
        //保存主表记录
        pullGroup.setSendCount(pullCustRelationList.size());
        pullGroup.setStatus(1);
        pullGroup.setCreateTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        pullGroup.setUserId(iUserDo.getUserId());
        pullGroup.setExriseWxId(iUserDo.getExriseWxId());
        pullGroup.setExriseWxName(iUserDo.getExriseWxName());
        pullGroupMapper.insertSelective(pullGroup);
        Integer pullId = pullGroup.getPullId();
        //保存消息明细
        List<PullGroupOpDetail> groupOpDetailList=GrainBeanUtils.convertLists(pullGroupOpDetailList,PullGroupOpDetail.class,(x,y)->{
                 x.setPullId(pullId);
                 if(StringUtil.isEmpty(y.getSize())){
                     x.setXcxSize(y.getSize());
                 }
        });
        pullGroupExMapper.batchInsertDetail(groupOpDetailList);
        //处理发送关系
        for(PullCustRelation  po : pullCustRelationList){
             po.setPullId(pullId);
        }
        pullGroupExMapper.batchInsertRelation(pullCustRelationList);
        PullConfigCriteria pullConfigCriteria = new PullConfigCriteria();
        pullConfigCriteria.createCriteria().andUserIdEqualTo(iUserDo.getUserId());
        List<PullConfig> pullConfigList = pullConfigMapper.selectByExample(pullConfigCriteria);
        int waitSecond = 1;

        if (!CollectionUtils.isEmpty(pullConfigList)) {
            PullConfig pullConfig = pullConfigList.get(0);
            if (pullConfig.getWaitSeconds() != null) {
                waitSecond = pullConfig.getWaitSeconds();
            }
            String workTime = pullConfig.getWorkTime();
            if (StringUtil.isNotEmpty(workTime)) {
                String[] times = workTime.split(",");
                int startHour = Integer.parseInt(times[0]);
                int endHour = Integer.parseInt(times[1]);
                int currentHour = LocalTime.now().getHour();
                if (currentHour >= startHour && currentHour <= endHour) {
                    processPullCustRelations(pullCustRelationList, groupOpDetailList, waitSecond, pullGroup.getDayMaxNum(), iUserDo.getUserId());
                } else {
                    return JsonResultT.ok();
                }
            }
        } else {
            processPullCustRelations(pullCustRelationList, groupOpDetailList, waitSecond, pullGroup.getDayMaxNum(), iUserDo.getUserId());
        }
       return JsonResultT.ok();
    }


    private void processPullCustRelations(List<PullCustRelation> pullCustRelationList, List<PullGroupOpDetail> groupOpDetailList, int waitSecond, Integer dayMaxNum, Integer userId) {
        int sendWaitSeconds = 0;
        int totalPullCustRelations = pullCustRelationList.size();

        if (dayMaxNum != null && dayMaxNum >= totalPullCustRelations) {
            for (PullCustRelation pullCustRelation : pullCustRelationList) {
                for (PullGroupOpDetail opDetail : groupOpDetailList) {
                    sendWaitSeconds += opDetail.getWaitSeconds() + waitSecond;
                    int day = sendWaitSeconds * 1000;
                    sendMessageWithDelay(opDetail, pullCustRelation.getCustWxId(), userId, day);
                }
            }
        } else {
            List<PullCustRelation> sendList = pullCustRelationList.subList(0, totalPullCustRelations);
            for (PullCustRelation pullCustRelation : sendList) {
                for (PullGroupOpDetail opDetail : groupOpDetailList) {
                    sendWaitSeconds += opDetail.getWaitSeconds() + waitSecond;
                    int day = sendWaitSeconds * 1000;
                    sendMessageWithDelay(opDetail, pullCustRelation.getCustWxId(), userId, day);
                }
            }
        }
    }

    private void sendMessageWithDelay(PullGroupOpDetail opDetail, String customerId, Integer userId, Integer day) {
        JSONObject object = new JSONObject();
        object.put("missDetail", opDetail);
        object.put("customerId", customerId);
        object.put("userId", userId);
        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_custom_exchange, MqConstant.routeKey.pull_send_miss_key, object.toJSONString(), message -> {
            message.getMessageProperties().setDelay(day);
            return message;
        });
    }


    @Override
    public JsonResultT<CommonPage<PullGroup>> findByExriseWxIdsAndPullName(List<String> exriseWxIds, String pullName, Integer status, Integer pageNum, Integer pageSize) {
        IUserDo iUserDo = loginService.selectUser();
        PageHelper.startPage(pageNum,pageSize);
        List<PullGroup> pullGroups = pullGroupExMapper.findByExriseWxIdsAndPullName(exriseWxIds, pullName, status, iUserDo.getUserId());
        return JsonResultT.ok(CommonPage.restPage(pullGroups));
    }

    @Override
    public JsonResultT<?> savePullConfig(PullConfigDtoIn pullConfigDtoIn) {

        IUserDo iUserDo=loginService.selectUser();
        // 根据用户id查询数据库中是否已存在配置
        PullConfig existingConfig = findConfigByUserId(iUserDo.getUserId());
        if (existingConfig == null) {
            // 不存在配置，执行新增操作
            PullConfig newConfig = new PullConfig();
            newConfig.setUserId(iUserDo.getUserId());
            newConfig.setWorkTime(pullConfigDtoIn.getWorkTime());
            newConfig.setWaitSeconds(pullConfigDtoIn.getWaitSeconds());
            pullConfigMapper.insertSelective(newConfig);
        } else {
            // 存在配置，执行修改操作
            existingConfig.setWorkTime(pullConfigDtoIn.getWorkTime());
            existingConfig.setWaitSeconds(pullConfigDtoIn.getWaitSeconds());

            pullConfigMapper.updateByPrimaryKeySelective(existingConfig);
        }
        return JsonResultT.ok("操作成功");
    }

    @Override
    public JsonResultT<?> updateSendState(Integer pullId, Integer customerId, Integer state, String failMsg) {
        JSONObject object = new JSONObject();
        object.put("state", state);
        object.put("pullId", pullId);
        object.put("customerId", customerId);
        object.put("failMsg", failMsg);
        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_new_exchange, MqConstant.routeKey.pull_send_res_key, object.toJSONString());
        return JsonResultT.ok();
    }

    @Override
    public JsonResultT<?> getPullConfig() {
        IUserDo iUserDo = loginService.selectUser();
        PullConfigCriteria configCriteria=new PullConfigCriteria();
        configCriteria.createCriteria().andUserIdEqualTo(iUserDo.getUserId());
        PullConfig pullConfig=pullConfigMapper.selectByExampleForOne(configCriteria);
        return JsonResultT.ok(pullConfig);
    }

    public PullConfig findConfigByUserId(Integer userId) {
        // 调用数据访问层的方法，根据用户ID查询配置

        PullConfigCriteria pullConfigCriteria=new PullConfigCriteria();
        pullConfigCriteria.createCriteria().andUserIdEqualTo(userId);
        PullConfig pullConfig=pullConfigMapper.selectByExampleForOne(pullConfigCriteria);
        return pullConfig;
    }
}
