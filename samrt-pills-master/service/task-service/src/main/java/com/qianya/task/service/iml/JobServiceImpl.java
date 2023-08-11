package com.qianya.task.service.iml;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qianya.annotations.Log;
import com.qianya.common.JsonResultT;
import com.qianya.constant.CommConstant;
import com.qianya.constant.MqConstant;
import com.qianya.entity.*;
import com.qianya.entity.mongo.MassCustRelationMoEntity;
import com.qianya.entity.mongo.MassSendingMainMoEntity;
import com.qianya.entity.mongo.MassSendingRecordMoEntity;
import com.qianya.mapper.*;
import com.qianya.task.comm.RabbitMqUtils;
import com.qianya.task.mapper.MassSendingExMapper;
import com.qianya.task.service.JobService;
import com.qianya.util.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private MassSendingExMapper massSendingExMapper;
    @Autowired
    private MassSendingDetailMapper massSendingDetailMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private IdWorker idWorker;
    @Resource
    private RedisTemplate<String,Integer> redisTemplate;
    @Autowired
    private PullGroupMapper pullGroupMapper;
    @Autowired
    private PullConfigMapper pullConfigMapper;
    @Autowired
    private PullGroupOpDetailMapper pullGroupOpDetailMapper;
    @Autowired
    private PullCustRelationMapper pullCustRelationMapper;
    @Autowired
    private CricleFriendsMapper  cricleFriendsMapper;
    @Autowired
    private CricleDetailMapper cricleDetailMapper;
    @Override
    public void groupSendRes() {
        LogUtil.info(getClass(),"执行群发结果检测");
        String key=CommConstant.redisKey.miss_send;
        Set<String> keys = redisTemplate.keys(key+"*");

        LogUtil.info(getClass(), keys.toString());

        String nowFormat = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        for (String str : keys) {
            Integer val= redisTemplate.boundValueOps(str).get();
            Long mainId = Long.valueOf(str.split(key)[1]);
            MassSendingMainMoEntity sendingMain = mongoTemplate.findById(mainId, MassSendingMainMoEntity.class, "mass_sending_main");
            if (sendingMain!=null){
                if (!sendingMain.getCompleteCount().equals(val)){
                    Update update = Update.update("complete_count", val);
                    if (sendingMain.getSendCount().equals(val)){
                        update.set("status",1);
                        update.set("complete_time",nowFormat);
                    }
                    mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(mainId)),update, MassSendingMainMoEntity.class,"mass_sending_main");
                }
            }
        }

         
    }

    @Override
    public void groupSendCheck() {
        LogUtil.info(getClass(),"执行群发检测");
        String createTime = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        LocalDateTime now = LocalDateTime.now();

        //获得当天的天数
        int monthDay = now.getDayOfMonth();
        //获得当周的天数
        int weekDay = now.getDayOfWeek().getValue();

        List<MassSending> massSendList=massSendingExMapper.findMassSendList(createTime);

        LogUtil.info(getClass(), String.valueOf(massSendList.size()));
        LogUtil.info(getClass(),"massSendList："+massSendList);

        if (massSendList.size()==0){
            return;
        }
        Set<Integer> massIds = massSendList.stream().map(massSending -> massSending.getMassId()).collect(Collectors.toSet());
        //
        String nowFormat = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD);
        //查询是否发过
        List<MassSendingMainMoEntity> yjSendList = mongoTemplate.find(new Query(Criteria.where("mass_id").in(massIds).and("send_time").gt(nowFormat)), MassSendingMainMoEntity.class, "mass_sending_main");
        for (MassSendingMainMoEntity entity : yjSendList) {
            massIds.remove(entity.getMassId());
        }
        if (massIds.size()==0){
            return;
        }

        for (MassSending sending : massSendList) {
            if ( sending.getStopTimeStatus()!=null && sending.getStopTimeStatus().equals(1) &&  StringUtil.isNotEmpty(sending.getStopTime())){
                List<String> stopTime = Arrays.stream(sending.getStopTime().split(",")).filter(StringUtil::isNotEmpty).collect(Collectors.toList());
                String stop1 = now.format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD + " " + stopTime.get(0)));
                String stop2 = now.format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD + " " + stopTime.get(1)));
                if (createTime.compareTo(stop1)>=0 && stop2.compareTo(createTime)>=0){
                    massIds.remove(sending.getMassId());
                    continue;
                }
            }
            //时间处理
            if (sending.getMassType()==1){
                switch (sending.getIntervalUnit()){
                    case 1:
                        String day = now.format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD + " " + sending.getUnitSendTime()));
                        if (day.compareTo(createTime)>0){
                            massIds.remove(sending.getMassId());
                        }
                        break;
                    case 2:
                        String[] split = sending.getUnitSendTime().split("-");
                        Set<Integer> days = Arrays.stream(split[0].split(",")).filter(StringUtil::isNotEmpty).map(Integer::valueOf).collect(Collectors.toSet());
                        if (days.contains(weekDay)){
                            String newTimes = now.format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD + " " + split[1]));
                            if (newTimes.compareTo(createTime)>0){
                                massIds.remove(sending.getMassId());
                            }
                        }
                        break;
                    case 3:
                        String[] split2 = sending.getUnitSendTime().split("-");
                        Set<Integer> days2 = Arrays.stream(split2[0].split(",")).filter(StringUtil::isNotEmpty).map(Integer::valueOf).collect(Collectors.toSet());
                        if (days2.contains(monthDay)){
                            String newTimes = now.format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD + " " + split2[1]));
                            if (newTimes.compareTo(createTime)>0){
                                massIds.remove(sending.getMassId());
                            }
                        };
                        break;
                    default:massIds.remove(sending.getMassId());
                }
            }
        }
        LogUtil.info(getClass(), String.valueOf(massIds.size()));
        if (massIds.size()==0){
            return;
        }

        MassSendingDetailCriteria detailCriteria=new MassSendingDetailCriteria();

        detailCriteria.createCriteria().andMassIdIn(new ArrayList<>(massIds));

        List<MassSendingDetail> massSendingDetails = massSendingDetailMapper.selectByExample(detailCriteria);

        Map<Integer, MassSending> massMap = massSendList.stream().collect(Collectors.toMap(MassSending::getMassId, info -> info));

        Map<Integer, List<MassSendingDetail>> massDetailMap = massSendingDetails.stream().collect(Collectors.groupingBy(MassSendingDetail::getMassId));
        //查询指定的信息
        List<MassCustRelationMoEntity> sendList = mongoTemplate.find(new Query(Criteria.where("mass_id").in(massIds)), MassCustRelationMoEntity.class, "mass_cust_relation");

        LogUtil.info(getClass(),"sendList:"+sendList);
        Map<Integer, List<MassCustRelationMoEntity>> relationMap = sendList.stream().collect(Collectors.groupingBy(MassCustRelationMoEntity::getMassId));

        List<MassSendingRecordMoEntity> recordEntities=new ArrayList<>();
        for (Map.Entry<Integer, List<MassCustRelationMoEntity>> entry : relationMap.entrySet()) {
            //每个人都需要发送这些内容
            MassSending massSending = massMap.get(entry.getKey());
            MassSendingMainMoEntity main=new MassSendingMainMoEntity();
            main.setRecordId(idWorker.nextId());
            main.setMassId(entry.getKey());
            main.setSendTime(createTime);
            main.setSendCount(entry.getValue().size());
            main.setMassType(massSending.getMassCommonType());
            main.setCompleteCount(0);
            main.setUserId(massSending.getUserId());
            main.setExriseWxId(massSending.getExexriseUserId());
            main.setMassName(massSending.getMassName());
            massSendingExMapper.updateSendRes(entry.getKey());
            mongoTemplate.insert(main,"mass_sending_main");
            for (MassCustRelationMoEntity massCustRelationMoEntity : entry.getValue()) {
                MassSendingRecordMoEntity moEntity=new MassSendingRecordMoEntity();
                moEntity.setRecordId(idWorker.nextId());
                moEntity.setStatus(0);
                moEntity.setSendTime(createTime);
                moEntity.setMassId(main.getMassId());
                moEntity.setMainId(main.getRecordId());
                moEntity.setCustomerWxId(massCustRelationMoEntity.getWorkId());
                moEntity.setWorkType(massCustRelationMoEntity.getWorkType());
                recordEntities.add(moEntity);
                if (recordEntities.size()>=1000){
                    //插入不售卖地区变更记录
                    BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, "mass_sending_record");
                    bulkOperations.insert(recordEntities);
                    bulkOperations.execute();
                    recordEntities.clear();
                }
            }
        }
        if (recordEntities.size()>0){
            //插入变更记录
            BulkOperations bulkOperations2 = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, "mass_sending_record");
            bulkOperations2.insert(recordEntities);
            bulkOperations2.execute();
        }



        //ExecutorService service = Executors.newFixedThreadPool(5);//线程池
        for (Map.Entry<Integer, List<MassCustRelationMoEntity>> entry : relationMap.entrySet()) {
            MassSending massSending = massMap.get(entry.getKey());
            int num=0;
            //每个人都需要发送这些内容
            for (MassCustRelationMoEntity entity : entry.getValue()) {
                //service.submit(() -> {
                if (StringUtil.isNotEmpty(massSending.getCustomerInterval())){
                    String[] str = massSending.getCustomerInterval().split(",");
                    num =num+RandUtils.getNum(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                }
                    List<MassSendingDetail> list = massDetailMap.get(entry.getKey());
                    int waitSeconds=0;
                    for (MassSendingDetail detail : list) {
                        if (detail.getWaitSeconds()!=null){
                            waitSeconds=waitSeconds+detail.getWaitSeconds()+num;
                        }
                        JSONObject object=new JSONObject();
                        object.put("missDetail",detail);
                        object.put("workId",entity.getWorkId());
                        object.put("massCommonType",massSending.getMassCommonType());
                        object.put("workType",entity.getWorkType());
                        object.put("userId",massSending.getUserId());
                        int day=waitSeconds*1000;
                        LogUtil.info(getClass(),"延迟"+day);
                        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_custom_exchange, MqConstant.routeKey.yc_send_miss_key, object.toJSONString(), message -> {
                            //设置发送消息的延迟时间
                            message.getMessageProperties().setDelay(day);
                            return message;
                        });

                    }

                //});
            }
        }
        //service.shutdown();
    }
    @Override
    public void pullGroupSendRes() {
        LogUtil.info(getClass(),"执行群发结果检测");
        String key=CommConstant.redisKey.pull_group;
        Set<String> keys = redisTemplate.keys(key+"*");
        String nowFormat = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        for (String str : keys) {
            Integer val= redisTemplate.boundValueOps(str).get();
            Integer pullId = Integer.parseInt(str.split(key)[1]);
            PullGroup pullGroup=pullGroupMapper.selectByPrimaryKey(pullId);
            if(pullGroup.getSendCount().equals(val)){
                pullGroup.setStatus(2);
                pullGroup.setCompleteTime(nowFormat);
            }
            pullGroup.setCompleteCount(val);

        }
    }

    @Override
    public void pullGroupSendCheck() {
        //查询正在执行中的任务

        PullGroupCriteria pullGroupCriteria=new PullGroupCriteria();
        pullGroupCriteria.createCriteria().andStatusEqualTo(1);
        List<PullGroup> pullGroups=pullGroupMapper.selectByExample(pullGroupCriteria);
        //查询配置
        if(CollectionUtils.isEmpty(pullGroups)){
            return;
        }
        List<Integer> userIds=pullGroups.stream().map(PullGroup::getUserId).collect(Collectors.toList());

        PullConfigCriteria pullConfigCriteria=new PullConfigCriteria();
        pullConfigCriteria.createCriteria().andUserIdIn(userIds);
        List<PullConfig> pullGroupList=pullConfigMapper.selectByExample(pullConfigCriteria);
        Map<Integer, PullConfig> pullConfigMap = pullGroupList.stream().collect(Collectors.toMap(PullConfig::getUserId, Function.identity()));

        //多线程处理
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<Boolean>> futures = new ArrayList<>();
        for (PullGroup pullGroup : pullGroups) {
            futures.add(service.submit(
                    () -> pullGooupHander(pullGroup,pullConfigMap)
            ));
        }
        service.shutdown();
        futures.forEach(future -> {
            try {
                future.get();
            }catch (Exception e){
                LogUtil.error(getClass(),e);
            }
        });


    }

    @Override
    public void circleSendCheck() {


        CricleFriendsCriteria cricleFriendsCriteria=new CricleFriendsCriteria();
        cricleFriendsCriteria.createCriteria().andStatusEqualTo(1);

        // 查询所有执行中的主表记录
        List<CricleFriends> executingCircles = cricleFriendsMapper.selectByExample(cricleFriendsCriteria);
        if(CollectionUtils.isEmpty(executingCircles)){
            return;
        }
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        String nowTime =DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);

        // 遍历执行中的主表记录
        for (CricleFriends circle : executingCircles) {
            executorService.submit(() -> processCircle(circle,nowTime));
        }
        // 关闭线程池
        executorService.shutdown();


    }


    private void processCircle(CricleFriends circle,String nowTime) {
        int sendType = circle.getSendType();

        if (sendType == 1) {
            processSingleSend(circle,nowTime);
        } else if (sendType == 2) {
            processLoopSend(circle,nowTime);
        }
    }


    private void processSingleSend(CricleFriends circle,String nowTime) {
        // 获取发送时间
        String sendTime = circle.getSendTime().substring(0, 16);
        String nowDate = nowTime.substring(0, 16);
        if (sendTime.equals(nowDate)) {
            // 处理明细
            CricleDetailCriteria cricleDetailCriteria = new CricleDetailCriteria();
            cricleDetailCriteria.createCriteria().andCricleIdEqualTo(circle.getCircleId());
            List<CricleDetail> circleDetails = cricleDetailMapper.selectByExample(cricleDetailCriteria);
            cricleDetailCriteria.setOrderByClause("sort desc");
            sendCircleDetails(circle,circleDetails,nowTime);
        }
    }


    private void sendCircleDetails(CricleFriends cricleFriends,List<CricleDetail> circleDetails,String nowTime) {

          //获取发的内容
          List<CricleDetail>  sendList=circleDetails.stream().filter(x->x.getDetailType()==1).collect(Collectors.toList());
          for(CricleDetail cricleDetail:sendList){
              JSONObject object=new JSONObject();
              object.put("cricleDetail",cricleDetail);
              object.put("userId",cricleFriends.getUserId());
              int day=1000;
              rabbitTemplate.convertAndSend(MqConstant.exchange.mall_custom_exchange, MqConstant.routeKey.cricle_send_task_key, object.toJSONString(), message -> {
                  //设置发送消息的延迟时间
                  message.getMessageProperties().setDelay(day);
                  return message;
              });
          }
          //获取评论内容
          List<CricleDetail> commentList=circleDetails.stream().filter(x->x.getDetailType()==2).collect(Collectors.toList());
          if(!CollectionUtils.isEmpty(commentList)){
              commentList.sort(Comparator.comparing(CricleDetail::getSort));
              int waitSeconds=0;
              for(CricleDetail cricleDetail:sendList){
                  if (cricleDetail.getWaitSeconds()!=null){
                      waitSeconds=waitSeconds+cricleDetail.getWaitSeconds();
                  }
                  JSONObject object=new JSONObject();
                  object.put("cricleDetail",cricleDetail);
                  object.put("userId",cricleFriends.getUserId());
                  int day=waitSeconds*1000;
                  rabbitTemplate.convertAndSend(MqConstant.exchange.mall_custom_exchange, MqConstant.routeKey.cricle_send_task_key, object.toJSONString(), message -> {
                      //设置发送消息的延迟时间
                      message.getMessageProperties().setDelay(day);
                      return message;
                  });
              }
          }
          //更新主表记录
          Integer executeTimes=cricleFriends.getExecuteTimes()+1;
          CricleFriends updateCricleFriends=new CricleFriends();
          updateCricleFriends.setCircleId(cricleFriends.getCircleId());
          updateCricleFriends.setExecuteTimes(cricleFriends.getExecuteTimes()+1);
          updateCricleFriends.setLastExecustTime(nowTime);
          if(executeTimes.equals(cricleFriends.getSendNum())){
                 updateCricleFriends.setStatus(2);
          }
          cricleFriendsMapper.updateByPrimaryKeySelective(updateCricleFriends);
    }


    private void processLoopSend(CricleFriends circle,String nowTime) {
        // 获取发送时间、最后执行时间、间隔单位和间隔时间
        // 处理明细
        CricleDetailCriteria cricleDetailCriteria = new CricleDetailCriteria();
        cricleDetailCriteria.createCriteria().andCricleIdEqualTo(circle.getCircleId());
        List<CricleDetail> circleDetails = cricleDetailMapper.selectByExample(cricleDetailCriteria);
        cricleDetailCriteria.setOrderByClause("sort desc");

        String lastExecutedTime=circle.getLastExecustTime();
        int unit = circle.getUnit();
        int unitNum = circle.getUnitNum();
        if(lastExecutedTime==null){ //首次执行 直接判断发送时间
            String sendTime = circle.getSendTime().substring(0, 16);
            String nowDate = nowTime.substring(0, 16);
            if (sendTime.equals(nowDate)) {

              sendCircleDetails(circle,circleDetails,nowTime);
            }
        }else { //已有发送时间 判断间隔
               //转换时间
            /* String lastTime=lastExecutedTime.substring(0,10);
             LocalDateTime executedTime = LocalDateTime.parse(circle.getLastExecustTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));*/
             if(unit==1){
                 LocalDateTime executedTime = LocalDateTime.parse(circle.getLastExecustTime(), DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
                 String     nextExecutedTime =executedTime.plusHours(1).format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
                 if(nextExecutedTime.equals(nowTime)){
                     sendCircleDetails(circle,circleDetails,nowTime);
                 }
             }else {
                 String lastTime=lastExecutedTime.substring(0,10);
                 String lastIndexTime=nowTime.substring(10);
                 LocalDate executedTime = LocalDate.parse(lastTime, DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD));
                 if(unit==2){  //日
                     String shouldTime=executedTime.plusDays(1).format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD))+lastIndexTime;
                     if(shouldTime.equals(nowTime)){
                         sendCircleDetails(circle,circleDetails,nowTime);
                     }
                 }else if(unit==3){ //周
                     String shouldTime=executedTime.plusDays(7).format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD))+lastExecutedTime;
                     if(shouldTime.equals(nowTime)){
                         sendCircleDetails(circle,circleDetails,nowTime);
                     }
                 }else if(unit ==4){ //月
                     String shouldTime=executedTime.plusDays(30).format(DateTimeFormatter.ofPattern(DateUtil.FORMAT_YYYY_MM_DD))+lastExecutedTime;
                     if(shouldTime.equals(nowTime)){
                         sendCircleDetails(circle,circleDetails,nowTime);
                     }
                 }
             }

        }
    }



    public Boolean  pullGooupHander(PullGroup pullGroup,Map<Integer,PullConfig> pullConfigMap){
         //查询要发的明细
        PullGroupOpDetailCriteria pullGroupOpDetailCriteria = new PullGroupOpDetailCriteria();
        pullGroupOpDetailCriteria.createCriteria().andPullIdEqualTo(pullGroup.getPullId());
        pullGroupOpDetailCriteria.setOrderByClause("sort desc");
        List<PullGroupOpDetail> pullGroupOpDetailList = pullGroupOpDetailMapper.selectByExample(pullGroupOpDetailCriteria);

        PullCustRelationCriteria pullCustRelationCriteria = new PullCustRelationCriteria();
        pullCustRelationCriteria.createCriteria().andPullIdEqualTo(pullGroup.getPullId()).andStatusEqualTo(0);
        List<PullCustRelation> pullCustRelationList = pullCustRelationMapper.selectByExample(pullCustRelationCriteria);

        //查询要发的人
        int waitSecond = 1;
        PullConfig pullConfig = pullConfigMap.get(pullGroup.getUserId());
        if (pullConfig != null) {
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
                    processPullCustRelations(pullCustRelationList, pullGroupOpDetailList, waitSecond, pullGroup.getDayMaxNum(), pullGroup.getUserId());
                } else {
                    return true;
                }
            }
        } else {
            processPullCustRelations(pullCustRelationList, pullGroupOpDetailList, waitSecond, pullGroup.getDayMaxNum(), pullGroup.getUserId());
        }

          return true;
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
        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_custom_exchange, MqConstant.routeKey.pull_send_task_key, object.toJSONString(), message -> {
            message.getMessageProperties().setDelay(day);
            return message;
        });
    }

}
