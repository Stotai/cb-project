package com.qianya.web.controller;

import com.qianya.common.JsonResult;
import com.qianya.common.JsonResultT;
import com.qianya.entity.GroupCust;
import com.qianya.entity.Groupping;
import com.qianya.model.in.*;
import com.qianya.model.out.GrouppingDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.GrainBeanUtils;
import com.qianya.util.StringUtil;
import com.qianya.web.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-12  16:48
 * @Description: 群管理
 */
@RestController
@Api(value = "GroupController", tags = "群管理")
@RequestMapping("/group")
public class GroupController {


    @Autowired
    private GroupService groupService;


    @PostMapping("/createGrouping")
    @ApiOperation("新增/修改群分组")
    public JsonResult editGrouping(
            @ApiParam(value = "群分组id(修改时传)") @RequestParam(value = "grouppingId",required = false) Integer grouppingId,
            @ApiParam(value = "群分组名称", required = true) @RequestParam(value = "groupName") String groupName) {
        if (StringUtil.isEmpty(groupName)) {
            return JsonResult.error("群分组名称不能为空");
        }
        return groupService.editGrouping(grouppingId,groupName);
    }

    @PostMapping("/grouppingList")
    @ApiOperation("群分组列表")
    public JsonResult grouppingList() {
        List<Groupping> grouppingList = groupService.grouppingList();
        return JsonResult.ok(GrainBeanUtils.convertList(grouppingList, GrouppingDtoOut.class));
    }


    @PostMapping("/deleteGrouppping")
    @ApiOperation("删除群分组")
    public JsonResult deleteGrouppping(  @ApiParam(value = "群分组id", required = true) @RequestParam(value = "grouppingId") Integer grouppingId) {
        if(grouppingId==null){
            return JsonResult.error("请传入要删除的群id");
        }
        return groupService.deleteGrouppping(grouppingId);
    }

    @PostMapping("/refreshGroup")
    @ApiOperation("初始化/刷新 群主体信息数据")
    public JsonResult refreshGroup(@RequestBody  List<GroupDtoIn> groupDtoIns){
         if(CollectionUtils.isEmpty(groupDtoIns)){
             return JsonResult.ok();
         }
         return groupService.refreshGroup(groupDtoIns);
    }

    @PostMapping("/refreshGroupCust")
    @ApiOperation("初始化/刷新群成员数据")
    public JsonResult refreshGroupCust(@RequestBody  List<GroupCustDtoIn> groupCustDtoIns){
        if(CollectionUtils.isEmpty(groupCustDtoIns)){
            return JsonResult.ok();
        }
        return groupService.refreshGroupCust(groupCustDtoIns);
    }

    @PostMapping("/groupByPing")
    @ApiOperation("分组")
    public JsonResult groupByPing( @ApiParam(value = "群分组id",required = true) @RequestParam(value = "grouppingId") Integer grouppingId,
                                   @ApiParam(value = "群分组id(数据库主键id)",required = true) @RequestParam(value = "groupId") String groupId){
           if(grouppingId==null){
               return JsonResult.error("请传入群分组id");
           }
           if(StringUtil.isEmpty(groupId)){
               return JsonResult.error("请传入要添加分组的群id");
           }
           return groupService.groupByPing(groupId,grouppingId);
   }


   @PostMapping("/queryGroupList")
   @ApiOperation("群列表")
   public JsonResult  queryGroupList(@RequestBody GroupParamsDtoIn paramsDtoIn){
       return groupService.queryGroupList(paramsDtoIn);
   }


    @PostMapping("/queryGroupCustList")
    @ApiOperation("群成员列表")
    public JsonResultT<CommonPage<GroupCust>> queryGroupCustList(@RequestBody GroupCustParamsDtoIn paramsDtoIn){
        return groupService.queryGroupCustList(paramsDtoIn);
    }

    @ApiOperation("入群增加邀请次数")
    @PostMapping("/addGroupInviteTimes")
    public JsonResult addGroupInviteTimes(@ApiParam(value = "群id(本地id)", required = true) @RequestParam(value = "groupWxId") String groupWxId,
                                          @ApiParam(value = "邀请人id(本地id)", required = true) @RequestParam(value = "userId") String userId) {
        return groupService.addGroupInviteTimes(groupWxId,userId);
    }


    @PostMapping("/saveGroupInviteConfig")
    @ApiOperation("新增或修改群邀请配置")
    public JsonResultT<?> saveGroupInviteConfig(@RequestBody GroupInviteConfigDtoIn groupInviteConfigDtoIn) {
        return groupService.saveGroupInviteConfig(groupInviteConfigDtoIn);
    }

    @PostMapping("/getGroupInviteConfig")
    @ApiOperation("获取群邀请配置")
    public JsonResultT<?> getGroupInviteConfig() {
        return groupService.getGroupInviteConfig();
    }



}
