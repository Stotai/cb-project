package com.qianya.file.controller;

import cn.hutool.core.util.IdUtil;
import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.file.service.AliyunService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/** 阿里云服务相关
 * @Description
 * @Author lhl
 * @Date 2023-05-13 14:39
 */
@RestController
@RequestMapping("/aliyun")
public class AliyunController {
    @Autowired
    private AliyunService aliyunService;
    /*
     * @Description: 阿里云STS鉴权
     * @date 2021年09月06日 15:23
     * @author yuans
     */
    @RequestMapping("/stsAuth")
    public JsonResultT<Map<String, Object>> stsAuth(){
        return  aliyunService.stsAuth();
    }

}
