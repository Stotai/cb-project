package com.qianya.web.controller;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-06  16:45
 * @Description: TODO
 */

import com.qianya.common.JsonResultT;
import com.qianya.entity.mongo.MassSendingMainMoEntity;
import com.qianya.model.in.MassSendingDetailDtoIn;
import com.qianya.model.in.MassSendingDtoIn;
import com.qianya.model.out.MassSendingDraftDetailDtoOut;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.PageResult;
import com.qianya.util.StringUtil;
import com.qianya.web.service.MassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-06  18:20
 * @Description: 群发
 */
@RestController
@Api(value = "MassController", tags = "群发")
@RequestMapping("/mass")
public class MassController {


    @Autowired
    private MassService massService;


    @PostMapping("/editMass")
    @ApiOperation("新增/修改群发")
    public JsonResultT<?> addScheme(@RequestBody MassSendingDtoIn massSendingDtoIn) {
        // 校验SchemeEntity参数是否为空
        if (massSendingDtoIn == null) {
            return JsonResultT.error("群发主体信息不能为空");
        }
        if (massSendingDtoIn.getMassType() == null) {
            return JsonResultT.error("群发类型不能为空");
        }
        if (StringUtil.isEmpty(massSendingDtoIn.getMassName())) {
            return JsonResultT.error("群发名称不能为空");
        }
        // 校验明细表参数是否为空
        List<MassSendingDetailDtoIn> itemList = massSendingDtoIn.getDetailDtoInList();
        if (itemList == null || itemList.isEmpty()) {
            return JsonResultT.error("群发明细参数不能为空");
        }

        // 遍历明细表参数，根据itemType进行校验
        for (MassSendingDetailDtoIn itemEntity : itemList) {
            Integer itemType = itemEntity.getItemType();
            if (itemType == null) {
                return JsonResultT.error("群发明细参数中的itemType不能为空");
            }
            if(itemEntity.getSort()==null){
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
        // 执行新增/修改群发的业务逻辑
        return massService.editMass(massSendingDtoIn);
    }


    @PostMapping("/operateMass")
    @ApiOperation(value = "根据群发d操作群发记录(删除/开启/暂停)")
    public JsonResultT<?> operateMass(
            @ApiParam(value = "群发", required = true) @RequestParam("massId") Integer massId,
            @ApiParam(value = "状态(0:执行中;1:暂停;2:删除)", required = false) @RequestParam(value = "status") Integer status) {
        if (massId == null) {
            return JsonResultT.error("群发id不能为空");
        }
        if (status == null) {
            return JsonResultT.error("请传入stats");
        }
        return massService.operateMass(massId, status);
    }


    @PostMapping("/getMassDetail")
    @ApiOperation(value = "查询群发记录详情")
    public JsonResultT<?> getMassDetail(
            @ApiParam(value = "群发id", required = true) @RequestParam("massId") Integer massId) {
        if (massId == null) {
            return JsonResultT.error("群发id不能为空");
        }
        return massService.getMassDetail(massId);
    }


    @PostMapping("/list")
    @ApiOperation(value = "查询群发列表")
    public JsonResultT<?> getMassList(
            @ApiParam(value = "群发内容/名称", required = false) @RequestParam(value = "content", required = false) String content,
            @ApiParam(value = "企业微信id以逗号拼接", required = false) @RequestParam(value = "exexriseUserIds", required = false) String exexriseUserIds,
            @ApiParam(value = "群发类型(1:极速群发;2:高级群发)", required = false) @RequestParam(value = "massCommonType", required = false) Integer massCommonType,
            @ApiParam(value = "页码", required = false) @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @ApiParam(value = "页大小", required = false) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        if(massCommonType==null){
            return JsonResultT.error("请传入群发类型");
        }
        return massService.getMassList(content,exexriseUserIds,massCommonType,pageNum,pageSize);
    }

    @PostMapping("/updateSendState")
    @ApiOperation(value = "修改发送结果")
    public JsonResultT<?> updateSendState(@ApiParam(value = "消息id") @RequestParam(value = "massId") Integer massId,@ApiParam(value = "业务id") @RequestParam(value = "workId") String workId,@ApiParam(value = "发送结果 1成功 2失败") @RequestParam(value = "state") Integer state,@ApiParam(value = "失败原因") @RequestParam(value = "failMsg",required = false) String failMsg) {
        return massService.updateSendState(massId,workId,state,failMsg);
    }


    @PostMapping("/queryMassSendRecord")
    @ApiOperation(value = "群发记录查询")
    public JsonResultT<PageResult<MassSendingMainMoEntity>> queryMassSendRecord( @ApiParam(value = "群发内容", required = false) @RequestParam(value = "content", required = false) String content,
                                                                                      @ApiParam(value = "企业微信id以逗号拼接", required = false) @RequestParam(value = "exexriseUserIds", required = false) String exexriseUserIds,
                                                                                      @ApiParam(value = "群发类型(1:极速群发;2:高级群发)", required = false) @RequestParam(value = "massCommonType", required = false) Integer massCommonType,
                                                                                      @ApiParam(value = "页码", required = false)   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                                      @ApiParam(value = "页大小", required = false)   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        if(massCommonType==null){
            return JsonResultT.error("请传入群发类型");
        }
        return massService.queryMassSendRecord(content,exexriseUserIds,massCommonType,pageNum,pageSize);
    }




    @PostMapping("/draftList")
    @ApiOperation(value = "模板列表")
    public JsonResultT<CommonPage<SchemeDraftDtoOut>> getDraftList(
            @ApiParam(value = "模板内容", required = false) @RequestParam(value = "content", required = false) String content,
            @ApiParam(value = "页码", required = false)   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @ApiParam(value = "页大小", required = false)   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return massService.draftList(content,pageNum,pageSize);
    }


    @PostMapping("/getDrafDetail")
    @ApiOperation(value = "获取模板内容")
    public JsonResultT<MassSendingDraftDetailDtoOut> getDrafDetail(@ApiParam(value = "模板id") @RequestParam(value = "massId") Integer massId
    ) {
        if(massId==null){
            return JsonResultT.error("请传入要查询的模板id");
        }
        return massService.getDrafDetail(massId);
    }


    @PostMapping("/test")
    @ApiOperation(value = "获取模板内容")
    public JsonResultT<MassSendingDraftDetailDtoOut> getDrafDetail() {
           massService.massTask();
           return JsonResultT.ok();
    }

}
