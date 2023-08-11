package com.qianya.entity;

import java.io.Serializable;

public class GroupCust implements Serializable {
    private Integer customerId;

    private Integer groupId;

    private String groupWxId;

    private String custWxId;

    private Integer userId;

    private String custWxName;

    private Integer sex;

    private String custWxHeadUrl;

    private String joinTime;

    private Integer isAdmin;

    private Integer invitationsTimes;

    private String invitaUserId;

    private static final long serialVersionUID = 1L;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

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

    public String getCustWxId() {
        return custWxId;
    }

    public void setCustWxId(String custWxId) {
        this.custWxId = custWxId == null ? null : custWxId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCustWxName() {
        return custWxName;
    }

    public void setCustWxName(String custWxName) {
        this.custWxName = custWxName == null ? null : custWxName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCustWxHeadUrl() {
        return custWxHeadUrl;
    }

    public void setCustWxHeadUrl(String custWxHeadUrl) {
        this.custWxHeadUrl = custWxHeadUrl == null ? null : custWxHeadUrl.trim();
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime == null ? null : joinTime.trim();
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getInvitationsTimes() {
        return invitationsTimes;
    }

    public void setInvitationsTimes(Integer invitationsTimes) {
        this.invitationsTimes = invitationsTimes;
    }

    public String getInvitaUserId() {
        return invitaUserId;
    }

    public void setInvitaUserId(String invitaUserId) {
        this.invitaUserId = invitaUserId == null ? null : invitaUserId.trim();
    }
}