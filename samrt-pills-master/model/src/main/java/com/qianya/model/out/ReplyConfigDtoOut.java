package com.qianya.model.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-01  16:25
 * @Description: 自动回复分页输出类
 */
public class ReplyConfigDtoOut implements Serializable {

    private static final long serialVersionUID = -6126837349781518521L;
    //配置id
    @ApiModelProperty(value = "自动回复id")
    private Integer  configId;

    @ApiModelProperty(value = "模糊关键词")
    private String   keywords;


    @ApiModelProperty(value = "精确关键词")
    private String   eqKeywords;


    //触发频率
    @ApiModelProperty(value = "触发频率")
    private Integer replyFrequency;

    @ApiModelProperty(value = "回复内容")
    private String content;

    @ApiModelProperty(value = "匹配类型(0:模糊匹配;1:精准匹配)")
    private Integer matchType;


    @ApiModelProperty(value = "状态(0:执行中;1:暂停)")
    private Integer replyStatus;


    @ApiModelProperty(value = "适用微信(0:全部微信;1:指定微信)")
    private Integer  applyExriseWx;


    @ApiModelProperty(value = "适用好友(0:否;1:是)")
    private Integer applyFriends;

    @ApiModelProperty(value = "适用群(0:否;1:是)")
    private Integer applyGroup;

    @ApiModelProperty(value = "更多触发类型以逗号拼接(1:图片;2:视频;3:卡片消息;4:文件消息;5:名片消息;6:合并消息;7:小程序消息)")
    private String triggerType;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "回复设置(1:按顺序全部回复;2:随机回复一条)")
    private Integer replyType;
    @ApiModelProperty(value = "开启好友/群聊本人消息激活回复(0:开启;1:关闭)")
    private Integer cronyGroupSelfStauts;
    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }


    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    public Integer getReplyFrequency() {
        return replyFrequency;
    }

    public void setReplyFrequency(Integer replyFrequency) {
        this.replyFrequency = replyFrequency;
    }

    public Integer getMatchType() {
        return matchType;
    }

    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    public Integer getApplyExriseWx() {
        return applyExriseWx;
    }

    public void setApplyExriseWx(Integer applyExriseWx) {
        this.applyExriseWx = applyExriseWx;
    }

    public Integer getApplyFriends() {
        return applyFriends;
    }

    public void setApplyFriends(Integer applyFriends) {
        this.applyFriends = applyFriends;
    }

    public Integer getApplyGroup() {
        return applyGroup;
    }

    public void setApplyGroup(Integer applyGroup) {
        this.applyGroup = applyGroup;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }


    public Integer getCronyGroupSelfStauts() {
        return cronyGroupSelfStauts;
    }

    public void setCronyGroupSelfStauts(Integer cronyGroupSelfStauts) {
        this.cronyGroupSelfStauts = cronyGroupSelfStauts;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEqKeywords() {
        return eqKeywords;
    }

    public void setEqKeywords(String eqKeywords) {
        this.eqKeywords = eqKeywords;
    }

    public Integer getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }
}
