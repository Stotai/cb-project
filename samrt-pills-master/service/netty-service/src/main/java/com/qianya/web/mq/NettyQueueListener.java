package com.qianya.web.mq;

import com.alibaba.fastjson.JSONObject;
import com.qianya.cbEnum.NettyMsgEnum;
import com.qianya.constant.MgConstant;
import com.qianya.constant.MqConstant;
import com.qianya.entity.mongo.NettyChannelMoEntity;
import com.qianya.entity.mongo.NettyMsgMoEntity;
import com.qianya.exception.CustomException;
import com.qianya.model.Do.NettyMsgDo;
import com.qianya.util.DateUtil;
import com.qianya.util.IdWorker;
import com.qianya.util.LogUtil;
import com.qianya.web.service.NettyUtil;
import com.qianya.web.service.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class NettyQueueListener {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RabbitMqUtils rabbitMqUtils;
    /**
     * netty用户关联channel队列
     * @author lhl
     * @date 2022-06-15 下午 05:07
     * @param message
     * @param channel
     */
    @RabbitListener(queues = MqConstant.queue.netty_user_channel_queue)
    public void testWaitQueue(JSONObject object, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            Integer userId = object.getInteger("userId");
            String channelId = object.getString("channelId");
            String nowFormat = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
            mongoTemplate.updateMulti(new Query(Criteria.where("user_id").is(userId)), Update.update("channel_id",channelId).set("update_time",nowFormat),NettyChannelMoEntity.class,MgConstant.NETTY_CHANNEL);
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
    /****
     * @Title 发送消息
     * @Description
     * @param: msgDo
     * @param: message
     * @param: channel
     * @Author lhl
     * @Date 2023-05-27 15:19
     */
    @RabbitListener(queues = MqConstant.queue.netty_send_info_queue)
    public void nettySendInfoQueue(Long recordId, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            NettyMsgMoEntity nettyMsg = mongoTemplate.findById(recordId, NettyMsgMoEntity.class, MgConstant.NETTY_MSG);
            if (nettyMsg==null){
                throw new CustomException("获得消息异常");
            }
            //如果没有消费的才消费
            if (nettyMsg.getDealState().equals(0)){
                /*NettyMsgDo msgDo=new NettyMsgDo();
                msgDo.setMsgType(nettyMsg.getMsgType());
                msgDo.setContent(nettyMsg.getContent());*/
                //判断发送结果
                int res = NettyUtil.handleMsg(nettyMsg.getUserId(), nettyMsg.getContent());
                //修改消息发送结果
                mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(recordId)),Update.update("deal_time",DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS)).set("deal_state",res).set("is_deal",1), NettyMsgMoEntity.class, MgConstant.NETTY_MSG);
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
    /****
     * @Title 新增客户队列
     * @Description
     * @param: recordId
     * @param: message
     * @param: channel
     * @Author lhl
     * @Date 2023-06-18 12:52
     */
    @RabbitListener(queues = MqConstant.queue.add_customer_queue)
    public void addCustomerQueue(String obj, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            JSONObject oldObj=JSONObject.parseObject(obj);
            Integer userId=oldObj.getInteger("userId");
            String wxUserId = oldObj.getString("wxUserId");
            String content = oldObj.getString("content");

            JSONObject object=new JSONObject();
            object.put("msg_type",NettyMsgEnum.ADD_CUSTOMER.getCode());
            object.put("user_id",wxUserId);
            object.put("content",content);
            rabbitMqUtils.sendNettyMsg(userId, NettyMsgEnum.ADD_CUSTOMER.getType(),object.toJSONString());
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
