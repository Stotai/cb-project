package com.qianya.constant;

/***
 * 通用常量
 * @Description
 * @Author lhl
 * @Date 2023-05-22 22:16
 */
public interface CommConstant {
    interface redisKey {
        String netty_user_channel="netty:user:";

        //接受新客戶配置
        String user_custConfig="user:custConfig:";
        //发送消息
        String miss_send="miss_send:";

        //发送消息
        String pull_group="pull_group:";

    }
}
