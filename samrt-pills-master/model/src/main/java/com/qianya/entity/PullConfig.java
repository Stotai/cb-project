package com.qianya.entity;

import java.io.Serializable;

public class PullConfig implements Serializable {
    private Integer pullConfigId;

    private String workTime;

    private Integer waitSeconds;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getPullConfigId() {
        return pullConfigId;
    }

    public void setPullConfigId(Integer pullConfigId) {
        this.pullConfigId = pullConfigId;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }

    public Integer getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(Integer waitSeconds) {
        this.waitSeconds = waitSeconds;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}