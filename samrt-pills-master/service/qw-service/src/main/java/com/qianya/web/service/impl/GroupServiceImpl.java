package com.qianya.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.entity.*;
import com.qianya.mapper.ExGroupMapper;
import com.qianya.mapper.GroupCustMapper;
import com.qianya.mapper.GroupInviteConfigMapper;
import com.qianya.mapper.GrouppingMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.*;
import com.qianya.model.out.GroupDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.DateUtil;
import com.qianya.util.GrainBeanUtils;
import com.qianya.util.StringUtil;
import com.qianya.web.mapper.GroupExMapper;
import com.qianya.web.service.GroupService;
import com.qianya.web.service.LoginService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import java.net.URI;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-12  17:17
 * @Description: 群管理实现
 */
@Service
public class GroupServiceImpl implements GroupService {



    @Autowired
    private LoginService loginService;
    @Autowired
    private GrouppingMapper grouppingMapper;
    @Autowired
    private ExGroupMapper exGroupMapper;
    @Autowired
    private GroupExMapper groupExMapper;
    @Autowired
    private GroupCustMapper groupCustMapper;
    @Autowired
    private GroupInviteConfigMapper groupInviteConfigMapper;


    @Override
    public JsonResult editGrouping(Integer grouppingId,String name) {
        IUserDo user = loginService.selectUser();
        if (grouppingId == null) {

            Groupping groupping = new Groupping();
            groupping.setName(name);
            groupping.setUserId(user.getUserId());
            groupping.setExriseUserId(user.getExriseWxId());
            groupping.setIsDel(0);
            groupping.setCreateTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
            grouppingMapper.insertSelective(groupping);
        } else {//修改
            Groupping groupping = grouppingMapper.selectByPrimaryKey(grouppingId);
            if (groupping == null) {
                return JsonResult.error("要修改的记录不存在");
            }
            Groupping updateGrouping = new Groupping();
            updateGrouping.setName(name);
            updateGrouping.setGroupingId(grouppingId);
            grouppingMapper.updateByPrimaryKeySelective(updateGrouping);
        }
        return JsonResult.ok();
    }

    @Override
    public List<Groupping> grouppingList() {
        IUserDo user = loginService.selectUser();
        GrouppingCriteria grouppingCriteria=new GrouppingCriteria();
        grouppingCriteria.createCriteria().andUserIdEqualTo(user.getUserId()).andIsDelEqualTo(0);
        List<Groupping> grouppingList=grouppingMapper.selectByExample(grouppingCriteria);
        if(CollectionUtils.isEmpty(grouppingList)){
            return Collections.emptyList();
        }
        return grouppingList;
    }

    @Override
    @Transactional
    public JsonResult deleteGrouppping(Integer grouppingId) {
        //删除群分组
        GrouppingCriteria grouppingCriteria=new GrouppingCriteria();
        grouppingCriteria.createCriteria().andGroupingIdEqualTo(grouppingId);
        Groupping updateGrouping=new Groupping();
        updateGrouping.setIsDel(1);
        grouppingMapper.updateByExampleSelective(updateGrouping,grouppingCriteria);
        //去掉已有群分组标签
        groupExMapper.updateGroupingSetNull(grouppingId);
        return JsonResult.ok();
    }

