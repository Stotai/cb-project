package com.qianya.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value = {"com.qianya.mapper", "com.qianya.task.mapper"})
@EnableDiscoveryClient
@EnableScheduling
public class TaskApplication{
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
