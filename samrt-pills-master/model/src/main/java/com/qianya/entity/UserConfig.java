package com.qianya.entity;

import java.io.Serializable;

public class UserConfig implements Serializable {
    private Integer configId;

    private Integer userId;

    private Integer autoStatus;

    private Integer workStartTime;

    private Integer workEndTime;

    private Integer maxNum;

    private String waitSeconds;

    private String msgWaitSeconds;

    private String verifyKeywords;

    private String verifyNoKeywords;

    private String nickNameNoKeywords;

    private Integer exriseAutoStatus;

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

    public Integer getAutoStatus() {
        return autoStatus;
    }

    public void setAutoStatus(Integer autoStatus) {
        this.autoStatus = autoStatus;
    }

    public Integer getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(Integer workStartTime) {
        this.workStartTime = workStartTime;
    }

    public Integer getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Integer workEndTime) {
        this.workEndTime = workEndTime;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public String getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(String waitSeconds) {
        this.waitSeconds = waitSeconds == null ? null : waitSeconds.trim();
    }

    public String getMsgWaitSeconds() {
        return msgWaitSeconds;
    }

    public void setMsgWaitSeconds(String msgWaitSeconds) {
        this.msgWaitSeconds = msgWaitSeconds == null ? null : msgWaitSeconds.trim();
    }

    public String getVerifyKeywords() {
        return verifyKeywords;
    }

    public void setVerifyKeywords(String verifyKeywords) {
        this.verifyKeywords = verifyKeywords == null ? null : verifyKeywords.trim();
    }

    public String getVerifyNoKeywords() {
        return verifyNoKeywords;
    }

    public void setVerifyNoKeywords(String verifyNoKeywords) {
        this.verifyNoKeywords = verifyNoKeywords == null ? null : verifyNoKeywords.trim();
    }

    public String getNickNameNoKeywords() {
        return nickNameNoKeywords;
    }

    public void setNickNameNoKeywords(String nickNameNoKeywords) {
        this.nickNameNoKeywords = nickNameNoKeywords == null ? null : nickNameNoKeywords.trim();
    }

    public Integer getExriseAutoStatus() {
        return exriseAutoStatus;
    }

    public void setExriseAutoStatus(Integer exriseAutoStatus) {
        this.exriseAutoStatus = exriseAutoStatus;
    }
}