    @Override
    @Transactional
    public JsonResult refreshGroup(List<GroupDtoIn> groupDtoIns) {
        IUserDo user = loginService.selectUser();
        //查询自己的所有群
        ExGroupCriteria exGroupCriteria=new ExGroupCriteria();
        exGroupCriteria.createCriteria().andUserIdEqualTo(user.getUserId()).andExriseUserIdEqualTo(user.getExriseWxId());
        exGroupMapper.deleteByExample(exGroupCriteria);
        if (!CollectionUtils.isEmpty(groupDtoIns)) {
            List<ExGroup> groupList = GrainBeanUtils.convertList(groupDtoIns, ExGroup.class
                    , x -> {
                        x.setUserId(user.getUserId());
                        x.setExriseUserId(user.getExriseWxId());
                    });
            groupExMapper.batchInsertGroups(groupList);
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult refreshGroupCust(List<GroupCustDtoIn> groupCustList) {
        IUserDo user = loginService.selectUser();
        String groupId = groupCustList.get(0).getGroupWxId();
        //查询群数据
        ExGroupCriteria exGroupCriteria=new ExGroupCriteria();
        exGroupCriteria.createCriteria().andGroupWxIdEqualTo(groupId).andExriseUserIdEqualTo(user.getExriseWxId());
        List<ExGroup> exGroupList=exGroupMapper.selectByExample(exGroupCriteria);
        if(CollectionUtils.isEmpty(exGroupList)){
            return JsonResult.ok();
        }
        //查询群成员数据
        GroupCustCriteria groupCustCriteria = new GroupCustCriteria();
        groupCustCriteria.createCriteria().andGroupWxIdEqualTo(groupId);
        List<GroupCust> groupCusts = groupCustMapper.selectByExample(groupCustCriteria);
        //转换成map
        Map<String, Integer> groupCustMap = groupCusts.stream()
                .collect(Collectors.toMap(
                        groupCust -> groupCust.getGroupWxId() + "-" + groupCust.getCustWxId(),
                        GroupCust::getCustomerId
                ));


        //转成map
        //过滤出要删除的数据
        List<String> groupCustWxIds=groupCusts.stream().map(GroupCust::getCustWxId).collect(Collectors.toList());
        List<GroupCust> deleteGroups=groupCusts.stream().filter(x->!groupCustWxIds.contains(x.getCustWxId())).collect(Collectors.toList());
        //删除
        if(!CollectionUtils.isEmpty(deleteGroups)){
            List<String> deleteIds=deleteGroups.stream().map(GroupCust::getCustWxId).collect(Collectors.toList());
            GroupCustCriteria deleteCriteria=new GroupCustCriteria();
            deleteCriteria.createCriteria().andGroupWxIdEqualTo(groupId).andCustWxIdIn(deleteIds);
            groupCustMapper.deleteByExample(deleteCriteria);
        }
        //定义新增数据
        List<GroupCustDtoIn> addGroupCustDtos = new ArrayList<>();
        for (GroupCustDtoIn groupCustDtoIn : groupCustList) {
            if (groupCustMap.get(groupCustDtoIn.getGroupWxId()+"-"+groupCustDtoIn.getCustWxId())==null) {
                addGroupCustDtos.add(groupCustDtoIn);
            }
        }
        if (!CollectionUtils.isEmpty(addGroupCustDtos)) {
            List<GroupCust> groupList = GrainBeanUtils.convertList(addGroupCustDtos, GroupCust.class
                    , x -> {
                        x.setUserId(user.getUserId());
                        x.setGroupId(exGroupList.get(0).getGroupId());
                        x.setGroupWxId(exGroupList.get(0).getGroupWxId());
                    });
            groupExMapper.insertBatchCust(groupList);
        }
        //合成群头像
        String urls;
        if(groupCustList.size()>3){
            List<GroupCustDtoIn> headList=groupCustList.subList(0,3);
            urls=headList.stream().map(GroupCustDtoIn::getCustWxHeadUrl).collect(Collectors.joining(","));
        }else {
            urls=groupCustList.stream().map(GroupCustDtoIn::getCustWxHeadUrl).collect(Collectors.joining(","));
        }
        //获取头像地址
        String comUrls = picCompound(urls, "http://39.106.133.60/front/system-file/upload/picCompound");
        if(StringUtil.isNotEmpty(comUrls)){
            comUrls="https://cb2023-bucket.oss-cn-beijing.aliyuncs.com"+comUrls;
            ExGroup exGroup = new ExGroup();
            exGroup.setGroupImg(comUrls);
            ExGroupCriteria groupCriteria = new ExGroupCriteria();
            groupCriteria.createCriteria().andGroupWxIdEqualTo(groupId);
            exGroupMapper.updateByExampleSelective(exGroup, groupCriteria);
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult groupByPing(String groupId, Integer groupingId) {
        List<Integer> groudIds = Arrays.stream(groupId.split(",")).filter(StringUtil::isNotEmpty).map(Integer::parseInt).collect(Collectors.toList());

        ExGroupCriteria criteria=new ExGroupCriteria();
        criteria.createCriteria().andGroupIdIn(groudIds);
        List<ExGroup> group = exGroupMapper.selectByExample(criteria);
        if(group.isEmpty()){
            return JsonResult.error("群不存在，无法分组");
        }
        for (ExGroup exGroup : group) {
            ExGroup updateGroup=new ExGroup();
            updateGroup.setGroupId(exGroup.getGroupId());
            updateGroup.setGroupingId(groupingId);
            exGroupMapper.updateByPrimaryKeySelective(updateGroup);
        }
        return JsonResult.ok();
    }




    /***
     * @Description:
     * @Author: Wangxin
     * @date 2023-06-28 10:08
     * @Param urls: 图片合成
     * @return: java.lang.String
     **/
    public String picCompound(String imageUrl,String apiUrl) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            URIBuilder uriBuilder = new URIBuilder(apiUrl);
            uriBuilder.addParameter("urls", imageUrl);
            URI uri = uriBuilder.build();
            HttpPost httpPost = new HttpPost(uri);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);
            JSONObject jsonObject = JSON.parseObject(responseBody);
            String url = (String) jsonObject.get("data");
            httpClient.close();
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }






    @Override
    public JsonResult queryGroupList(GroupParamsDtoIn groupParamsDtoIn) {
        IUserDo user = loginService.selectUser();
        groupParamsDtoIn.setUserId(user.getUserId());
        groupParamsDtoIn.setExriseUserId(user.getExriseWxId());
        if(groupParamsDtoIn.getIsContain()==null){
            groupParamsDtoIn.setIsContain(0);
        }
        //查询群主体数据
        List<ExGroup> exGroupList=groupExMapper.queryGroupList(groupParamsDtoIn);

        if(CollectionUtils.isEmpty(exGroupList)){
               return JsonResult.ok(Collections.emptyList());
        }
        //获取群分组id
        List<Integer>  grouppingId=exGroupList.stream().map(ExGroup::getGroupingId).collect(Collectors.toList());

        Map<Integer, Groupping> grouppingMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(grouppingId)) {
            GrouppingCriteria grouppingCriteria = new GrouppingCriteria();
            grouppingCriteria.createCriteria().andGroupingIdIn(grouppingId).andIsDelEqualTo(0);
            List<Groupping> grouppingList = grouppingMapper.selectByExample(grouppingCriteria);
            Map<Integer, Groupping> map = grouppingList.stream().collect(Collectors.toMap(Groupping::getGroupingId, Function.identity()));
            grouppingMap.putAll(map);
        }
        //查询所在群成员
        List<Integer> groupId= exGroupList.stream().map(ExGroup::getGroupId).collect(Collectors.toList());
        //查询
        GroupCustCriteria groupCustCriteria=new GroupCustCriteria();
        groupCustCriteria.createCriteria().andCustWxIdEqualTo(groupParamsDtoIn.getExriseUserId()).andGroupIdIn(groupId);
        List<GroupCust> groupCustList=groupCustMapper.selectByExample(groupCustCriteria);
        Map<String, Integer> gourMap = groupCustList.stream()
                .collect(Collectors.toMap(groupCust -> groupCust.getGroupWxId()+"-"+groupCust.getCustWxId(), GroupCust::getIsAdmin));

        List<GroupDtoOut> groupDtoOutList=new ArrayList<>();
        for(ExGroup exGroup:exGroupList){
            Integer isAdmin = gourMap.get(exGroup.getGroupWxId() + "-" + groupParamsDtoIn.getExriseUserId());
            GroupDtoOut groupDtoOut=GrainBeanUtils.convert(exGroup,GroupDtoOut.class);
            //是否是群主
            if(groupParamsDtoIn.getExriseUserId().equals(exGroup.getCreateUserId())){
                groupDtoOut.setRole(3);
            }else if(isAdmin!=null && isAdmin ==1 ){
                groupDtoOut.setRole(2);
            }else {
                groupDtoOut.setRole(1);
            }
            if(exGroup.getGroupingId()!=null){
                Groupping groupping = grouppingMap.get(exGroup.getGroupingId());
                if(groupping!=null){
                    groupDtoOut.setGroupingName(groupping.getName());
                }
            }
            groupDtoOutList.add(groupDtoOut);
        }
        if(groupParamsDtoIn.getRole()!=null){
            if(groupParamsDtoIn.getRole()==0){
                groupDtoOutList=groupDtoOutList.stream().filter(x->x.getRole()==1).collect(Collectors.toList());
            }else if(groupParamsDtoIn.getRole()==1){
                groupDtoOutList=groupDtoOutList.stream().filter(x->x.getRole()==2||x.getRole()==3).collect(Collectors.toList());
            }else if(groupParamsDtoIn.getRole()==2) {
                groupDtoOutList=groupDtoOutList.stream().filter(x->x.getRole()==2).collect(Collectors.toList());
            }else {
                groupDtoOutList=groupDtoOutList.stream().filter(x->x.getRole()==3).collect(Collectors.toList());
            }
        }
        return JsonResult.ok(groupDtoOutList);
    }

    @Override
    public JsonResultT<CommonPage<GroupCust>> queryGroupCustList(GroupCustParamsDtoIn paramsDtoIn) {

        PageHelper.startPage(paramsDtoIn.getPageNum(),paramsDtoIn.getPageSize());
        List<GroupCust> groupCusts = groupExMapper.selectGroupCustByParams(paramsDtoIn);
        return JsonResultT.ok(CommonPage.restPage(groupCusts)) ;

    }

    @Override
    public JsonResult addGroupInviteTimes(String groupWxId,String userId) {
          //查询群数据
          ExGroupCriteria exGroupCriteria=new ExGroupCriteria();
          exGroupCriteria.createCriteria().andGroupWxIdEqualTo(groupWxId);
          List<ExGroup> exGroupList=exGroupMapper.selectByExample(exGroupCriteria);
          if(CollectionUtils.isEmpty(exGroupList)){
              return JsonResult.error("未查询到群数据信息");
          }
          ExGroup exGroup = exGroupList.get(0);
          //查询群成员数据
          GroupCustCriteria groupCustCriteria=new GroupCustCriteria();
          groupCustCriteria.createCriteria().andCustWxIdEqualTo(userId).andGroupIdEqualTo(exGroup.getGroupId());
          List<GroupCust> groupCustList=groupCustMapper.selectByExample(groupCustCriteria);
          if(!CollectionUtils.isEmpty(groupCustList)){
              GroupCust groupCust = groupCustList.get(0);
              Integer invitationsTimes = groupCust.getInvitationsTimes();
              GroupCust updateGroupCust=new GroupCust();
              updateGroupCust.setCustomerId(groupCust.getCustomerId());
              if(invitationsTimes==null){
                  updateGroupCust.setInvitationsTimes(1);
              }else {
                  updateGroupCust.setInvitationsTimes(invitationsTimes+1);
              }
              groupCustMapper.updateByPrimaryKeySelective(updateGroupCust);
          }
          return JsonResult.ok();
    }

    @Override
    public JsonResultT<?> saveGroupInviteConfig(GroupInviteConfigDtoIn groupInviteConfigDtoIn) {
        IUserDo iUserDo=loginService.selectUser();
        // 根据用户id查询数据库中是否已存在配置
        GroupInviteConfig existingConfig = findConfigByUserId(iUserDo.getUserId());
        if (existingConfig == null) {
            // 不存在配置，执行新增操作
            GroupInviteConfig newConfig = new GroupInviteConfig();
            newConfig.setUserId(iUserDo.getUserId());
            newConfig.setAutoStatus(groupInviteConfigDtoIn.getAutoStatus());
            newConfig.setDisturbStatus(groupInviteConfigDtoIn.getDisturbStatus());
            newConfig.setPassRate(groupInviteConfigDtoIn.getPassRate());
            groupInviteConfigMapper.insertSelective(newConfig);
        } else {
            // 存在配置，执行修改操作
            existingConfig.setPassRate(groupInviteConfigDtoIn.getPassRate());
            existingConfig.setDisturbStatus(groupInviteConfigDtoIn.getDisturbStatus());
            existingConfig.setPassRate(groupInviteConfigDtoIn.getPassRate());
            groupInviteConfigMapper.updateByPrimaryKey(existingConfig);
        }
        return JsonResultT.ok("操作成功");

    }

    @Override
    public JsonResultT<?> getGroupInviteConfig() {
        IUserDo iUserDo = loginService.selectUser();
        GroupInviteConfigCriteria groupInviteConfigCriteria=new GroupInviteConfigCriteria();
        groupInviteConfigCriteria.createCriteria().andUserIdEqualTo(iUserDo.getUserId());
        return JsonResultT.ok(groupInviteConfigMapper.selectByExampleForOne(groupInviteConfigCriteria));
    }

    public GroupInviteConfig findConfigByUserId(Integer userId) {
        // 调用数据访问层的方法，根据用户ID查询配置
        GroupInviteConfigCriteria groupInviteConfigCriteria=new GroupInviteConfigCriteria();
        groupInviteConfigCriteria.createCriteria().andUserIdEqualTo(userId);
        GroupInviteConfig groupInviteConfig=groupInviteConfigMapper.selectByExampleForOne(groupInviteConfigCriteria);
        return groupInviteConfig;
    }
}
