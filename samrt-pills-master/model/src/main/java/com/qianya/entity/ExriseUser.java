package com.qianya.entity;

import java.io.Serializable;

public class ExriseUser implements Serializable {
    private Integer exriseUserId;

    private Integer userId;

    private String exriseWxId;

    private String companyId;

    private String companyName;

    private String exriseWxName;

    private String wxRemark;

    private String exriseWxUrl;

    private Integer customerNum;

    private Integer groupNum;

    private String loginTime;

    private String authorizationTime;

    private Integer isDelete;

    private Integer loginStatus;

    private static final long serialVersionUID = 1L;

    public Integer getExriseUserId() {
        return exriseUserId;
    }

    public void setExriseUserId(Integer exriseUserId) {
        this.exriseUserId = exriseUserId;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getExriseWxName() {
        return exriseWxName;
    }

    public void setExriseWxName(String exriseWxName) {
        this.exriseWxName = exriseWxName == null ? null : exriseWxName.trim();
    }

    public String getWxRemark() {
        return wxRemark;
    }

    public void setWxRemark(String wxRemark) {
        this.wxRemark = wxRemark == null ? null : wxRemark.trim();
    }

    public String getExriseWxUrl() {
        return exriseWxUrl;
    }

    public void setExriseWxUrl(String exriseWxUrl) {
        this.exriseWxUrl = exriseWxUrl == null ? null : exriseWxUrl.trim();
    }

    public Integer getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(Integer customerNum) {
        this.customerNum = customerNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime == null ? null : loginTime.trim();
    }

    public String getAuthorizationTime() {
        return authorizationTime;
    }

    public void setAuthorizationTime(String authorizationTime) {
        this.authorizationTime = authorizationTime == null ? null : authorizationTime.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }
}