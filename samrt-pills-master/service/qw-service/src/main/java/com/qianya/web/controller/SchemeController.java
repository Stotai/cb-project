package com.qianya.web.controller;

import com.qianya.common.JsonResultT;
import com.qianya.model.out.SchemeDraftDtoOut;
import com.qianya.model.out.SchemeDtoOut;
import com.qianya.util.CommonPage;
import com.qianya.util.StringUtil;
import com.qianya.web.service.SchemeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.qianya.model.in.AddSchemeParamDtoIn;
import com.qianya.model.in.SchemeItemDtoIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-15  18:20
 * @Description: 新客户运营
 */
@RestController
@Api(value = "SchemeController", tags = "新客户运营")
@RequestMapping("/scheme")
public class SchemeController {


    @Autowired
    private SchemeService schemeService;



    @PostMapping("/addScheme")
    @ApiOperation("新增方案")
    public JsonResultT<?> addScheme(@RequestBody AddSchemeParamDtoIn param) {
        // 校验SchemeEntity参数是否为空
        if (param == null) {
            return JsonResultT.error("方案主体信息不能为空");
        }
        if (param.getSex() == null) {
            return JsonResultT.error("触发条件不能为空");
        }

        if (param.getStatus() == null) {
            return JsonResultT.error("开启状态不能为空");
        }

        // 校验明细表参数是否为空
        List<SchemeItemDtoIn> itemList = param.getItemList();
        if (itemList == null || itemList.isEmpty()) {
            return JsonResultT.error("方案明细参数不能为空");
        }

        // 遍历明细表参数，根据itemType进行校验
        for (SchemeItemDtoIn itemEntity : itemList) {
            Integer itemType = itemEntity.getItemType();
            if (itemType == null) {
                return JsonResultT.error("方案明细参数中的itemType不能为空");
            }
            if (itemEntity.getWaitSeconds() == null) {
                return JsonResultT.error("请填写好友验证等待时长");
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
                case 8:
                    // 邀请入群类型校验逻辑
                    // 校验groupIds字段是否为空
                    if (itemEntity.getGroupIds() == null) {
                        return JsonResultT.error("邀请入群ID不能为空");
                    }
                    break;
                case 9:
                    // 催入群类型校验逻辑
                    // 校验urgeExitType字段是否为空
                    int urgeExitType = itemEntity.getUrgeExitType();
                    String errorMessage = null;
                    switch (urgeExitType) {
                        case 1:
                            // 文本类型校验逻辑
                            errorMessage = StringUtil.isEmpty(itemEntity.getItemContent()) ? "催入群的消息内容不能为空" : null;
                            break;
                        case 2:
                            // 图片类型校验逻辑
                            errorMessage = StringUtil.isEmpty(itemEntity.getFileUrl()) ? "催入群的图片不能为空" : null;
                            break;
                        default:
                            // 其他类型校验逻辑
                            errorMessage = StringUtil.isEmpty(itemEntity.getGroupIds()) ? "催入群的群id不能为空" : null;
                            break;
                    }
                    if (errorMessage != null) {
                        return JsonResultT.error(errorMessage);
                    }
                    break;
                case 10:
                    // 催入群类型校验逻辑
                    // 校验urgeExitType字段是否为空
                    int exitType = itemEntity.getUrgeExitType();
                    String errorMsg = null;
                    switch (exitType) {
                        case 1:
                            // 文本类型校验逻辑
                            errorMsg = StringUtil.isEmpty(itemEntity.getItemContent()) ? "退群消息内容不能为空" : null;
                            break;
                        case 2:
                            // 图片类型校验逻辑
                            errorMsg = StringUtil.isEmpty(itemEntity.getFileUrl()) ? "退群消息的图片不能为空" : null;
                            break;
                        default:
                            // 其他类型校验逻辑
                            errorMsg = StringUtil.isEmpty(itemEntity.getGroupIds()) ? "退群消息群id不能为空" : null;
                            break;
                    }
                    if (errorMsg != null) {
                        return JsonResultT.error(errorMsg);
                    }
                    break;
                default:
                    return JsonResultT.error("未知的itemType类型");
            }
        }
        // 执行新增/修改方案的业务逻辑
        return schemeService.addScheme(param);
    }


    @PostMapping("/deleteScheme")
    @ApiOperation(value = "根据主键方案id删除方案")
    public JsonResultT<?> deleteScheme(
            @ApiParam(value = "方案id", required = true) @RequestParam("schemeId") Integer schemeId) {
        if (schemeId == null) {
            return JsonResultT.error("方案id不能为空");
        }
        return schemeService.deleteScheme(schemeId);
    }


    @PostMapping("/list")
    @ApiOperation(value = "查询方案列表")
    public JsonResultT<List<SchemeDtoOut>> getSchemeList() {
         return schemeService.list();
    }


    @PostMapping("/draftList")
    @ApiOperation(value = "模板列表")
    public JsonResultT<CommonPage<SchemeDraftDtoOut>> getDraftList(
            @ApiParam(value = "模板内容", required = false) @RequestParam(value = "content", required = false) String content,
            @ApiParam(value = "页码", required = false)   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @ApiParam(value = "页大小", required = false)   @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return schemeService.draftList(content,pageNum,pageSize);
    }



    @PostMapping("/getDrafDetail")
    @ApiOperation(value = "获取模板内容")
    public JsonResultT<SchemeDtoOut> getDrafDetail(@ApiParam(value = "模板id") @RequestParam(value = "schemeId") Integer schemeId
    ) {
         if(schemeId==null){
             return JsonResultT.error("请传入要查询的模板id");
         }

        return schemeService.getDrafDetail(schemeId);
    }



    @ApiOperation("根据ID开启或关闭方案")
    @PostMapping("/updateSchemeStatus")
    public JsonResultT<?> updateSchemeStatus(
            @ApiParam(value = "方案ID", required = true)
            @RequestParam("schemeId") Integer schemeId,
            @ApiParam(value = "状态（0:关闭; 1:开启）", required = true)
            @RequestParam("status") Integer status
    ) {
        if(schemeId==null){
            return JsonResultT.error("请传入要开启的状态");
        }
        if(status==null){
            return JsonResultT.error("请传入要修改的状态");
        }
        return schemeService.updateSchemeStatus(schemeId, status);
    }


}
