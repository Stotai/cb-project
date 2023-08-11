package com.qianya.config;

import com.qianya.constant.MqConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *  lhl
 * @createDate: 2021-11-16 10:40
 * @version: 1.0
 * rabbitmq配置
 */
@Configuration
public class RabbitMqConfig {


    /**
     *  实时交换机
     * @author lhl
     * @date 2021/11/19 10:36
     */
    @Bean
    public DirectExchange mallNewExchange(){
        return new DirectExchange(MqConstant.exchange.mall_new_exchange,true,false);
    }

    /**
     * 延时交换机
     * @author lhl
     * @since 2021-11-16 10:49
     * @return org.springframework.amqp.core.CustomExchange
     */
    @Bean
    public CustomExchange customExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(MqConstant.exchange.mall_custom_exchange, "x-delayed-message", true, false, args);
    }

    /**
     *netty用户关联channel队列绑定
     * @author lhl
     * @date 2021/11/19 10:38
     */
    @Bean
    public Binding nettyUserChannelQueueBindExchange(){
        return BindingBuilder.bind(nettyUserChannelQueue()).to(mallNewExchange()).with(MqConstant.routeKey.netty_user_channel_key);
    }
    /**
     * netty消息发送队列绑定
     * @author lhl
     * @date 2021/11/19 10:38
     */
    @Bean
    public Binding nettySendInfoQueueBindExchange(){
        return BindingBuilder.bind(nettySendInfoQueue()).to(mallNewExchange()).with(MqConstant.routeKey.netty_send_info_key);
    }
    /**
     *  netty用户关联channel队列
     * @author lhl
     * @date 2022-06-15 下午 05:02
     */
    @Bean
    public Queue nettyUserChannelQueue() {
        return new Queue(MqConstant.queue.netty_user_channel_queue, true);
    }
    /**
     *  netty消息发送队列
     * @author lhl
     * @date 2022-06-15 下午 05:02
     */
    @Bean
    public Queue nettySendInfoQueue() {
        return new Queue(MqConstant.queue.netty_send_info_queue, true);
    }

      /***
       * @Title 延时加好友队列绑定
       * @Description
       * @return: org.springframework.amqp.core.Binding
       * @Author lhl
       * @Date 2023-06-18 12:48
       */
    @Bean
    public Binding addCustomQueueBindExchange() {
        return BindingBuilder.bind(addCustomQueue()).to(customExchange()).with(MqConstant.routeKey.add_customer_key).noargs();
    }
    /**
     *  延时加好友队列
     * @author lhl
     * @date 2022-09-13 上午 11:41
     * @param
     */
    @Bean
    public Queue addCustomQueue() {
        return new Queue(MqConstant.queue.add_customer_queue, true);
    }
   }
