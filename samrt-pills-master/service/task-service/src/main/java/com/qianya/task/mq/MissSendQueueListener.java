package com.qianya.task.mq;

import com.alibaba.fastjson.JSONObject;
import com.qianya.annotations.Log;
import com.qianya.cbEnum.NettyMsgEnum;
import com.qianya.constant.MqConstant;
import com.qianya.task.comm.RabbitMqUtils;
import com.qianya.util.LogUtil;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class MissSendQueueListener {
    @Autowired
    private RabbitMqUtils rabbitMqUtils;

    /***
     * @Title 发送消息队列
     * @Description
     * @param: content
     * @param: message
     * @param: channel
     * @Author lhl
     * @Date 2023-06-22 14:55
     */
    @RabbitListener(queues = MqConstant.queue.yc_send_miss_queue)
    public void ycSendMissQueue(String content, Message message, Channel channel) {
        LogUtil.info(getClass(),"rabbitMQ消费");
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            JSONObject object = JSONObject.parseObject(content, JSONObject.class);
            Integer userId = object.getInteger("userId");
            Integer msgType = (Integer) object.get("massCommonType");
            JSONObject newObject=new JSONObject();
            newObject.put("content",object.toJSONString());

            LogUtil.info(getClass(),"验证消息类型啊"+msgType);
            newObject.put("msg_type", NettyMsgEnum.SPEED_GROUP_SEND.getCode());
            rabbitMqUtils.sendNettyMsg(userId,NettyMsgEnum.SPEED_GROUP_SEND.getType(),newObject.toJSONString());

/*            if(msgType!=null && msgType==1){
                newObject.put("msg_type", NettyMsgEnum.SPEED_GROUP_SEND.getCode());
                rabbitMqUtils.sendNettyMsg(userId,NettyMsgEnum.SPEED_GROUP_SEND.getType(),newObject.toJSONString());
            }else {
                newObject.put("msg_type", NettyMsgEnum.GROUP_SEND.getCode());
                rabbitMqUtils.sendNettyMsg(userId,NettyMsgEnum.GROUP_SEND.getType(),newObject.toJSONString());
            }*/
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
     * @Author lhl
     * @Date 2023-06-22 14:55
     */
    @RabbitListener(queues = MqConstant.queue.pull_send_task_queue)
    public void pullSendTaskMissQueue(String content, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            JSONObject object = JSONObject.parseObject(content, JSONObject.class);
            Integer userId = object.getInteger("userId");
            JSONObject newObject=new JSONObject();
            newObject.put("msg_type", NettyMsgEnum.PULL_GROUP.getCode());
            newObject.put("content",object.toJSONString());
            rabbitMqUtils.sendNettyMsg(userId,NettyMsgEnum.GROUP_SEND.getType(),newObject.toJSONString());
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
     * @Author lhl
     * @Date 2023-06-22 14:55
     */
    @RabbitListener(queues = MqConstant.queue.cricle_send_task_queue)
    public void cricleSendTaskMissQueue(String content, Message message, Channel channel) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            JSONObject object = JSONObject.parseObject(content, JSONObject.class);
            Integer userId = object.getInteger("userId");
            JSONObject newObject=new JSONObject();
            newObject.put("msg_type", NettyMsgEnum.CRICLE_FRIENDS_SEND.getCode());
            newObject.put("content",object.toJSONString());
            rabbitMqUtils.sendNettyMsg(userId,NettyMsgEnum.CRICLE_FRIENDS_SEND.getType(),newObject.toJSONString());
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
