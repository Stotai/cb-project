package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-26  09:17
 * @Description: 自动回复配置
 */
public class ReplyConfigDtoIn implements Serializable {


    private static final long serialVersionUID = 3333860609296109602L;

    @ApiModelProperty(value = "配置id/修改时传")
    private Integer replyConfigId;


    @ApiModelProperty(value = "适用微信id(以逗号拼接)")
    private String exriseUserIds;

    @ApiModelProperty(value = "好友回复状态(0:开启;1:关闭)")
    private Integer cronyStauts;

    @ApiModelProperty(value = "群回复状态(0:开启;1:关闭)")
    private Integer groupStatus;

    @ApiModelProperty(value = "回复频率")
    private Integer replyFrequency;

    @ApiModelProperty(value = "关键字触发状态(0:开启;1:关闭)")
    private Integer keywordsStatus;

    @ApiModelProperty(value = "模糊关键字以逗号拼接")
    private String keywords;

    @ApiModelProperty(value = "精准关键字以逗号拼接")
    private String eqKeywords;

    @ApiModelProperty(value = "序号")
    private Integer sort;

    @ApiModelProperty(value = "适用微信(0:全部微信;1:指定微信)")
    private Integer exriseUserType;


    @ApiModelProperty(value = "更多触发类型(1:图片;2:视频;3:卡片消息;4:文件消息;5:名片消息;6:合并消息;7:小程序消息)")
    private String triggerType;

    @ApiModelProperty(value = "明细列表")
    private List<ReplyConfigDetailDtoIn> detailList;


    @ApiModelProperty(value = "开启好友/群聊本人消息激活回复(0:开启;1:关闭)")
    private Integer cronyGroupSelfStauts;

    @ApiModelProperty(value = "回复设置(1:按顺序全部回复;2:随机回复一条)")
    private Integer replyType;


    public Integer getCronyStauts() {
        return cronyStauts;
    }

    public void setCronyStauts(Integer cronyStauts) {
        this.cronyStauts = cronyStauts;
    }

    public Integer getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }

    public Integer getReplyFrequency() {
        return replyFrequency;
    }

    public void setReplyFrequency(Integer replyFrequency) {
        this.replyFrequency = replyFrequency;
    }

    public Integer getKeywordsStatus() {
        return keywordsStatus;
    }

    public void setKeywordsStatus(Integer keywordsStatus) {
        this.keywordsStatus = keywordsStatus;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<ReplyConfigDetailDtoIn> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<ReplyConfigDetailDtoIn> detailList) {
        this.detailList = detailList;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public Integer getReplyConfigId() {
        return replyConfigId;
    }

    public void setReplyConfigId(Integer replyConfigId) {
        this.replyConfigId = replyConfigId;
    }

    public String getExriseUserIds() {
        return exriseUserIds;
    }

    public void setExriseUserIds(String exriseUserIds) {
        this.exriseUserIds = exriseUserIds;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getExriseUserType() {
        return exriseUserType;
    }

    public void setExriseUserType(Integer exriseUserType) {
        this.exriseUserType = exriseUserType;
    }

    public String getEqKeywords() {
        return eqKeywords;
    }

    public void setEqKeywords(String eqKeywords) {
        this.eqKeywords = eqKeywords;
    }

    public void setCronyGroupSelfStauts(Integer cronyGroupSelfStauts) {
        this.cronyGroupSelfStauts = cronyGroupSelfStauts;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public Integer getCronyGroupSelfStauts() {
        return cronyGroupSelfStauts;
    }

    public Integer getReplyType() {
        return replyType;
    }
}
