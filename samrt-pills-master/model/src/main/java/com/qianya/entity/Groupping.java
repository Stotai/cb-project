package com.qianya.entity;

import java.io.Serializable;

public class Groupping implements Serializable {
    private Integer groupingId;

    private String name;

    private Integer userId;

    private String exriseUserId;

    private Integer isDel;

    private String createTime;

    private static final long serialVersionUID = 1L;

    public Integer getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(Integer groupingId) {
        this.groupingId = groupingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExriseUserId() {
        return exriseUserId;
    }

    public void setExriseUserId(String exriseUserId) {
        this.exriseUserId = exriseUserId == null ? null : exriseUserId.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}