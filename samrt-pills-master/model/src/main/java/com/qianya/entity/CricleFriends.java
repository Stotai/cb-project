package com.qianya.entity;

import java.io.Serializable;

public class CricleFriends implements Serializable {
    private Integer circleId;

    private Integer userId;

    private String exriseWxIds;

    private String circleName;

    private String sendTime;

    private Integer sendType;

    private Integer sendNum;

    private Integer unitNum;

    private Integer unit;

    private Integer status;

    private Integer executeTimes;

    private String lastExecustTime;

    private String createTime;

    private String content;

    private Integer cricleType;

    private static final long serialVersionUID = 1L;

    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExriseWxIds() {
        return exriseWxIds;
    }

    public void setExriseWxIds(String exriseWxIds) {
        this.exriseWxIds = exriseWxIds == null ? null : exriseWxIds.trim();
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName == null ? null : circleName.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    public Integer getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Integer unitNum) {
        this.unitNum = unitNum;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExecuteTimes() {
        return executeTimes;
    }

    public void setExecuteTimes(Integer executeTimes) {
        this.executeTimes = executeTimes;
    }

    public String getLastExecustTime() {
        return lastExecustTime;
    }

    public void setLastExecustTime(String lastExecustTime) {
        this.lastExecustTime = lastExecustTime == null ? null : lastExecustTime.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCricleType() {
        return cricleType;
    }

    public void setCricleType(Integer cricleType) {
        this.cricleType = cricleType;
    }
}