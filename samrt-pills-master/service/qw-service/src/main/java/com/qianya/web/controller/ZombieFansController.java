package com.qianya.web.controller;

import com.github.pagehelper.PageInfo;
import com.qianya.common.JsonResultT;
import com.qianya.entity.User;
import com.qianya.model.Do.IUserDo;
import com.qianya.model.in.ZombieFansEditDtoIn;
import com.qianya.util.CommonPage;
import com.qianya.web.service.LoginService;
import com.qianya.web.service.ZombieFanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.qianya.model.in.ZombieFanDtoIn;
import com.qianya.model.out.ZombieFanDtoOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-18  18:23
 * @Description: 僵尸粉管理
 */
@RestController
@Api(value = "ZombieFansController", tags = "僵尸粉管理")
@RequestMapping("/zombieFans")
public class ZombieFansController {



    @Autowired
    private ZombieFanService zombieFanService;
    @Autowired
    private LoginService loginService;


    @ApiOperation(value = "分页查询僵尸粉列表")
    @PostMapping("/getZombieFansPage")
    public JsonResultT<CommonPage<ZombieFanDtoOut>> getZombieFansPage(
            @ApiParam(value = "页码", required = true) @RequestParam Integer pageNo,
            @ApiParam(value = "每页数量", required = true) @RequestParam Integer pageSize,
            @ApiParam(value = "所属微信ID列表") @RequestParam(required = false) List<String> exriseUserIds,
            @ApiParam(value = "处理状态") @RequestParam(required = false) Integer status,
            @ApiParam(value = "粉丝昵称模糊查询") @RequestParam(required = false) String custNickName
    ) {
        // 调用Service层方法查询分页数据
         return zombieFanService.getZombieFansPage(pageNo,pageSize,exriseUserIds,status,custNickName);
    }


    @PostMapping("/batchInsertZombieFans")
    @ApiOperation("批量录入僵尸粉(检测僵尸粉)")
    public JsonResultT<?> batchInsertZombieFans(@RequestBody List<ZombieFanDtoIn> zombieFanDtoIns) {
        // 校验参数
        if (CollectionUtils.isEmpty(zombieFanDtoIns)) {
            return JsonResultT.error("请输入待录入的僵尸粉数据");
        }
        //获取登录用户
        IUserDo user=loginService.selectUser();
        return zombieFanService.batchInsertZombieFans(zombieFanDtoIns,user);
    }



    @ApiOperation("批量操作僵尸粉")
    @PostMapping("/batchEditZombieFans")
    public JsonResultT<?> batchEditZombieFans(@RequestBody ZombieFansEditDtoIn zombieFansEditDtoIn) {
        if (zombieFansEditDtoIn.getFanIds().isEmpty()) {
            return JsonResultT.error("删除的粉丝ID列表不能为空");
        }
        if(zombieFansEditDtoIn.getOpType()==null){
            return JsonResultT.error("操作类型不能为空");
        }
        int count = zombieFanService.batchEditZombieFans(zombieFansEditDtoIn.getFanIds(),zombieFansEditDtoIn.getOpType());
        if (count > 0) {
            return JsonResultT.ok("成功处理" + count + "个粉丝");
        } else {
            return JsonResultT.error("操作失败");
        }
    }
}
