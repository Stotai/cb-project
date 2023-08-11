package com.qianya;


import com.qianya.annotations.EnableOffline;
import com.qianya.aspect.SysLogAspect;
import com.qianya.config.offline.NacosConfig;
import com.qianya.exception.MyExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(value = {"com.qianya.mapper", "com.qianya.web.mapper"})
@EnableDiscoveryClient
@EnableOffline
@ImportAutoConfiguration({SysLogAspect.class})
public class QwServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QwServiceApplication.class, args);
    }
}
