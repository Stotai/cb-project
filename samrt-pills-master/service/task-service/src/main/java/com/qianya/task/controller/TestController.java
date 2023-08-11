package com.qianya.task.controller;

import com.qianya.common.JsonResult;
import com.qianya.task.service.JobService;
import com.qianya.util.IpUtils;
import com.qianya.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class TestController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private JobService jobService;
    @GetMapping("/testOk")
    @ApiIgnore
    public JsonResult testOk(){
        try{
            MailUtil.sendEmail(mongoTemplate,"task-service升级完成","服务器ip:"+ IpUtils.getServiceIp());//todo
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    @GetMapping("/testSend")
    @ApiIgnore
    public JsonResult testSend(){
        try{
            jobService.groupSendCheck();
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    @GetMapping("/pullGroupSendRes")
    @ApiIgnore
    public JsonResult pullGroupSendRes(){
        try{
            jobService.pullGroupSendRes();
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.ok();
    }

    @GetMapping("/pullGroupSendCheck")
    @ApiIgnore
    public JsonResult pullGroupSendCheck(){
        try{
            jobService.pullGroupSendCheck();
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.ok();
    }


    @GetMapping("/circleSendCheck")
    @ApiIgnore
    public JsonResult circleSendCheck(){
        try{
            jobService.circleSendCheck();
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.ok();
    }
}
