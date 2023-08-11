package com.qianya.task.comm;

import com.qianya.constant.MqConstant;
import com.qianya.entity.mongo.NettyMsgMoEntity;
import com.qianya.util.DateUtil;
import com.qianya.util.IdWorker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @description mq队列发送
 * @author lhl
 * @since 2022-02-21 12:24
 */
@Component
public class RabbitMqUtils {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private IdWorker idWorker;

    /****
     * @Title 发送netty消息
     * @Description
     * @param: userId   用户id
     * @param: msgType  枚举类型，根据业务传递
     * @param: content  发送类型，json字符串
     * @Author lhl
     * @Date 2023-05-27 16:30
     */
    public void sendNettyMsg(Integer userId, Integer msgType, String content) {
        NettyMsgMoEntity msgMoEntity=new NettyMsgMoEntity();
        msgMoEntity.setRecordId(idWorker.nextId());
        msgMoEntity.setUserId(userId);
        msgMoEntity.setMsgType(msgType);
        msgMoEntity.setContent(content);
        msgMoEntity.setIsDeal(0);
        msgMoEntity.setCreateTime(DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));
        msgMoEntity.setDealState(0);
        mongoTemplate.insert(msgMoEntity);
        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_new_exchange, MqConstant.routeKey.netty_send_info_key, msgMoEntity.getRecordId());
    }
}
