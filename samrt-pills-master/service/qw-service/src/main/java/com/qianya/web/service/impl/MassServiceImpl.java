package com.qianya.web.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.qianya.cbEnum.CustomerStatusEnum;
import com.qianya.common.JsonResultT;
import com.qianya.constant.MqConstant;
import com.qianya.entity.*;
import com.qianya.entity.mongo.MassCustRelationMoEntity;
import com.qianya.entity.mongo.MassSendingMainMoEntity;
import com.qianya.mapper.CustomerMapper;
import com.qianya.mapper.ExGroupMapper;
import com.qianya.mapper.MassSendingDetailMapper;
import com.qianya.mapper.MassSendingMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.MassSendingDetailDtoIn;
import com.qianya.model.in.MassSendingDtoIn;
import com.qianya.model.out.MassSendingDraftDetailDtoOut;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.util.*;
import com.qianya.web.mapper.MassExMapper;
import com.qianya.web.service.LoginService;
import com.qianya.web.service.MassService;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.net.URI;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-08  14:31
 * @Description:  群发
 */
@Service
public class MassServiceImpl  implements MassService {


    @Autowired
    private MassSendingMapper massSendingMapper;
    @Autowired
    private MassSendingDetailMapper massSendingDetailMapper;
    @Autowired
    private MassExMapper massExMapper;
    @Autowired
    private LoginService loginService;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ExGroupMapper exGroupMapper;


