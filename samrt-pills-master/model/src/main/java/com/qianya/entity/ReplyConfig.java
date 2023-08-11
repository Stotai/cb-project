package com.qianya.entity;

import java.io.Serializable;

public class ReplyConfig implements Serializable {
    private Integer configId;

    private Integer userId;

    private Integer exriseUserType;

    private String exriseUserIds;

    private Integer cronyStauts;

    private Integer groupStatus;

    private Integer replyFrequency;

    private Integer keywordsStatus;

    private String eqKeywords;

    private String keywords;

    private String triggerType;

    private Integer isDel;

    private Integer sort;

    private String createTime;

    private Integer cronyGroupSelfStauts;

    private Integer replyType;

    private String replyContent;

    private Integer replyStatus;

    private static final long serialVersionUID = 1L;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExriseUserType() {
        return exriseUserType;
    }

    public void setExriseUserType(Integer exriseUserType) {
        this.exriseUserType = exriseUserType;
    }

    public String getExriseUserIds() {
        return exriseUserIds;
    }

    public void setExriseUserIds(String exriseUserIds) {
        this.exriseUserIds = exriseUserIds == null ? null : exriseUserIds.trim();
    }

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

    public String getEqKeywords() {
        return eqKeywords;
    }

    public void setEqKeywords(String eqKeywords) {
        this.eqKeywords = eqKeywords == null ? null : eqKeywords.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType == null ? null : triggerType.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getCronyGroupSelfStauts() {
        return cronyGroupSelfStauts;
    }

    public void setCronyGroupSelfStauts(Integer cronyGroupSelfStauts) {
        this.cronyGroupSelfStauts = cronyGroupSelfStauts;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Integer getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }
}