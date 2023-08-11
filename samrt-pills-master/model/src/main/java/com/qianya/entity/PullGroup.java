package com.qianya.entity;

import java.io.Serializable;

public class PullGroup implements Serializable {
    private Integer pullId;

    private String pullName;

    private Integer userId;

    private String exriseWxId;

    private String exriseWxName;

    private Integer maxNum;

    private Integer dayMaxNum;

    private Integer sendCount;

    private Integer completeCount;

    private Integer status;

    private String createTime;

    private String completeTime;

    private static final long serialVersionUID = 1L;

    public Integer getPullId() {
        return pullId;
    }

    public void setPullId(Integer pullId) {
        this.pullId = pullId;
    }

    public String getPullName() {
        return pullName;
    }

    public void setPullName(String pullName) {
        this.pullName = pullName == null ? null : pullName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExriseWxId() {
        return exriseWxId;
    }

    public void setExriseWxId(String exriseWxId) {
        this.exriseWxId = exriseWxId == null ? null : exriseWxId.trim();
    }

    public String getExriseWxName() {
        return exriseWxName;
    }

    public void setExriseWxName(String exriseWxName) {
        this.exriseWxName = exriseWxName == null ? null : exriseWxName.trim();
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getDayMaxNum() {
        return dayMaxNum;
    }

    public void setDayMaxNum(Integer dayMaxNum) {
        this.dayMaxNum = dayMaxNum;
    }

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    public Integer getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(Integer completeCount) {
        this.completeCount = completeCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime == null ? null : completeTime.trim();
    }
}