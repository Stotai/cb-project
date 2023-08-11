package com.qianya.task.start;

import com.qianya.task.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestStart {
    @Autowired
    private TestService testService;
    /**
     *  每秒执行定时任务
     * @author lhl
     * @date 2022-06-24 上午 08:59
     * @param
     */
    //@Scheduled(cron = "*/50 * * * * ?")
    public void taskStart(){
        testService.TestOne();
    }

}
