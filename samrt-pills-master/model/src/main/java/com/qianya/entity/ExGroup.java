package com.qianya.entity;

import java.io.Serializable;

public class ExGroup implements Serializable {
    private Integer groupId;

    private String groupWxId;

    private Integer userId;

    private String groupName;

    private String groupImg;

    private String exriseUserId;

    private Integer groupType;

    private Integer custNum;

    private Integer groupingId;

    private String createUserId;

    private String createTime;

    private String groupQrCode;

    private static final long serialVersionUID = 1L;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupWxId() {
        return groupWxId;
    }

    public void setGroupWxId(String groupWxId) {
        this.groupWxId = groupWxId == null ? null : groupWxId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupImg() {
        return groupImg;
    }

    public void setGroupImg(String groupImg) {
        this.groupImg = groupImg == null ? null : groupImg.trim();
    }

    public String getExriseUserId() {
        return exriseUserId;
    }

    public void setExriseUserId(String exriseUserId) {
        this.exriseUserId = exriseUserId == null ? null : exriseUserId.trim();
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getCustNum() {
        return custNum;
    }

    public void setCustNum(Integer custNum) {
        this.custNum = custNum;
    }

    public Integer getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(Integer groupingId) {
        this.groupingId = groupingId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getGroupQrCode() {
        return groupQrCode;
    }

    public void setGroupQrCode(String groupQrCode) {
        this.groupQrCode = groupQrCode == null ? null : groupQrCode.trim();
    }
}