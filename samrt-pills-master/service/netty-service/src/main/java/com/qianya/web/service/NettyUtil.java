package com.qianya.web.service;

import com.alibaba.fastjson.JSONObject;
import com.qianya.config.ApplicationContextHolder;
import com.qianya.constant.MgConstant;
import com.qianya.constant.MqConstant;
import com.qianya.entity.mongo.NettyChannelMoEntity;
import com.qianya.constant.CommConstant;
import com.qianya.netty.NettyWebSocketHandler;
import com.qianya.util.MyMacher;
import com.qianya.util.StringUtil;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/***
 * 通信业务处理
 * @Description
 * @Author lhl
 * @Date 2023-05-22 22:11
 */
@Service
public class NettyUtil {

    static RedisTemplate<String, Object> redisTemplate;
    static RabbitTemplate rabbitTemplate;
    static MongoTemplate mongoTemplate;
    static private  RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }
    static private  RabbitTemplate getRabbitTemplate() {
        if (rabbitTemplate == null) {
            rabbitTemplate = ApplicationContextHolder.getBean("rabbitTemplate");
        }
        return rabbitTemplate;
    }
    static private  MongoTemplate getMongoTemplate() {
        if (mongoTemplate == null) {
            mongoTemplate = ApplicationContextHolder.getBean("mongoTemplate");
        }
        return mongoTemplate;
    }

    public static void online(boolean flag,String token){

    }

    /***
     * 设置用户缓存
     * @param userId
     * @param contextId
     * @return
     */
    public static Integer setUserInfo(Integer userId,String contextId) {
        getRedisTemplate();
        redisTemplate.opsForValue().set(CommConstant.redisKey.netty_user_channel+ userId,contextId,1, TimeUnit.DAYS);
        //设置值
        sendUserBindChannelQueue(userId,contextId);
        return userId;
    }
    /***
     * 清除绑定关系
     * @Description
     * @param: userId
     * @Author lhl
     * @Date 2023-05-23 21:59
     */
    public static void offLine(Integer userId){
        getRedisTemplate();
        redisTemplate.delete(CommConstant.redisKey.netty_user_channel+userId);
        //设置值
        sendUserBindChannelQueue(userId,"");
    }

    /***
     * 发送消息
     * @param userId
     * @param msg
     */
    public static int handleMsg(Integer userId, String msg){
        String contextId =findChannelWithId(userId);
        if (StringUtil.isNotEmpty(contextId)){
            MyMacher myMacher = new MyMacher(contextId);
            ChannelGroup channelGroup = NettyWebSocketHandler.channelGroup;
            try {
                channelGroup.writeAndFlush(new TextWebSocketFrame(msg),myMacher);
                return 1;
            }catch (Exception e){
                //发送异常
                return 3;
            }
        }else {
            //不在线，无法发送
            return 2;
        }
    }

    /****
     * 根进用户id查询管道信息
     * @Description
     * @param: userId
     * @return: java.lang.String
     * @Author lhl
     * @Date 2023-05-23 22:14
     */
    public static String findChannelWithId(Integer userId){
        getRedisTemplate();
        getMongoTemplate();
        String contextId =(String) redisTemplate.opsForValue().get(CommConstant.redisKey.netty_user_channel+userId);
        if (contextId==null){
            Query query = new Query(Criteria.where("user_id").is(userId));
            NettyChannelMoEntity one = mongoTemplate.findOne(query, NettyChannelMoEntity.class, MgConstant.NETTY_CHANNEL);
            if(one==null || StringUtil.isEmpty(one.getChannelId())){
                redisTemplate.opsForValue().set(CommConstant.redisKey.netty_user_channel+ userId,"",1, TimeUnit.DAYS);
                return "";
            }else {
                redisTemplate.opsForValue().set(CommConstant.redisKey.netty_user_channel+ userId,one.getChannelId(),1, TimeUnit.DAYS);
                return one.getChannelId();
            }
        }else {
            return contextId;
        }
    }
    /***
     * 发送队列绑定
     * @Description
     * @Author lhl
     * @Date 2023-05-23 22:04
     */
    public static void sendUserBindChannelQueue(Integer userId,String contextId){
        getRabbitTemplate();
        JSONObject object=new JSONObject();
        object.put("userId",userId);
        object.put("channelId",contextId);
        rabbitTemplate.convertAndSend(MqConstant.exchange.mall_new_exchange, MqConstant.routeKey.netty_user_channel_key, object);
    }
}
