package com.qianya.web.mq;

import com.alibaba.fastjson.JSONObject;
import com.qianya.cbEnum.NettyMsgEnum;
import com.qianya.constant.CommConstant;
import com.qianya.constant.MgConstant;
import com.qianya.constant.MqConstant;
import com.qianya.entity.*;
import com.qianya.entity.mongo.MassSendingRecordMoEntity;
import com.qianya.entity.mongo.NettyChannelMoEntity;
import com.qianya.entity.mongo.NettyMsgMoEntity;
import com.qianya.mapper.MassSendingDetailMapper;
import com.qianya.mapper.PullCustRelationMapper;
import com.qianya.util.LogUtil;
import com.qianya.util.StringUtil;
import com.qianya.web.comm.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import org.checkerframework.checker.units.qual.A;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@RefreshScope
public class MissSendQueueListener {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private RedisTemplate<String,Integer> redisTemplate;
    @Autowired
    private RabbitMqUtils rabbitMqUtils;
    @Autowired
    private PullCustRelationMapper pullCustRelationMapper;

        /***
         * @title 发消息结果处理
         * @Description
         * @param: content
         * @param: message
         * @param: channel
         * @Author lhl
         * @Date 2023/6/21 17:31
         */
        @RabbitListener(queues = MqConstant.queue.miss_send_res_queue)
        public void testNewQueue(String content, Message message, Channel channel) {
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            try {
                JSONObject object = JSONObject.parseObject(content, JSONObject.class);
                Integer state = object.getInteger("state");
                Integer massId = object.getInteger("massId");
                String workId = object.getString("workId");
                String failMsg=object.getString("failMsg");
                MassSendingRecordMoEntity entity = mongoTemplate.findOne(new Query(Criteria.where("mass_id").is(massId).and("customer_wx_id").is(workId).and("status").is(0)), MassSendingRecordMoEntity.class, MgConstant.MASS_SENDING_RECORD);
                if (entity!=null ){
                    if (entity.getStatus()==0){
                        Update update = Update.update("status", state);
                        if (StringUtil.isNotEmpty(failMsg)){
                            update.set("fail_msg", failMsg);
                        }
                        mongoTemplate.updateMulti(new Query(Criteria.where("_id").is(entity.getRecordId())), update, MassSendingRecordMoEntity.class,MgConstant.MASS_SENDING_RECORD);
                    }
                    //redis key+1
                    String key = CommConstant.redisKey.miss_send + entity.getMainId();
                    Integer val = redisTemplate.boundValueOps(key).get();
                    if (val==null){
                        redisTemplate.opsForValue().set(key,0,3, TimeUnit.HOURS);
                    }
                    redisTemplate.opsForValue().increment(key);
                }
                channel.basicAck(deliveryTag, true);
            } catch (Exception e) {
                //打印错误
                LogUtil.error(getClass(),e);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }


    /***
     * @title 拉群结果处理
     * @Description
     * @param: content
     * @param: message
     * @param: channel
     * @Author wangxin
     * @Date 拉群结果处理
     */
    @RabbitListener(queues = MqConstant.queue.pull_send_res_queue)
    public void pullSendResQueue(String content, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            JSONObject object = JSONObject.parseObject(content, JSONObject.class);
            Integer state = object.getInteger("state");
            Integer pullId = object.getInteger("pullId");
            String customerId = object.getString("customerId");
            String failMsg=object.getString("failMsg");
            PullCustRelationCriteria pullCustRelationCriteria=new PullCustRelationCriteria();
            pullCustRelationCriteria.createCriteria().andCustWxIdEqualTo(customerId).andPullIdEqualTo(pullId);

            PullCustRelation pullCustRelation = pullCustRelationMapper.selectByExampleForOne(pullCustRelationCriteria);
            if (pullCustRelation != null) {
                PullCustRelation updateRealion = new PullCustRelation();
                updateRealion.setStatus(state);
                updateRealion.setFailMsg(failMsg);
                pullCustRelationMapper.updateByExampleSelective(pullCustRelation, pullCustRelationCriteria);
                //redis key+1
                String key = CommConstant.redisKey.miss_send + pullId;
                Integer val = redisTemplate.boundValueOps(key).get();
                if (val == null) {
                    redisTemplate.opsForValue().set(key, 0, 3, TimeUnit.HOURS);
                }
                redisTemplate.opsForValue().increment(key);
            }
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            //打印错误
            LogUtil.error(getClass(),e);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }


    /***
     * @Title 发送消息队列
     * @Description
     * @param: content
     * @param: message
     * @param: channel
     * @Author wangxin
     * @Date 2023-06-22 14:55
     */
    @RabbitListener(queues = MqConstant.queue.pull_send_miss_queue)
    public void pullGroupSendMissQueue(String content, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            JSONObject object = JSONObject.parseObject(content, JSONObject.class);
            Integer userId = object.getInteger("userId");
            JSONObject newObject=new JSONObject();
            newObject.put("msg_type", NettyMsgEnum.PULL_GROUP.getCode());
            newObject.put("content",object.toJSONString());
            rabbitMqUtils.sendNettyMsg(userId,NettyMsgEnum.PULL_GROUP.getType(),newObject.toJSONString());
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            //打印错误
            LogUtil.error(getClass(),e);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