    @Override
    @Transactional
    public JsonResultT<?> editMass(MassSendingDtoIn massSendingDtoIn) {

        IUserDo user = loginService.selectUser();

        Integer massId = massSendingDtoIn.getMassId();
        if (CollectionUtils.isEmpty(massSendingDtoIn.getDetailDtoInList())) {
            return JsonResultT.error("请传入群发明细");
        }
        String massContent = getMassContent(massSendingDtoIn.getDetailDtoInList());
        if (massId != null) {
            //修改先删除
            if (massSendingDtoIn.getMassId() == null) {
                return JsonResultT.error("请传入群发id");
            }
            MassSending updateMass = GrainBeanUtils.convert(massSendingDtoIn, MassSending.class);
            updateMass.setMassContent(massContent);
            if (massSendingDtoIn.getMassType() == 2) {//立刻需要设置时间的下一分钟
                updateMass.setMassTime(LocalDateTime.now().plusSeconds(10).format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)));
            } else if (massSendingDtoIn.getMassType() == 1) {
                updateMass.setMassTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)));
            }
            massSendingMapper.updateByPrimaryKeySelective(updateMass);
            //删除明细记录
            MassSendingDetailCriteria detailCriteria = new MassSendingDetailCriteria();
            detailCriteria.createCriteria().andMassIdEqualTo(massSendingDtoIn.getMassId());
            massSendingDetailMapper.deleteByExample(detailCriteria);
            //删除 发送用户关联数据
            Query query = new Query(Criteria.where("mass_id").is(massId));
            mongoTemplate.remove(query, MassCustRelationMoEntity.class, "mass_cust_relation");
        } else {
            //获取登录用户
            MassSending massSending = GrainBeanUtils.convert(massSendingDtoIn, MassSending.class);
            massSending.setUserId(user.getUserId());
            massSending.setExexriseUserId(user.getExriseWxId());
            massSending.setIsDel(0);
            if (massSendingDtoIn.getMassType() == 2) {//立刻需要设置时间的下一分钟
                massSending.setMassTime(LocalDateTime.now().plusSeconds(10).format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)));
            } else if (massSendingDtoIn.getMassType() == 1) {
                massSending.setMassTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)));
            }
            massSending.setMassContent(massContent);
            massSending.setStatus(0);
            massSending.setExecuteTimes(0);
            massSending.setCreateTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
            massSendingMapper.insertSelective(massSending);
            massId = massSending.getMassId();
        }
        List<MassSendingDetailDtoIn> massSendingDetailDtoIns = massSendingDtoIn.getDetailDtoInList();
        for (MassSendingDetailDtoIn detailDtoIn : massSendingDetailDtoIns) {
            detailDtoIn.setMassId(massId);
        }
        massExMapper.batchInsertMassSendingDetail(massSendingDetailDtoIns);
        //
        List<MassCustRelationMoEntity> relationMoEntities = new ArrayList<>();

        if (massSendingDtoIn.getSendType() == 1) {
            //处理群发记录
            if (!CollectionUtils.isEmpty(massSendingDtoIn.getCustomerIds())) {
                List<String> customerIds = massSendingDtoIn.getCustomerIds();
                for (String customerId : customerIds) {
                    MassCustRelationMoEntity moEntity = new MassCustRelationMoEntity();
                    moEntity.setRecordId(idWorker.nextId());
                    moEntity.setMassId(massId);
                    moEntity.setWorkType(1);
                    moEntity.setWorkId(customerId);
                    relationMoEntities.add(moEntity);
                }
            } else {
                //拉取所有的客戶
                CustomerCriteria customerCriteria = new CustomerCriteria();
                customerCriteria.createCriteria().andEpriseWxIdEqualTo(user.getExriseWxId()).andIsDelEqualTo(0).andStatusEqualTo(CustomerStatusEnum.ACCEPTED.getCode())
                        .andZombieFlagEqualTo(0);
                List<Customer> customerList = customerMapper.selectByExample(customerCriteria);
                if (!CollectionUtils.isEmpty(customerList)) {
                    for (Customer customer : customerList) {
                        MassCustRelationMoEntity moEntity = new MassCustRelationMoEntity();
                        moEntity.setRecordId(idWorker.nextId());
                        moEntity.setMassId(massId);
                        moEntity.setWorkType(1);
                        moEntity.setWorkId(customer.getCustWxId());
                        relationMoEntities.add(moEntity);
                    }
                }
            }
        } else {
            //处理群发记录
            if (!CollectionUtils.isEmpty(massSendingDtoIn.getGroupWxId())) {
                List<String> groupWxIds = massSendingDtoIn.getGroupWxId();
                for (String groupWxId : groupWxIds) {
                    MassCustRelationMoEntity moEntity = new MassCustRelationMoEntity();
                    moEntity.setRecordId(idWorker.nextId());
                    moEntity.setMassId(massId);
                    moEntity.setWorkType(2);
                    moEntity.setWorkId(groupWxId);
                    relationMoEntities.add(moEntity);
                }
            } else {
                //查询所有群聊
                ExGroupCriteria exGroupCriteria = new ExGroupCriteria();
                exGroupCriteria.createCriteria().andUserIdEqualTo(user.getUserId()).andExriseUserIdEqualTo(user.getExriseWxId());
                List<ExGroup> exGroupList = exGroupMapper.selectByExample(exGroupCriteria);
                if (CollectionUtils.isEmpty(exGroupList)) {
                    return JsonResultT.error("群发失败，请先创建群聊或者加入群聊");
                }
                List<String> exList = exGroupList.stream().map(ExGroup::getGroupWxId).collect(Collectors.toList());
                for (String groupWxId : exList) {
                    MassCustRelationMoEntity moEntity = new MassCustRelationMoEntity();
                    moEntity.setRecordId(idWorker.nextId());
                    moEntity.setMassId(massId);
                    moEntity.setWorkType(2);
                    moEntity.setWorkId(groupWxId);
                    relationMoEntities.add(moEntity);
                }
            }
        }

        MassSending updateSending = new MassSending();
        updateSending.setMassId(massId);
        updateSending.setMassNum(relationMoEntities.size());
        massSendingMapper.updateByPrimaryKeySelective(updateSending);
        if (!CollectionUtils.isEmpty(relationMoEntities)) {
            //一千一批
            List<List<MassCustRelationMoEntity>> relationList = Lists.partition(relationMoEntities, 1000);
            for (List<MassCustRelationMoEntity> massCustRelationMoEntities : relationList) {
                mongoTemplate.insert(massCustRelationMoEntities, "mass_cust_relation");
            }
        }
        Long sendTime=1L;
        if(massSendingDtoIn.getMassType()==1){
            //计算时间
            Long diffSencord = getDiffSencord(massSendingDtoIn.getMassTime(), DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
            sendTime=diffSencord;
        }
        if(massSendingDtoIn.getMassType()==1 ||massSendingDtoIn.getMassType() ==2){
            Long finalSendTime = sendTime;
            rabbitTemplate.convertAndSend(MqConstant.exchange.mall_custom_exchange, MqConstant.routeKey.mass_send_key,1 , message -> {
                //设置发送消息的延迟时间
                message.getMessageProperties().setDelay((int) (finalSendTime *1000));
                return message;
            });
        }



        return JsonResultT.ok("保存成功");
    }

    private Long getDiffSencord(String startTime,String endTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //将String转换为localDateTime类型
        LocalDateTime localDateTime1 = LocalDateTime.parse(startTime,dateTimeFormatter);
        LocalDateTime localDateTime2 = LocalDateTime.parse(endTime,dateTimeFormatter);
        //LocalDateTime自带时间差计算（开始时间，结束时间）
        Duration duration = Duration.between(localDateTime1,localDateTime2);
        long second = duration.toMillis()/1000;
        return second;
    }

    @Override
    public JsonResultT<?> operateMass(Integer massId, Integer status) {
        MassSending massSending = massSendingMapper.selectByPrimaryKey(massId);
        if (massSending == null) {
            return JsonResultT.error("群发不存在");
        }
        MassSending updateMassSending = new MassSending();
        updateMassSending.setMassId(massId);
        //修改状态
        if (status == 0 || status == 1) {
            updateMassSending.setStatus(status);
            massSendingMapper.updateByPrimaryKeySelective(updateMassSending);
        } else {
            updateMassSending.setIsDel(1);
            massSendingMapper.updateByPrimaryKeySelective(updateMassSending);
        }

        return JsonResultT.ok();
    }


    private String getMassContent(List<MassSendingDetailDtoIn> massSendingDetailDtoIns) {

        StringBuilder stringBuilder = new StringBuilder();
        for (MassSendingDetailDtoIn massSendingDetailDtoIn : massSendingDetailDtoIns) {
            if (massSendingDetailDtoIn.getItemType() == 1) {
                stringBuilder.append(massSendingDetailDtoIn.getItemContent());
                stringBuilder.append(",");
            } else if (massSendingDetailDtoIn.getItemType() == 2) {
                stringBuilder.append("图片,");
            } else if (massSendingDetailDtoIn.getItemType() == 3) {
                stringBuilder.append("动图,");
            } else if (massSendingDetailDtoIn.getItemType() == 4) {
                stringBuilder.append("视频,");
            } else if (massSendingDetailDtoIn.getItemType() == 5) {
                stringBuilder.append("卡片,");
            } else if (massSendingDetailDtoIn.getItemType() == 6) {
                stringBuilder.append("小程序,");
            } else {
                stringBuilder.append("视频号,");
            }
        }
        String content = stringBuilder.toString();
        return content.substring(0, content.length() - 1);
    }

    @Override
    public JsonResultT<?> getMassDetail(Integer massId) {
        MassSending massSending = massSendingMapper.selectByPrimaryKey(massId);
        if (massSending == null || massSending.getIsDel() == 1) {
            return JsonResultT.error("群发记录不存在");
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("mass", massSending);
        //查询明细
        MassSendingDetailCriteria criteria = new MassSendingDetailCriteria();
        criteria.createCriteria().andMassIdEqualTo(massId);
        List<MassSendingDetail> massSendingDetailList = massSendingDetailMapper.selectByExample(criteria);
        resultMap.put("detailList", massSendingDetailList);
        //查询发送人
        Criteria monCri = Criteria.where("mass_id").is(massId);
        Query query = new Query(monCri);
        List<MassCustRelationMoEntity> massCustRelationMoEntities = mongoTemplate.find(query, MassCustRelationMoEntity.class, "mass_cust_relation");
        resultMap.put("customerList", massCustRelationMoEntities);
        return JsonResultT.ok(resultMap);
    }

    @Override
    public JsonResultT<CommonPage<MassSending>> getMassList(String content, String exexriseUserIds, Integer massCommonType,Integer pageNum, Integer pageSize) {

        // 解析多选的关联企业微信id
        List<String> epriseWxIdList = null;
        if (StringUtils.isNotEmpty(exexriseUserIds)) {
            String[] epriseWxIdArr = exexriseUserIds.split(",");
            epriseWxIdList = Arrays.asList(epriseWxIdArr);
        }
        IUserDo user=loginService.selectUser();
        // 分页查询客户信息
        PageHelper.startPage(pageNum, pageSize);
        List<MassSending> massList = massExMapper.getMassList(user.getUserId(),massCommonType, content, epriseWxIdList);
        return JsonResultT.ok(CommonPage.restPage(massList));
    }

    @Override
    public JsonResultT<?> updateSendState(Integer massId, String workId, Integer state, String failMsg) {
        JSONObject object = new JSONObject();
        object.put("state", state);
        object.put("massId", massId);
        object.put("workId", workId);
        object.put("failMsg", failMsg);
        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_new_exchange, MqConstant.routeKey.miss_send_res_key, object.toJSONString());
        return JsonResultT.ok();
    }

    @Override
    public JsonResultT<PageResult<MassSendingMainMoEntity>> queryMassSendRecord(String content, String exexriseUserIds,Integer massCommonType, Integer pageNum, Integer pageSize) {
       IUserDo iUserDo = loginService.selectUser();

        Criteria criteria = new Criteria();
        criteria.and("user_id").is(iUserDo.getUserId());
        List<String> epriseWxIdList = null;
        if (StringUtils.isNotEmpty(exexriseUserIds)) {
            String[] epriseWxIdArr = exexriseUserIds.split(",");
            epriseWxIdList = Arrays.asList(epriseWxIdArr);
        }
        if (!CollectionUtils.isEmpty(epriseWxIdList)) {
            criteria.and("exrise_wx_id").in(exexriseUserIds);
        }
        if (StringUtil.isNotEmpty(content)) {
            criteria.and("mass_name").regex("^.*" + content + ".*$");
        }
        criteria.and("mass_type").is(massCommonType);
        Query query = new Query(criteria);
        long count = mongoTemplate.count(query, MassSendingMainMoEntity.class, "mass_sending_main");
        List<MassSendingMainMoEntity> list = mongoTemplate.find(query
                        .with(PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Direction.DESC, "create_time"))),
                MassSendingMainMoEntity.class, "mass_sending_main");
        PageResult<MassSendingMainMoEntity> pageResult = new PageResult<>();
        long l = (count % pageSize);
        pageResult.setPage(pageNum);
        pageResult.setSize(pageSize);
        pageResult.setPages((int) (count == 0 ? 0 : l == 0 ? l : (count / pageSize) + 1));
        pageResult.setTotals(count);
        pageResult.setRows(list);
        return JsonResultT.ok(pageResult);
    }

    @Override
    public JsonResultT<CommonPage<SchemeDraftDtoOut>> draftList(String content, Integer pageNum, Integer pageSize) {
        IUserDo iUserDo = loginService.selectUser();
        List<SchemeDraftDtoOut> schemeDraftDtoOutList = massExMapper.getMassDraftDtoOutList(iUserDo.getUserId(), content);
        return JsonResultT.ok(CommonPage.restPage(schemeDraftDtoOutList));
    }

    @Override
    public JsonResultT<MassSendingDraftDetailDtoOut> getDrafDetail(Integer massId) {
        MassSending massSending = massSendingMapper.selectByPrimaryKey(massId);
        if (massSending == null) {
            return JsonResultT.error("模板信息不存在");
        }
        //模板明细
        MassSendingDetailCriteria massSendingDetailCriteria = new MassSendingDetailCriteria();
        massSendingDetailCriteria.createCriteria().andMassIdEqualTo(massId);
        List<MassSendingDetail> massSendingDetailList = massSendingDetailMapper.selectByExample(massSendingDetailCriteria);
        MassSendingDraftDetailDtoOut massSendingDraftDetailDtoOut = GrainBeanUtils.convert(massSending, MassSendingDraftDetailDtoOut.class);
        massSendingDraftDetailDtoOut.setDetailDtoInList(GrainBeanUtils.convertList(massSendingDetailList, MassSendingDetailDtoIn.class));
        return JsonResultT.ok(massSendingDraftDetailDtoOut);

    }

    @Override
    public JsonResultT<?> massTask() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            URIBuilder uriBuilder = new URIBuilder("http://39.106.133.60/front/task-service/testSend");
            URI uri = uriBuilder.build();
            HttpPost httpPost = new HttpPost(uri);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            JSONObject jsonObject = JSON.parseObject(responseBody);
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          return JsonResultT.ok();
}


}
