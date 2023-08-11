package com.qianya.web.mq;

import com.qianya.constant.MqConstant;
import com.qianya.util.LogUtil;
import com.qianya.web.service.MassService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class TestQueueListener {


    @Autowired
    private MassService massService;

        /**
         * 实时队列监听测试
         * @author lhl
         * @date 2022-06-15 下午 05:07
         * @param message
         * @param channel
         */
        @RabbitListener(queues = MqConstant.queue.test_new_queue)
        public void testNewQueue(String content, Message message, Channel channel) {
            LogUtil.info(getClass(),"实时队列测试监听->content:"+content);
            long deliveryTag = message.getMessageProperties().getDeliveryTag();
            try {

                //todo 开始执行逻辑...
                // 处理成功，确认消息
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

    /**
     * 延时队列监听测试
     * @author lhl
     * @date 2022-06-15 下午 05:07
     * @param message
     * @param channel
     */
    @RabbitListener(queues = MqConstant.queue.test_wait_queue)
    public void testWaitQueue(String content, Message message, Channel channel) {
        LogUtil.info(getClass(),"延时队列测试监听->content:"+content);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {

            //todo 开始执行逻辑...
            // 处理成功，确认消息
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
    /**
     * 延时队列监听测试
     * @author lhl
     * @date 2022-06-15 下午 05:07
     * @param message
     * @param channel
     */
    @RabbitListener(queues = MqConstant.queue.mass_send_queue)
    public void massSendQueueListener(String content, Message message, Channel channel) {
        LogUtil.info(getClass(),"延时群发队列测试监听->content:"+content);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
              massService.massTask();
            //todo 开始执行逻辑...
            // 处理成功，确认消息
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
