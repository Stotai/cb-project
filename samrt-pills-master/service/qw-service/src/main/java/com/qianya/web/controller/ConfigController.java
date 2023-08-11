package com.qianya.web.controller;

import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;

import com.qianya.entity.UserConfig;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.ZombieConfigDtoIn;
import com.qianya.model.out.ReplyConfigDtoOut;
import com.qianya.model.out.ReplyDtoOut;
import com.qianya.model.out.UserConfigDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.GrainBeanUtils;
import com.qianya.web.service.ConfigService;
import com.qianya.web.service.LoginService;
import io.swagger.annotations.*;
import com.qianya.model.in.ReplyConfigDtoIn;
import com.qianya.model.in.UserConfigDtoIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-24  17:09
 * @Description:  全局配置获取
 */
@RestController
@Api(value = "ConfigController", tags = "全局配置获取")
@RequestMapping("/config")
public class ConfigController {


    @Autowired
    private LoginService loginService;
    @Autowired
    private ConfigService configService;



    @PostMapping("/getByUserId")
    @ApiOperation("根据用户ID查询接受新客户配置信息")
    public JsonResultT<UserConfigDtoOut> getByUserId() {
        // 获取用户ID
        IUserDo user = loginService.selectUser();
        UserConfig userConfig = configService.getByUserId(user.getUserId());
        return JsonResultT.ok(GrainBeanUtils.convert(userConfig, UserConfigDtoOut.class));
    }


    @PostMapping("/saveOrUpdateUserConfig")
    @ApiOperation("新增或修改用户配置")
    public JsonResultT<?> saveOrUpdateUserConfig(@RequestBody UserConfigDtoIn userConfigDtoIn) {
        IUserDo user = loginService.selectUser();
        return configService.saveOrUpdateUserConfig(userConfigDtoIn,user.getUserId());
    }


    @PostMapping("/saveOrUpdateReplyConfig")
    @ApiOperation("新增或修改自动回复配置")
    public JsonResult saveOrUpdateReplyConfig(@RequestBody ReplyConfigDtoIn replyConfigDtoIn) {
        IUserDo user = loginService.selectUser();
        return configService.saveOrUpdateReplyConfig(replyConfigDtoIn,user.getUserId());
    }


    @PostMapping("/deleteReplyConfig")
    @ApiOperation("删除自动回复配置")
    public JsonResult deleteReplyConfig( @ApiParam(value = "配置id", required = true) @RequestBody List<Integer> configIds) {
        if(CollectionUtils.isEmpty(configIds)){
            return JsonResult.error("请传入要删除的配置id");
        }
        return configService.deleteReplyConfig(configIds);
    }

    @ApiOperation(value = "自动回复列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "epriseWxIds", value = "关联企业微信id，多选时以逗号分隔", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "serachContent", value = "回复搜索内容，支持模糊搜索", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页码，默认为1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量，默认为10", dataType = "int", paramType = "query")
    })
    @PostMapping("/replyConfigPage")
    public JsonResultT<CommonPage<ReplyConfigDtoOut>> replyConfigPage(@RequestParam(value = "epriseWxIds",required = false) String  epriseWxIds,
                                                                   @RequestParam(value = "serachContent",required = false)String serachContent,
                                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize ){
        return configService.replyConfigPage(epriseWxIds,serachContent,pageNum,pageSize);
    }

   @ApiOperation(value = "获取自动回复配置")
   @PostMapping("/getReplyConfig")
   public JsonResultT<List<ReplyDtoOut>>  getReplyConfig(){
       return configService.getReplyConfig();
   }


    @ApiOperation(value = "根据id获取自动回复配置")
    @PostMapping("/getReplyConfigDetail")
    public JsonResultT<?>  getReplyConfigDetail(@ApiParam(value = "配置id", required = true)@RequestParam("configId")Integer configId){
        if(configId==null){
            return JsonResultT.error("请传入配置id");
        }
        return configService.getReplyConfigDetail(configId);
    }



    @ApiOperation(value = "自动回复开/关")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "configId", value = "自动回复配置id", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "开关（0：执行；1：暂停）", dataType = "String", paramType = "query")
    })
    @PostMapping("/replyConfigSwitch")
    public JsonResultT<?> replyConfigSwitch(@RequestParam(value = "configId") Integer  configId,
                                             @RequestParam(value = "status")Integer status){
        if(configId==null){
            return JsonResultT.error("请传入配置id");
        }
        if(status==null){
            return JsonResultT.error("请传入状态");
        }
        return configService.replyConfigSwitch(configId,status);
    }

    @ApiOperation("新增/修改僵尸粉配置")
    @PostMapping("/saveOrUpdateZombieConfig")
    public JsonResult saveOrUpdateZombieConfig(@RequestBody ZombieConfigDtoIn configDto) {
         return configService.saveOrUpdateZombieConfig(configDto);
    }


    @ApiOperation("查询僵尸粉配置")
    @PostMapping("/getZombieConfig")
    public JsonResult getZombieConfig() {
        return configService.getZombieConfig();
    }


    @ApiOperation(value = "更新僵尸粉上次检测时间配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "executeTime", value = "僵尸粉检测执行时间", dataType = "String", paramType = "query"),
    })
    @PostMapping("/updateZombieConfigLastTime")
    public JsonResult updateZombieConfigLastTime(@RequestParam("executeTime")String executeTime) {
        return configService.updateZombieConfigLastTime(executeTime);
    }
}
