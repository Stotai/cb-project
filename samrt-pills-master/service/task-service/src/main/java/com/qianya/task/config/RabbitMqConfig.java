package com.qianya.task.config;

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

      /***
       * @Title 延时消息模板队列绑定
       * @Description
       * @return: org.springframework.amqp.core.Binding
       * @Author lhl
       * @Date 2023-06-18 12:48
       */
    @Bean
    public Binding ycSendMissQueueBindExchange() {
        return BindingBuilder.bind(ycSendMissQueue()).to(customExchange()).with(MqConstant.routeKey.yc_send_miss_key).noargs();
    }
    /**
     *  延时消息模板队列
     * @author lhl
     * @date 2022-09-13 上午 11:41
     * @param
     */
    @Bean
    public Queue ycSendMissQueue() {
        return new Queue(MqConstant.queue.yc_send_miss_queue, true);
    }



    /***
     * @Title 延时消息模板队列绑定
     * @Description
     * @return: org.springframework.amqp.core.Binding
     * @Author lhl
     * @Date 2023-06-18 12:48
     */
    @Bean
    public Binding pullSendTaskQueueBindExchange() {
        return BindingBuilder.bind(pullSendTaskQueue()).to(customExchange()).with(MqConstant.routeKey.pull_send_task_key).noargs();
    }
    /**
     *  延时消息模板队列
     * @author lhl
     * @date 2022-09-13 上午 11:41
     * @param
     */
    @Bean
    public Queue pullSendTaskQueue() {
        return new Queue(MqConstant.queue.pull_send_task_queue, true);
    }


    /***
     * @Title 延时消息模板队列绑定
     * @Description
     * @return: org.springframework.amqp.core.Binding
     * @Author lhl
     * @Date 2023-06-18 12:48
     */
    @Bean
    public Binding cricleendTaskQueueBindExchange() {
        return BindingBuilder.bind(cricleSendTaskQueue()).to(customExchange()).with(MqConstant.routeKey.cricle_send_task_key).noargs();
    }
    /**
     *  延时消息模板队列
     * @author lhl
     * @date 2022-09-13 上午 11:41
     * @param
     */
    @Bean
    public Queue cricleSendTaskQueue() {
        return new Queue(MqConstant.queue.cricle_send_task_queue, true);
    }

}
