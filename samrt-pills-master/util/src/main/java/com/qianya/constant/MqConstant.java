package com.qianya.constant;

/**
 *  lhl
 * 队列常量
 */
public interface MqConstant {

    /**
    * 交换机
    * @author lhl
    * @since 2021-10-27 09:33
    */
    interface exchange {
        //延时交换机
        String  mall_custom_exchange = "mall.customExchange";
        //实时交换机
        String  mall_new_exchange = "mall.newExchange";
    }

    /**
    * 队列
    * @author lhl
    * @since 2021-10-27 09:36
    */
    interface queue {

        //测试延迟队列
        String test_wait_queue = "testWaitQueue";
        //测试实时队列
        String test_new_queue="testNewQueue";
        //netty用户关联channel队列
        String netty_user_channel_queue="nettyUserChannelQueue";
        //netty消息发送队列
        String netty_send_info_queue="nettySendInfoQueue";
        //加好友延迟队列
        String add_customer_queue="addCustomerQueue";
        //发消息结果处理
        String miss_send_res_queue="missSendResQueue";
        //拉群结果处理
        String pull_send_res_queue="pullSendResQueue";

        //延迟发送消息模板
        String yc_send_miss_queue="ycSendMissQueue";

        //拉群延迟发送消息模板
        String pull_send_miss_queue="pullSendMissQueue";

        //延迟群发消息
        String mass_send_queue="massSendQueue";


        //延迟群发消息
        String pull_send_task_queue="pullSendTaskQueue";

        //朋友圈定时延时
        String cricle_send_task_queue="cricleSendTaskQueue";
    }

    /**
    * 路由key
    * @author lhl
    * @since 2021-10-29 10:05
    */
    interface routeKey {
        //测试延迟队列
        String test_wait_key = "testWaitKey";
        //测试实时队列
        String test_new_key="testNewKey";
        //netty用户关联channel key
        String netty_user_channel_key="nettyUserChannelKey";

        //netty消息发送key
        String netty_send_info_key="nettySendInfoKey";

        //加好友延迟key
        String add_customer_key="addCustomerKey";
        //发消息结果处理
        String miss_send_res_key="missSendResKey";

        //拉群结果处理
        String pull_send_res_key="pullSendResKey";

        //延迟发送消息key
        String yc_send_miss_key="ycSendMissKey";

        //拉群发送消息key
        String pull_send_miss_key="pullSendMissKey";

        //延迟群发消息
        String mass_send_key="massSendKey";


        //拉群定时发送消息key
        String pull_send_task_key="pullSendTaskKey";


        //朋友圈定时延时key
        String cricle_send_task_key="cricleSendTaskKey";
    }

}
