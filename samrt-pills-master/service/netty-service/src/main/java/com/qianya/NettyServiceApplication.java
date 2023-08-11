package com.qianya;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = {"com.qianya.mapper", "com.qianya.web.mapper"})
@ComponentScan(value = {"com.qianya.*"})
@EnableDiscoveryClient
public class NettyServiceApplication{
    public static void main(String[] args) {
        SpringApplication.run(NettyServiceApplication.class, args);
    }
}
