package com.qianya.file.controller;

import com.qianya.common.JsonResult;
import com.qianya.file.util.OSSFileUploadUtil;
import com.qianya.util.IpUtils;
import com.qianya.util.MailUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/** 阿里云上传服务相关
 * @Description
 * @Author lhl
 * @Date 2023-05-13 14:39
 */
@RestController
@RequestMapping("/upload")
@Api(value = "AliyunController",tags = "阿里云上传相关接口")
public class AliyunUploadController {
    @Autowired
    private OSSFileUploadUtil ossFileUploadUtil;
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 测试接口
     *
     * @return
     */
    @GetMapping("/testOk")
    @ApiIgnore
    public JsonResult test() {
        try{
            MailUtil.sendEmail(mongoTemplate,"upload-service升级完成","服务器ip:"+ IpUtils.getServiceIp());
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.ok();
    }
    /**
     * 测试接口
     *
     * @return
     */
    @GetMapping("/testZuulOk")
    @ApiIgnore
    public JsonResult testZuulOk() {
        try{
            MailUtil.sendEmail(mongoTemplate,"zuul升级完成","服务器ip:"+ IpUtils.getServiceIp());
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResult.ok();
    }
    /**
     * 上传
     *
     * @return
     */
    @ApiOperation(value = "上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "type", value = "1.图片，2.视频 ，3.文件", required = true, dataType = "String")
    })
    @PostMapping("/upload")
    public JsonResult upload(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "type") Integer type) {
        return ossFileUploadUtil.uploadMultipartFile(file, type);
    }

    /***
     * @title   图片合成
     * @Description
     * @param: urls
     * @return: com.qianya.common.JsonResult
     * @Author lhl
     * @Date 2023/6/19 9:58
     */
    @ApiOperation(value = "图片合成")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "urls", value = "图片地址，多个用逗号隔开", required = true, dataType = "String")
    })
    @PostMapping("/picCompound")
    public JsonResult picCompound(@RequestParam(value = "urls") String urls) {
        return ossFileUploadUtil.picCompound(urls);
    }
}
