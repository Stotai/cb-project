package com.qianya.web.controller;


import com.qianya.common.JsonResultT;
import com.qianya.entity.CricleFriends;
import com.qianya.model.in.CricleFriendsDetailDtoIn;
import com.qianya.model.in.CricleFriendsDtoIn;
import com.qianya.model.in.PullGroupDetailDtoIn;
import com.qianya.model.in.PullGroupDtoIn;
import com.qianya.model.out.CircleFriendsDtoOut;
import com.qianya.model.out.MassSendingDraftDetailDtoOut;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.DateUtil;
import com.qianya.util.StringUtil;
import com.qianya.web.service.CricleFriendsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-16  17:20
 * @Description: 朋友圈
 */
@RestController
@Api(value = "CricleFriendsController", tags = "朋友圈")
@RequestMapping("/cricle")
public class CricleFriendsController {



    @Autowired
    private CricleFriendsService cricleFriendsService;

    @PostMapping("/addCricle")
    @ApiOperation("新增发朋友圈")
    public JsonResultT<?> addCricle(@RequestBody CricleFriendsDtoIn cricleFriendsDtoIn) {
        //校验参数
        if (StringUtil.isEmpty(cricleFriendsDtoIn.getCircleName())) {
            return JsonResultT.error("请传入朋友圈任务名称");
        }
        if (StringUtil.isEmpty(cricleFriendsDtoIn.getSendTime())) {
            return JsonResultT.error("请选择发送时间");
        }
        String nowTime = DateUtil.getNowFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
        if(cricleFriendsDtoIn.getSendTime().compareTo(nowTime)<=0){
            return JsonResultT.error("请选择当前时间之后");
        }
        List<CricleFriendsDetailDtoIn> detailDtoInList = cricleFriendsDtoIn.getDetailDtoInList();
        // 遍历明细表参数，根据itemType进行校验
        for (CricleFriendsDetailDtoIn itemEntity : detailDtoInList) {
            Integer itemType = itemEntity.getItemType();
            if (itemType == null) {
                return JsonResultT.error("方案明细参数中的itemType不能为空");
            }
            if (itemEntity.getDetailType() == null) {
                return JsonResultT.error("内容类型不能为空");
            }
            if (itemEntity.getWaitSeconds() == null) {
                return JsonResultT.error("请填写好友验证等待时长");
            }
            if (itemEntity.getSort() == null) {
                return JsonResultT.error("请传入序号");
            }
            // 根据itemType进行对应字段的校验
            switch (itemType) {
                case 1:
                    // 文本类型校验逻辑
                    // 校验itemContent字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getItemContent())) {
                        return JsonResultT.error("消息内容不为空");
                    }
                    break;
                case 2:
                case 3:
                    // 视频类型校验逻辑
                    // 校验fileUrl字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getFileUrl())) {
                        return JsonResultT.error("文件地址不能为空");
                    }
                    break;
                case 4:
                    // 卡片消息类型校验逻辑
                    // 校验cardTitle字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getCardTitle())) {
                        return JsonResultT.error("卡片标题不能为空");
                    }
                    // 校验cardContent字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getCardTitle())) {
                        return JsonResultT.error("卡片内容不能为空");
                    }
                    // 校验cardImgUrl字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getCardImgUrl())) {
                        return JsonResultT.error("卡片图片地址不能为空");
                    }
                    // 校验cardImgUrl字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getCardUrl())) {
                        return JsonResultT.error("卡片链接不能为空");
                    }
                    break;
                default:
                    return JsonResultT.error("未知的itemType类型");
            }
        }
        return cricleFriendsService.addCricle(cricleFriendsDtoIn);
    }


    @PostMapping("/draftList")
    @ApiOperation(value = "模板列表")
    public JsonResultT<CommonPage<SchemeDraftDtoOut>> getDraftList(
            @ApiParam(value = "模板内容", required = false) @RequestParam(value = "content", required = false) String content,
            @ApiParam(value = "页码", required = false)   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @ApiParam(value = "页大小", required = false)   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return cricleFriendsService.draftList(content,pageNum,pageSize);
    }


    @PostMapping("/getDrafDetail")
    @ApiOperation(value = "获取模板内容")
    public JsonResultT<?> getDrafDetail(@ApiParam(value = "模板id") @RequestParam(value = "circleId") Integer circleId
    ) {
        if(circleId==null){
            return JsonResultT.error("请传入要查询的模板id");
        }
        return cricleFriendsService.getDrafDetail(circleId);
    }

    @ApiOperation("根据内容和企业微信id多选查询朋友圈信息")
    @PostMapping("/circle-friends")
    public JsonResultT<CommonPage<CircleFriendsDtoOut>> searchCircleFriends(
            @ApiParam(value = "内容") @RequestParam(required = false) String content,
            @ApiParam(value = "企业微信id列表，以逗号拼接") @RequestParam(required = false) String exriseWxIds,
            @ApiParam(value = "页码") @RequestParam(defaultValue = "0") Integer pageNum,
            @ApiParam(value = "每页数量") @RequestParam(defaultValue = "10") Integer pageSize
    ){

        return cricleFriendsService.searchCircleFriends(content,exriseWxIds,pageNum,pageSize);
    }

    @ApiOperation(value = "删除朋友圈", notes = "根据删除朋友圈ID删除删除朋友圈")
    @PostMapping("/deleteCircle")
    public JsonResultT<?> deleteCircle(
            @ApiParam(value = "删除朋友圈ID", required = true) @RequestParam("circleId") Integer circleId
    ) {
        if (circleId == null) {
            return JsonResultT.error("请传入要删除的朋友圈id");
        }
        return cricleFriendsService.deleteCircle(circleId);
    }

}
