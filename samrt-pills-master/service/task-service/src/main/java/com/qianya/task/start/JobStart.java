package com.qianya.task.start;

import com.qianya.task.service.JobService;
import com.qianya.task.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobStart {
    @Autowired
    private JobService jobService;

    /***
     * @title  每分钟执行一次发送结果检测
     * @Description
     * @Author lhl
     * @Date 2023/6/15 11:42
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void groupSendRes(){
        jobService.groupSendRes();
    }


    /***
     * @title  每2分钟执行一次群发检测
     * @Description
     * @Author lhl
     * @Date 2023/6/15 11:42
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void groupSendCheck(){
        jobService.groupSendCheck();
    }
}
