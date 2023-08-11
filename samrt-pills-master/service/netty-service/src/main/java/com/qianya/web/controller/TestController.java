package com.qianya.web.controller;

import com.qianya.common.JsonResult;
import com.qianya.util.IpUtils;
import com.qianya.util.MailUtil;
import com.qianya.web.service.NettyUtil;
import com.qianya.web.service.RabbitMqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class TestController {
    @Autowired
    private RabbitMqUtils rabbitMqUtils;
    @Autowired
    private MongoTemplate mongoTemplate;
    @GetMapping("/sendTest")
    public JsonResult sendInfo(@RequestParam("id")Integer id,@RequestParam("content")String content){
        rabbitMqUtils.sendNettyMsg(id,1,content);
        return JsonResult.ok();
    }

    @GetMapping("/testOk")
    @ApiIgnore
    public JsonResult testOk(){
        try{
            MailUtil.sendEmail(mongoTemplate,"netty-service升级完成","服务器ip:"+IpUtils.getServiceIp());
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.ok();
    }
}
