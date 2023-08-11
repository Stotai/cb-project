package com.qianya.web.controller;

import com.qianya.common.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-03  19:33
 * @Description: TODO
 */

@RestController
@Api(value = "IndexController", tags = "首页")
@RequestMapping("/index")
public class IndexController  {


    @PostMapping("/home")
    @ApiOperation("首页报表")
    public JsonResult home(@RequestParam("startTime")String startTime,@RequestParam("endTime")String endTime) {
        return null;
    }






}
