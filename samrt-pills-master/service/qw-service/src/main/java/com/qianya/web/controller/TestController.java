package com.qianya.web.controller;

import com.qianya.common.JsonResultT;
import com.qianya.util.IpUtils;
import com.qianya.util.LogUtil;
import com.qianya.util.MailUtil;
import com.qianya.web.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
* <p>
    * test
    * </p>
*
* @author lhl
* @since 2020-09-28
*/
@RestController
@RequestMapping("/test")
@Api(value = "TestController", tags = "test接口")
@Slf4j
@Validated
public class TestController {


    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/testOk")
    @ApiIgnore
    public JsonResultT testOk(@RequestParam(required = false) Integer type){
        try{
            MailUtil.sendEmail(mongoTemplate,"qw-service升级完成","服务器ip:"+ IpUtils.getServiceIp());
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResultT.ok();
    }

}
