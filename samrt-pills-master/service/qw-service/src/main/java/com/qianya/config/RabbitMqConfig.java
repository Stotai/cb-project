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
     *  实时交换机
     * @author lhl
     * @date 2021/11/19 10:36
     */
    @Bean
    public DirectExchange mallNewExchange(){
        return new DirectExchange(MqConstant.exchange.mall_new_exchange,true,false);
    }

    /**
     *  测试延时队列绑定
     * @author lhl
     * @date 2022-09-13 上午 11:43
     * @param
     */
    @Bean
    public Binding testWaitQueueBindExchange() {
        return BindingBuilder.bind(testWaitQueue()).to(customExchange()).with(MqConstant.routeKey.test_wait_key).noargs();
    }
    /**
     *  测试延时队列
     * @author lhl
     * @date 2022-09-13 上午 11:41
     * @param
     */
    @Bean
    public Queue testWaitQueue() {
        return new Queue(MqConstant.queue.test_wait_queue, true);
    }


    /**
     *测试实时队列绑定
     * @author lhl
     * @date 2021/11/19 10:38
     */
    @Bean
    public Binding testNewQueueBindExchange(){
        return BindingBuilder.bind(testNewQueue()).to(mallNewExchange()).with(MqConstant.routeKey.test_new_key);
    }
    /**
     *  测试实时队列
     * @author lhl
     * @date 2022-06-15 下午 05:02
     */
    @Bean
    public Queue testNewQueue() {
        return new Queue(MqConstant.queue.test_new_queue, true);
    }

    /**
     * 发消息结果队列绑定
     * @author lhl
     * @date 2021/11/19 10:38
     */
    @Bean
    public Binding missSendResQueueBindExchange(){
        return BindingBuilder.bind(missSendResQueue()).to(mallNewExchange()).with(MqConstant.routeKey.miss_send_res_key);
    }
    /**
     *  发消息结果处理队列
     * @author lhl
     * @date 2022-06-15 下午 05:02
     */
    @Bean
    public Queue missSendResQueue() {
        return new Queue(MqConstant.queue.miss_send_res_queue, true);
    }

    /**
     * 发消息结果队列绑定
     * @author lhl
     * @date 2021/11/19 10:38
     */
    @Bean
    public Binding pullSendResQueueBindExchange(){
        return BindingBuilder.bind(pullSendResQueue()).to(mallNewExchange()).with(MqConstant.routeKey.pull_send_res_key);
    }
    /**
     *  发消息结果处理队列
     * @author lhl
     * @date 2022-06-15 下午 05:02
     */
    @Bean
    public Queue pullSendResQueue() {
        return new Queue(MqConstant.queue.pull_send_res_queue, true);
    }



    /***
     * @Title 拉群延时消息绑定
     * @Description
     * @return: org.springframework.amqp.core.Binding
     * @Author wangxin
     * @Date 2023-07-16 12:48
     */
    @Bean
    public Binding GroupSendMissQueueBindExchange() {
        return BindingBuilder.bind(GroupSendMissQueue()).to(customExchange()).with(MqConstant.routeKey.pull_send_miss_key).noargs();
    }
    /**
     *  拉群延时消息
     * @author wangxin
     * @date 2023-07-16 上午 11:41
     * @param
     */
    @Bean
    public Queue GroupSendMissQueue() {
        return new Queue(MqConstant.queue.pull_send_miss_queue, true);
    }

    /***
     * @Title 群发
     * @Description
     * @return: org.springframework.amqp.core.Binding
     * @Author wangxin
     * @Date 2023-07-15 12:48
     */
    @Bean
    public Binding mssSendQueueBind() {
        return BindingBuilder.bind(massSendQueue()).to(customExchange()).with(MqConstant.routeKey.mass_send_key).noargs();
    }
    /**
     *  延时消息模板队列
     * @author lhl
     * @date 2022-09-13 上午 11:41
     * @param
     */
    @Bean
    public Queue massSendQueue() {
        return new Queue(MqConstant.queue.mass_send_queue, true);
    }
}
