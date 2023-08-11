package com.qianya.web.controller;

import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.model.out.ProductUseRecordDtoOut;
import com.qianya.util.StringUtil;
import com.qianya.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.qianya.model.in.ExriseUserDtoIn;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-08  18:23
 * @Description: 用户管理
 */
@RestController
@Api(value = "CustomerController", tags = "用户管理")
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户企业微信", notes = "查询没有删除的ExriseUser信息")
    @PostMapping("/getExriseUserByUserId")
    public JsonResult getExriseUserByUserId() {
       return userService.getExriseUserByUserId();
    }



    @ApiOperation(value = "企业微信登录授权新增/修改", notes = "企业微信登录授权新增")
    @PostMapping("/editUser")
    public JsonResult editUser(@RequestBody  ExriseUserDtoIn exriseUserDtoIn) {
        return userService.editUser(exriseUserDtoIn);
    }






    @ApiOperation(value = "根据exriseUserId删除记录(主键id)", notes = "根据exriseUserId删除记录")
    @ApiImplicitParam(name = "exriseUserId", value = "exriseUserId", dataType = "int", paramType = "path")
    @PostMapping("/deleteByExriseUserId")
    public JsonResult deleteByExriseUserId(@ApiParam("企业微信id") @RequestParam Integer exriseUserId) {
        int count = userService.deleltUser(exriseUserId);
        if (count > 0) {
            return JsonResult.ok("删除成功");
        } else {
            return JsonResult.error("删除失败");
        }
    }

    @PostMapping("/exriseWxNameRemark")
    @ApiOperation("修改企业微信备注")
    public JsonResultT<?> exriseWxNameRemark(
            @RequestParam(value = "exriseWxId", required = false)
            @ApiParam(value = "企业微信id", example = "0") String exriseUserId,
            @RequestParam(value = "remark", required = false)
            @ApiParam(value = "备注", example = "1") String remark) {

        return userService.exriseWxNameRemark(exriseUserId, remark);
    }



    @ApiOperation(value = "初始群/好友数据完执行统计")
    @PostMapping("/countCust")
    public  JsonResult  countCust(){
        return userService.countCust();
    }


    @PostMapping("/searchCardRecords")
    @ApiOperation("根据卡密、使用人账号和企业微信ID进行模糊搜索")
    public JsonResultT<List<ProductUseRecordDtoOut>> searchCardRecords(
            @RequestParam(value = "keyword",required = false) String keyword
    ) {
        // 调用查询方法，获取查询结果
        List<ProductUseRecordDtoOut> records = userService.searchCardRecords(keyword);
        return JsonResultT.ok(records);
    }

    @PostMapping("/searchRecordsByCarmi")
    @ApiOperation("根据卡密进行查询(卡密以逗号拼接)")
    public JsonResultT<List<ProductUseRecordDtoOut>> searchRecordsByCarmi(
            @RequestParam("carmis") String carmis
    ) {
        if(StringUtil.isEmpty(carmis)){
            return JsonResultT.error("请传入要查询的卡密");
        }
        List<ProductUseRecordDtoOut> productUseRecordDtoOuts = userService.searchRecordsByCarmi(carmis);
        return JsonResultT.ok(productUseRecordDtoOuts);
    }



    @PostMapping("/transfer")
    @ApiOperation("卡密转移")
    public JsonResultT<?> transferCard(
            @ApiParam(value = "记录id", required = true) @RequestParam Integer recordId,
            @ApiParam(value = "企业微信ID", required = true) @RequestParam String exriseUserId,
            @ApiParam(value = "备注") @RequestParam(required = false) String remark
    ) {
        return userService.transferCard(recordId,exriseUserId, remark);
    }


    @ApiOperation(value = "卡密激活")
    @PostMapping("/activationCard")
    public JsonResultT<?> activationCard(@RequestParam("carMi")String carMi){
           if(StringUtil.isEmpty(carMi) ){
               return JsonResultT.error("请传入卡密");
           }
           return userService.activationCard(carMi);
    }



}
