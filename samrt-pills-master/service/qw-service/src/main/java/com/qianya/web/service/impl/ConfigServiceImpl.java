package com.qianya.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.entity.*;
import com.qianya.mapper.ReplyConfigDetailMapper;
import com.qianya.mapper.ReplyConfigMapper;
import com.qianya.mapper.UserConfigMapper;
import com.qianya.mapper.ZombieConfigMapper;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.ZombieConfigDtoIn;
import com.qianya.model.out.ReplayDetailDtoOut;
import com.qianya.model.out.ReplyConfigDetailDtoOut;
import com.qianya.model.out.ReplyConfigDtoOut;
import com.qianya.model.out.ReplyDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.DateUtil;
import com.qianya.util.GrainBeanUtils;
import com.qianya.util.StringUtil;
import com.qianya.web.mapper.ConfigExMapper;
import com.qianya.web.service.ConfigService;
import com.qianya.model.in.ReplyConfigDetailDtoIn;
import com.qianya.model.in.ReplyConfigDtoIn;
import com.qianya.model.in.UserConfigDtoIn;
import com.qianya.web.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-24  17:13
 * @Description: 配置服务
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private UserConfigMapper userConfigMapper;
    @Autowired
    private ReplyConfigMapper replyConfigMapper;
    @Autowired
    private ReplyConfigDetailMapper replyConfigDetailMapper;
    @Autowired
    private ConfigExMapper configExMapper;
    @Autowired
    private ZombieConfigMapper zombieConfigMapper;
    @Autowired
    private LoginService loginService;


    @Override
    public UserConfig getByUserId(Integer userId) {
        UserConfigCriteria userConfigCriteria=new UserConfigCriteria();
        userConfigCriteria.createCriteria().andUserIdEqualTo(userId);
        List<UserConfig>  userConfigList=userConfigMapper.selectByExample(userConfigCriteria);
        if(!CollectionUtils.isEmpty(userConfigList)){
            return userConfigList.get(0);
        }
        return null;
    }

    @Override
    public JsonResultT<?> saveOrUpdateUserConfig(UserConfigDtoIn userConfigDtoIn,Integer userId) {
       // 判断是否存在用户配置，若存在则进行修改操作，否则进行新增操作
        Integer configId = hasUserConfig(userId);
        if (configId!=null) {
            updateUserConfig(userConfigDtoIn,configId);
        } else {
            addUserConfig(userConfigDtoIn,userId);
        }    
        return JsonResultT.ok();
    }

    @Override
    @Transactional
    public JsonResult saveOrUpdateReplyConfig(ReplyConfigDtoIn replyConfigDtoIn, Integer userId) {
        if (replyConfigDtoIn.getReplyConfigId()!=null && replyConfigDtoIn.getReplyConfigId()==0){
            replyConfigDtoIn.setReplyConfigId(null);
        }
        //修改前先删除
        if(replyConfigDtoIn.getReplyConfigId()!=null){
            //删除主表记录
            ReplyConfigCriteria replyConfigCriteria=new ReplyConfigCriteria();
            replyConfigCriteria.createCriteria().andConfigIdEqualTo(replyConfigDtoIn.getReplyConfigId());
            replyConfigMapper.deleteByExample(replyConfigCriteria);
            //删除明细表记录
            ReplyConfigDetailCriteria detailCriteria=new ReplyConfigDetailCriteria();
            detailCriteria.createCriteria().andConfigIdEqualTo(replyConfigDtoIn.getReplyConfigId());
            replyConfigDetailMapper.deleteByExample(detailCriteria);
        }
        String lowTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));

        ReplyConfig replyConfig=new ReplyConfig();
        replyConfig.setUserId(userId);
        replyConfig.setReplyStatus(0);
        replyConfig.setIsDel(0);
        replyConfig.setCreateTime(lowTime);
        if(StringUtil.isNotEmpty(replyConfigDtoIn.getExriseUserIds())){
            replyConfig.setExriseUserIds(replyConfigDtoIn.getExriseUserIds());
        }
        if(replyConfigDtoIn.getExriseUserType()!=null){
            replyConfig.setExriseUserType(replyConfigDtoIn.getExriseUserType());
        }
        if(replyConfigDtoIn.getCronyStauts()!=null){
            replyConfig.setCronyStauts(replyConfigDtoIn.getCronyStauts());
        }
        if(replyConfigDtoIn.getGroupStatus()!=null){
            replyConfig.setGroupStatus(replyConfigDtoIn.getGroupStatus());
        }
        if(replyConfigDtoIn.getReplyFrequency()!=null){
            replyConfig.setReplyFrequency(replyConfigDtoIn.getReplyFrequency());
        }
        if(replyConfigDtoIn.getKeywordsStatus()!=null){
            replyConfig.setKeywordsStatus(replyConfigDtoIn.getKeywordsStatus());
        }
        if(StringUtil.isNotEmpty(replyConfigDtoIn.getKeywords())){
            replyConfig.setKeywords(replyConfigDtoIn.getKeywords());
        }
        if(StringUtil.isNotEmpty(replyConfigDtoIn.getEqKeywords())){
            replyConfig.setEqKeywords(replyConfigDtoIn.getEqKeywords());
        }
        if(StringUtil.isNotEmpty(replyConfigDtoIn.getTriggerType())){
            replyConfig.setTriggerType(replyConfigDtoIn.getTriggerType());
        }
        if(StringUtil.isNotEmpty(replyConfigDtoIn.getCronyGroupSelfStauts())){
            replyConfig.setCronyGroupSelfStauts(replyConfigDtoIn.getCronyGroupSelfStauts());
        }
        if(StringUtil.isNotEmpty(replyConfigDtoIn.getReplyType())){
            replyConfig.setReplyType(replyConfigDtoIn.getReplyType());
        }
        if(replyConfigDtoIn.getSort()!=null){
            replyConfig.setSort(replyConfigDtoIn.getSort());
        }
        //明细
        List<ReplyConfigDetailDtoIn> detailList = replyConfigDtoIn.getDetailList();
        if(CollectionUtils.isEmpty(detailList)){
            return JsonResult.error("请传入自动回复内容");
        }

        if (!CollectionUtils.isEmpty(detailList)) {
            for (ReplyConfigDetailDtoIn itemEntity : detailList) {

                Integer itemType = itemEntity.getMessageType();
                if (itemType == null) {
                    return JsonResult.error("方案明细参数中的itemType不能为空");
                }
                // 根据itemType进行对应字段的校验
                switch (itemType) {
                    case 1:
                        // 文本类型校验逻辑
                        // 校验itemContent字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getItemContent())) {
                            return JsonResult.error("消息内容不为空");
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        // 视频类型校验逻辑
                        // 校验fileUrl字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getFileUrl())) {
                            return JsonResult.error("文件地址不能为空");
                        }
                        break;
                    case 5:
                        // 卡片消息类型校验逻辑
                        // 校验cardTitle字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getCardTitle())) {
                            return JsonResult.error("卡片标题不能为空");
                        }
                        // 校验cardContent字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getCardTitle())) {
                            return JsonResult.error("卡片内容不能为空");
                        }
                        // 校验cardImgUrl字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getCardImgUrl())) {
                            return JsonResult.error("卡片图片地址不能为空");
                        }
                        // 校验cardImgUrl字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getCardUrl())) {
                            return JsonResult.error("卡片链接不能为空");
                        }
                        break;
                    case 6:
                        // 小程序类型校验逻辑
                        // 校验userName字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getUserName())) {
                            return JsonResult.error("小程序用户名不能为空");
                        }
                        // 校验appId字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getAppId())) {
                            return JsonResult.error("小程序AppId不能为空");
                        }
                        // 校验title字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getTitle())) {
                            return JsonResult.error("小程序标题不能为空");
                        }
                        // 校验pagePath字段是否为空
                        if (StringUtil.isEmpty(itemEntity.getPagePath())) {
                            return JsonResult.error("小程序页面路径不能为空");
                        }
                        if (StringUtil.isEmpty(itemEntity.getFileId())) {
                            return JsonResult.error("小程序fileId不能为空");
                        }
                        if (StringUtil.isEmpty(itemEntity.getAesKey())) {
                            return JsonResult.error("小程序小程序aes_key不能为空");
                        }
                        if (StringUtil.isEmpty(itemEntity.getMd5())) {
                            return JsonResult.error("小程序md5不能为空");
                        }
                        if (StringUtil.isEmpty(itemEntity.getSize())) {
                            return JsonResult.error("小程序size不能为空");
                        }
                        break;
                    case 7:
                        // 视频号类型校验逻辑
                        // 校验nickName字段是否为空或空字符串
                        if (StringUtil.isEmpty(itemEntity.getNickName())) {
                            return JsonResult.error("视频号昵称不能为空");
                        }
                        // 校验desc字段是否为空或空字符串
                        if (StringUtil.isEmpty(itemEntity.getDesc())) {
                            return JsonResult.error("视频号描述不能为空");
                        }
                        // 校验avatar字段是否为空或空字符串
                        if (StringUtil.isEmpty(itemEntity.getAvatar())) {
                            return JsonResult.error("视频号头像不能为空");
                        }
                        // 校验coverUrl字段是否为空或空字符串
                        if (StringUtil.isEmpty(itemEntity.getCoverUrl())) {
                            return JsonResult.error("视频号封面地址不能为空");
                        }
                        // 校验feedType字段是否为空或空字符串
                        if (StringUtil.isEmpty(itemEntity.getFeedType())) {
                            return JsonResult.error("视频号feed_type不能为空");
                        }
                        // 校验thumbUrl字段是否为空或空字符串
                        if (StringUtil.isEmpty(itemEntity.getThumbUrl())) {
                            return JsonResult.error("视频号thumb_url不能为空");
                        }
                        // 校验url字段是否为空或空字符串
                        if (StringUtil.isEmpty(itemEntity.getUrl())) {
                            return JsonResult.error("视频号url不能为空");
                        }
                        // 校验extras字段是否为空或空字符串
                        if (StringUtil.isEmpty(itemEntity.getExtras())) {
                            return JsonResult.error("视频号extras不能为空");
                        }
                        break;
                    case 8:
                        // 邀请入群类型校验逻辑
                        // 校验groupIds字段是否为空
                        if (itemEntity.getGroupId() == null) {
                            return JsonResult.error("邀请入群ID不能为空");
                        }
                        break;
                    default:
                        return JsonResult.error("未知的itemType类型");
                }
            }
        }
        List<ReplyConfigDetail> replyConfigDetailList = GrainBeanUtils.convertLists(detailList, ReplyConfigDetail.class, (x, y) -> {
            if (StringUtil.isNotEmpty(y.getSize())) {
                x.setXcxSize(y.getSize());
            }
            if (StringUtil.isNotEmpty(y.getDesc())) {
                x.setVedioDesc(y.getDesc());
            }
            if (StringUtil.isNotEmpty(y.getItemContent())) {
                x.setContent(y.getItemContent());
            }
            if (y.getWaitSeconds()!=null) {
                x.setSeconds(y.getWaitSeconds());
            }
        });
        StringBuilder stringBuilder=new StringBuilder();
        for(ReplyConfigDetail replyConfigDetail:replyConfigDetailList){
            if(replyConfigDetail.getMessageType()==1){
                stringBuilder.append(replyConfigDetail.getContent());
                stringBuilder.append(",");
            }else if(replyConfigDetail.getMessageType()==2){
                stringBuilder.append("图片,");
            }else if(replyConfigDetail.getMessageType()==3){
                stringBuilder.append("动图,");
            }else if(replyConfigDetail.getMessageType()==4){
                stringBuilder.append("视频,");
            }else if(replyConfigDetail.getMessageType()==5){
                stringBuilder.append("卡片,");
            }else if(replyConfigDetail.getMessageType()==6){
                stringBuilder.append("小程序,");
            }else if(replyConfigDetail.getMessageType()==7){
                stringBuilder.append("视频号,");
            }else {
                stringBuilder.append("邀请入群,");
            }
        }
        String content=stringBuilder.toString();
        replyConfig.setReplyContent(content.substring(0,content.length() - 1));
        //保存主表记录
        replyConfigMapper.insertSelective(replyConfig);
        Integer replyConfigId=replyConfig.getConfigId();
        if(!CollectionUtils.isEmpty(replyConfigDetailList)){
            for(ReplyConfigDetail replyConfigDetail:replyConfigDetailList){
                replyConfigDetail.setConfigId(replyConfigId);
                replyConfigDetail.setIsDel(0);
            }
            configExMapper.insertBatch(replyConfigDetailList);
        }
        return JsonResult.ok();
    }


    @Override
    public JsonResult deleteReplyConfig(List<Integer> configIds) {
        // 根据方案ID删除明细表中的记录
        ReplyConfigCriteria replyConfigCriteria=new ReplyConfigCriteria();
        replyConfigCriteria.createCriteria().andConfigIdIn(configIds);
        ReplyConfig deleteConfig=new ReplyConfig();
        deleteConfig.setIsDel(1);
        replyConfigMapper.updateByExampleSelective(deleteConfig,replyConfigCriteria);
        //删除明细
        ReplyConfigDetailCriteria replyConfigDetailCriteria=new ReplyConfigDetailCriteria();
        replyConfigDetailCriteria.createCriteria().andConfigIdIn(configIds);
        ReplyConfigDetail configDetail=new ReplyConfigDetail();
        configDetail.setIsDel(1);
        replyConfigDetailMapper.updateByExampleSelective(configDetail,replyConfigDetailCriteria);
       return JsonResult.ok("自动回复配置及明细记录删除成功");

    }


    private Integer hasUserConfig(Integer userId) {
        UserConfigCriteria userConfigCriteria=new UserConfigCriteria();
        userConfigCriteria.createCriteria().andUserIdEqualTo(userId);
        List<UserConfig>  userConfigList=userConfigMapper.selectByExample(userConfigCriteria);
        if(!CollectionUtils.isEmpty(userConfigList)){
            UserConfig userConfig = userConfigList.get(0);
            return userConfig.getConfigId();
        }
        return null;
    }

    private void addUserConfig(UserConfigDtoIn userConfigDtoIn,Integer userId) {
         UserConfig userConfig=new UserConfig();
         userConfig.setUserId(userId);
        if (userConfigDtoIn.getAutoStatus() != null) {
            userConfig.setAutoStatus(userConfigDtoIn.getAutoStatus());
        }
        if (userConfigDtoIn.getWorkStartTime() != null) {
            userConfig.setWorkStartTime(userConfigDtoIn.getWorkStartTime());
        }
        if (userConfigDtoIn.getWorkEndTime() != null) {
            userConfig.setWorkEndTime(userConfigDtoIn.getWorkEndTime());
        }
        if (userConfigDtoIn.getMaxNum() != null) {
            userConfig.setMaxNum(userConfigDtoIn.getMaxNum());
        }
        if (StringUtil.isEmpty(userConfig.getWaitSeconds())) {
            userConfig.setWaitSeconds(userConfigDtoIn.getWaitSeconds());
        }
        if (StringUtil.isEmpty(userConfig.getMsgWaitSeconds())) {
            userConfig.setMsgWaitSeconds(userConfigDtoIn.getMsgWaitSeconds());
        }
        if (StringUtil.isEmpty(userConfig.getVerifyKeywords())) {
            userConfig.setVerifyKeywords(userConfigDtoIn.getVerifyKeywords());
        }
        if (StringUtil.isEmpty(userConfig.getVerifyNoKeywords())) {
            userConfig.setVerifyNoKeywords(userConfigDtoIn.getVerifyNoKeywords());
        }
        if (StringUtil.isEmpty(userConfig.getNickNameNoKeywords())) {
            userConfig.setNickNameNoKeywords(userConfigDtoIn.getNickNameNoKeywords());
        }
        if (userConfigDtoIn.getExriseAutoStatus()!=null) {
            userConfig.setExriseAutoStatus(userConfigDtoIn.getExriseAutoStatus());
        }
        userConfigMapper.insertSelective(userConfig);
    }

    private void updateUserConfig(UserConfigDtoIn userConfigDtoIn,Integer configId) {
        UserConfig userConfig=new UserConfig();
        userConfig.setConfigId(configId);
        userConfig.setAutoStatus(userConfigDtoIn.getAutoStatus());
        userConfig.setWorkStartTime(userConfigDtoIn.getWorkStartTime());
        userConfig.setWorkEndTime(userConfigDtoIn.getWorkEndTime());
        userConfig.setMaxNum(userConfigDtoIn.getMaxNum());
        userConfig.setWaitSeconds(userConfigDtoIn.getWaitSeconds());
        userConfig.setMsgWaitSeconds(userConfigDtoIn.getMsgWaitSeconds());
        userConfig.setVerifyKeywords(userConfigDtoIn.getVerifyKeywords());
        userConfig.setVerifyNoKeywords(userConfigDtoIn.getVerifyNoKeywords());
        userConfig.setExriseAutoStatus(userConfigDtoIn.getExriseAutoStatus());
        userConfig.setNickNameNoKeywords(userConfigDtoIn.getNickNameNoKeywords());
        userConfigMapper.updateByPrimaryKeySelective(userConfig);
    }


    public JsonResultT<CommonPage<ReplyConfigDtoOut>>  replyConfigPage(String  epriseWxIds,String serachContent,Integer pageNum,Integer pageSize){
         IUserDo user = loginService.selectUser();
        List<String> epriseWxIdList = null;
        if (StringUtils.isNotEmpty(epriseWxIds)) {

            String[] epriseWxIdArr = epriseWxIds.split(",");
            epriseWxIdList= Arrays.asList(epriseWxIdArr);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<ReplyConfigDtoOut> replyConfigDtoOuts = configExMapper.replyConfigList(user.getUserId(), epriseWxIdList, serachContent);
        return JsonResultT.ok(CommonPage.restPage(replyConfigDtoOuts)) ;

    }

    @Override
    public JsonResultT<List<ReplyDtoOut>> getReplyConfig() {
      IUserDo user = loginService.selectUser();
        //查询未删除的自动回复
        ReplyConfigCriteria replyConfigCriteria = new ReplyConfigCriteria();
        replyConfigCriteria.createCriteria().andUserIdEqualTo(user.getUserId()).andIsDelEqualTo(0).andReplyStatusEqualTo(0);
        List<ReplyConfig> replyConfigList = replyConfigMapper.selectByExample(replyConfigCriteria);
        if (CollectionUtils.isEmpty(replyConfigList)) {
            return JsonResultT.ok(Collections.emptyList());
        }
        //获取明细数据
        List<Integer> replyConfigIds = replyConfigList.stream().map(ReplyConfig::getConfigId).collect(Collectors.toList());
        ReplyConfigDetailCriteria replyConfigDetailCriteria = new ReplyConfigDetailCriteria();
        replyConfigDetailCriteria.createCriteria().andConfigIdIn(replyConfigIds).andIsDelEqualTo(0);
        replyConfigCriteria.setOrderByClause("sort desc");
        List<ReplyConfigDetail> replyConfigDetailList = replyConfigDetailMapper.selectByExample(replyConfigDetailCriteria);
        //根据repalyConfigId分组
        Map<Integer, List<ReplyConfigDetail>> replyMap = replyConfigDetailList.stream().collect(Collectors.groupingBy(ReplyConfigDetail::getConfigId));
        List<ReplyDtoOut> replyDtoOutList = new ArrayList<>();
        for (ReplyConfig replyConfig : replyConfigList) {

            ReplyConfigDtoOut replyConfigDtoOut = new ReplyConfigDtoOut();
            replyConfigDtoOut.setConfigId(replyConfig.getConfigId());
            replyConfigDtoOut.setKeywords(replyConfig.getKeywords());
            replyConfigDtoOut.setEqKeywords(replyConfig.getEqKeywords());
            replyConfigDtoOut.setTriggerType(replyConfig.getTriggerType());
            replyConfigDtoOut.setReplyFrequency(replyConfig.getReplyFrequency());
            replyConfigDtoOut.setMatchType(replyConfig.getKeywordsStatus());
            replyConfigDtoOut.setApplyExriseWx(replyConfig.getExriseUserType());
            replyConfigDtoOut.setApplyFriends(replyConfig.getCronyStauts());
            replyConfigDtoOut.setApplyGroup(replyConfig.getGroupStatus());
            replyConfigDtoOut.setSort(replyConfig.getSort());
            replyConfigDtoOut.setReplyType(replyConfig.getReplyType());
            ReplyDtoOut replyDtoOut = new ReplyDtoOut();
            replyDtoOut.setReplyConfigDtoOut(replyConfigDtoOut);
            //获取明细
            List<ReplyConfigDetail> detailList = replyMap.get(replyConfig.getConfigId());
            List<ReplyConfigDetailDtoOut> detailDtoOuts = GrainBeanUtils.convertLists(detailList, ReplyConfigDetailDtoOut.class ,(x, y) -> {
                if (StringUtil.isNotEmpty(y.getXcxSize())) {
                    x.setSize(y.getXcxSize());
                }
                if (StringUtil.isNotEmpty(y.getVedioDesc())) {
                    x.setDesc(y.getVedioDesc());
                }
                if (StringUtil.isNotEmpty(y.getContent())) {
                    x.setItemContent(y.getContent());
                }
            });
            if (!CollectionUtils.isEmpty(detailList)) {
                replyDtoOut.setReplyConfigDetailDtoOuts(detailDtoOuts);
            }
            replyDtoOutList.add(replyDtoOut);
        }
        return JsonResultT.ok(replyDtoOutList);
    }

    @Override
    public JsonResult saveOrUpdateZombieConfig(ZombieConfigDtoIn configDtoIn) {
        String nowTime=DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
       IUserDo user = loginService.selectUser();
        //查询是否有配置
        ZombieConfigCriteria zombieConfigCriteria=new ZombieConfigCriteria();
        zombieConfigCriteria.createCriteria().andUserIdEqualTo(user.getUserId());
        List<ZombieConfig> zombieConfigs = zombieConfigMapper.selectByExample(zombieConfigCriteria);

        if (!CollectionUtils.isEmpty(zombieConfigs)) {
            // 执行修改操作
            // ...
            ZombieConfig zombieConfig= zombieConfigs.get(0);

            ZombieConfig updateConfig=GrainBeanUtils.convert(configDtoIn,ZombieConfig.class);
            updateConfig.setConfigId(zombieConfig.getConfigId());
            updateConfig.setUpdateTime(nowTime);
            zombieConfigMapper.updateByPrimaryKeySelective(updateConfig);
        } else {
            // 执行新增操作
            // ...

            ZombieConfig zombieConfig=GrainBeanUtils.convert(configDtoIn,ZombieConfig.class);
            zombieConfig.setCreateTime(nowTime);
            zombieConfig.setUserId(user.getUserId());
            zombieConfigMapper.insertSelective(zombieConfig);
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult getZombieConfig() {
        IUserDo user=loginService.selectUser();
        ZombieConfigCriteria zombieConfigCriteria=new ZombieConfigCriteria();
        zombieConfigCriteria.createCriteria().andUserIdEqualTo(user.getUserId());
        List<ZombieConfig> zombieConfigList=zombieConfigMapper.selectByExample(zombieConfigCriteria);
        if(!CollectionUtils.isEmpty(zombieConfigList)){
            return JsonResult.ok(zombieConfigList.get(0));
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResult updateZombieConfigLastTime(String executeTime) {
        IUserDo user = loginService.selectUser();
        ZombieConfigCriteria zombieConfigCriteria = new ZombieConfigCriteria();
        zombieConfigCriteria.createCriteria().andUserIdEqualTo(user.getUserId());
        List<ZombieConfig> zombieConfigList = zombieConfigMapper.selectByExample(zombieConfigCriteria);
        if (!CollectionUtils.isEmpty(zombieConfigList)) {
            ZombieConfig zombieConfig = zombieConfigList.get(0);
            ZombieConfig updateConfig = new ZombieConfig();
            updateConfig.setConfigId(zombieConfig.getConfigId());
            updateConfig.setLastTime(executeTime);
            zombieConfigMapper.updateByPrimaryKeySelective(zombieConfig);
        }
        return JsonResult.ok();
    }

    @Override
    public JsonResultT<?> replyConfigSwitch(Integer configId, Integer status) {
        ReplyConfig replyConfig = new ReplyConfig();
        replyConfig.setConfigId(configId);
        replyConfig.setReplyStatus(status);
        replyConfigMapper.updateByPrimaryKeySelective(replyConfig);
        return JsonResultT.ok();
    }

    @Override
    public JsonResultT<?> getReplyConfigDetail(Integer configId) {
        ReplyConfig replyConfig=replyConfigMapper.selectByPrimaryKey(configId);
        if(replyConfig==null){
            return JsonResultT.error("智能应答不存在");
        }
        //查询回复内容
        ReplyConfigDetailCriteria replyConfigDetailCriteria=new ReplyConfigDetailCriteria();
        replyConfigDetailCriteria.createCriteria().andConfigIdEqualTo(configId);
        List<ReplyConfigDetail> replyConfigDetailList=replyConfigDetailMapper.selectByExample(replyConfigDetailCriteria);

        List<ReplayDetailDtoOut> detailDtoOutList=GrainBeanUtils.convertLists(replyConfigDetailList,ReplayDetailDtoOut.class,(x, y)->{
               x.setItemContent(y.getContent());
               x.setItemId(y.getDetailId());
               x.setSize(y.getXcxSize());
               x.setVideoDesc(y.getVedioDesc());
               x.setSchemeId(y.getConfigId());
               x.setWaitSeconds(y.getSeconds());
               x.setGroupIds(y.getGroupId());
        });

        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("replyConfig",replyConfig);
        resultMap.put("detailList",detailDtoOutList);
        return JsonResultT.ok(resultMap);
    }

}