package com.qianya.task.service;

import org.springframework.stereotype.Component;

@Component
public interface JobService {

    /***
     * @title  每分钟执行一次发送结果检测
     * @Description
     * @Author lhl
     * @Date 2023/6/15 11:42
     */
    void groupSendRes();

    /***
     * @title  每2分钟执行一次群发检测
     * @Description
     * @Author lhl
     * @Date 2023/6/15 11:42
     */
    void groupSendCheck();


    /***
     * @title  每分钟执行一次拉群结果检测
     * @Description
     * @Author wangxin
     * @Date 2023/7/17 11:42
     */
    void pullGroupSendRes();


    /***
     * @title  每2分钟执行一次拉群检测
     * @Description
     * @Author wangxin
     * @Date 2023/7/17 11:42
     */
    void pullGroupSendCheck();


    /***
     * @title  每1分钟执行一次发朋友圈检测
     * @Description
     * @Author wangxin
     * @Date 2023/7/17 11:42
     */
    void circleSendCheck();



}
