package com.qianya.web.controller;

import com.qianya.common.JsonResultT;
import com.qianya.entity.PullGroup;
import com.qianya.mapper.PullGroupMapper;
import com.qianya.model.in.PullConfigDtoIn;
import com.qianya.model.in.PullGroupDetailDtoIn;
import com.qianya.model.in.PullGroupDtoIn;
import com.qianya.util.CommonPage;
import com.qianya.util.StringUtil;
import com.qianya.web.service.PullGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-15  18:20
 * @Description:  批量拉群
 */
@RestController
@Api(value = "PullGroupController", tags = "批量拉群")
@RequestMapping("/pullGroup")
public class PullGroupController {


    @Autowired
    private PullGroupService pullGroupService;
    @Autowired
    private PullGroupMapper pullGroupMapper;


    @PostMapping("/addPull")
    @ApiOperation("新增批量拉群")
    public JsonResultT<?> addPull(@RequestBody PullGroupDtoIn pullGroupDtoIn) {
        //校验参数
        if (CollectionUtils.isEmpty(pullGroupDtoIn.getGroupIds())) {
            return JsonResultT.error("请传入目标群id");
        }
        List<PullGroupDetailDtoIn> detailDtoInList = pullGroupDtoIn.getDetailDtoInList();
        // 遍历明细表参数，根据itemType进行校验
        for (PullGroupDetailDtoIn itemEntity : detailDtoInList) {
            Integer itemType = itemEntity.getItemType();
            if (itemType == null) {
                return JsonResultT.error("方案明细参数中的itemType不能为空");
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
                case 4:
                    // 视频类型校验逻辑
                    // 校验fileUrl字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getFileUrl())) {
                        return JsonResultT.error("文件地址不能为空");
                    }
                    break;
                case 5:
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
                case 6:
                    // 小程序类型校验逻辑
                    // 校验userName字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getUserName())) {
                        return JsonResultT.error("小程序用户名不能为空");
                    }
                    // 校验appId字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getAppId())) {
                        return JsonResultT.error("小程序AppId不能为空");
                    }
                    // 校验title字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getTitle())) {
                        return JsonResultT.error("小程序标题不能为空");
                    }
                    // 校验pagePath字段是否为空
                    if (StringUtil.isEmpty(itemEntity.getPagePath())) {
                        return JsonResultT.error("小程序页面路径不能为空");
                    }
                    if (StringUtil.isEmpty(itemEntity.getFileId())) {
                        return JsonResultT.error("小程序fileId不能为空");
                    }
                    if (StringUtil.isEmpty(itemEntity.getAesKey())) {
                        return JsonResultT.error("小程序小程序aes_key不能为空");
                    }
                    if (StringUtil.isEmpty(itemEntity.getMd5())) {
                        return JsonResultT.error("小程序md5不能为空");
                    }
                    if (StringUtil.isEmpty(itemEntity.getSize())) {
                        return JsonResultT.error("小程序size不能为空");
                    }
                    break;
                case 7:
                    // 视频号类型校验逻辑
                    // 校验nickName字段是否为空或空字符串
                    if (StringUtil.isEmpty(itemEntity.getNickName())) {
                        return JsonResultT.error("视频号昵称不能为空");
                    }
                    // 校验desc字段是否为空或空字符串
                    if (StringUtil.isEmpty(itemEntity.getVideoDesc())) {
                        return JsonResultT.error("视频号描述不能为空");
                    }
                    // 校验avatar字段是否为空或空字符串
                    if (StringUtil.isEmpty(itemEntity.getAvatar())) {
                        return JsonResultT.error("视频号头像不能为空");
                    }
                    // 校验coverUrl字段是否为空或空字符串
                    if (StringUtil.isEmpty(itemEntity.getCoverUrl())) {
                        return JsonResultT.error("视频号封面地址不能为空");
                    }
                    // 校验feedType字段是否为空或空字符串
                    if (StringUtil.isEmpty(itemEntity.getFeedType())) {
                        return JsonResultT.error("视频号feed_type不能为空");
                    }
                    // 校验thumbUrl字段是否为空或空字符串
                    if (StringUtil.isEmpty(itemEntity.getThumbUrl())) {
                        return JsonResultT.error("视频号thumb_url不能为空");
                    }
                    // 校验url字段是否为空或空字符串
                    if (StringUtil.isEmpty(itemEntity.getUrl())) {
                        return JsonResultT.error("视频号url不能为空");
                    }
                    // 校验extras字段是否为空或空字符串
                    if (StringUtil.isEmpty(itemEntity.getExtras())) {
                        return JsonResultT.error("视频号extras不能为空");
                    }
                    break;
                default:
                    return JsonResultT.error("未知的itemType类型");
            }
        }
        return pullGroupService.addPull(pullGroupDtoIn);
    }


    @PostMapping("/getPullGroups")
    @ApiOperation("根据条件分页查询拉群数据")
    public JsonResultT<CommonPage<PullGroup>> getPullGroups(
            @ApiParam(value = "企业微信id列表，多选，以逗号分割") @RequestParam(value = "exriseWxIds", required = false) List<String> exriseWxIds,
            @ApiParam(value = "拉群名称，模糊查询") @RequestParam(value = "pullName", required = false) String pullName,
            @ApiParam(value = "状态") @RequestParam(value = "status", required = false) Integer status,
            @ApiParam(value = "页码，默认为1") @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @ApiParam(value = "每页数量，默认为10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {

        return pullGroupService.findByExriseWxIdsAndPullName(exriseWxIds, pullName, status, pageNum, pageSize);
    }

    @PostMapping("/updateSendState")
    @ApiOperation(value = "修改发送结果")
    public JsonResultT<?> updateSendState(@ApiParam(value = "拉群id") @RequestParam(value = "pullId") Integer pullId,
                                          @ApiParam(value = "客户id") @RequestParam(value = "customerId") Integer customerId,
                                          @ApiParam(value = "发送结果 1成功 2失败") @RequestParam(value = "state") Integer state,
                                          @ApiParam(value = "失败原因") @RequestParam(value = "failMsg",required = false) String failMsg) {
        return pullGroupService.updateSendState(pullId,customerId,state,failMsg);
    }

    @PostMapping("/deletePullGroup")
    @ApiOperation("根据主键id删除拉群记录")
    public JsonResultT<?> deletePullGroup(@ApiParam("主键id")@RequestParam("pullId") Integer pullId) {
        pullGroupMapper.deleteByPrimaryKey(pullId);
        return JsonResultT.ok("删除成功");
    }


    @PostMapping("/savePullConfig")
    @ApiOperation("新增或修改拉群配置")
    public JsonResultT<?> savePullConfig(@RequestBody PullConfigDtoIn pullConfigDtoIn) {
        return pullGroupService.savePullConfig(pullConfigDtoIn);
    }



    @PostMapping("/getPullConfig")
    @ApiOperation("获取拉群配置")
    public JsonResultT<?> getPullConfig() {
        return pullGroupService.getPullConfig();
    }


}
