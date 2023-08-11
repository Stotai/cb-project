package com.qianya.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer customerId;

    private Integer userId;

    private String epriseWxId;

    private String epriseWxName;

    private String custWxId;

    private String custWxName;

    private Integer sex;

    private String custWxHeadUrl;

    private String verifyContent;

    private Integer addType;

    private Integer isDel;

    private Integer status;

    private String createTime;

    private Integer zombieFlag;

    private String zombieDeleteTime;

    private Integer zombieStatus;

    private Integer source;

    private Integer accountType;

    private static final long serialVersionUID = 1L;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEpriseWxId() {
        return epriseWxId;
    }

    public void setEpriseWxId(String epriseWxId) {
        this.epriseWxId = epriseWxId == null ? null : epriseWxId.trim();
    }

    public String getEpriseWxName() {
        return epriseWxName;
    }

    public void setEpriseWxName(String epriseWxName) {
        this.epriseWxName = epriseWxName == null ? null : epriseWxName.trim();
    }

    public String getCustWxId() {
        return custWxId;
    }

    public void setCustWxId(String custWxId) {
        this.custWxId = custWxId == null ? null : custWxId.trim();
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

    public String getVerifyContent() {
        return verifyContent;
    }

    public void setVerifyContent(String verifyContent) {
        this.verifyContent = verifyContent == null ? null : verifyContent.trim();
    }

    public Integer getAddType() {
        return addType;
    }

    public void setAddType(Integer addType) {
        this.addType = addType;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
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

    public Integer getZombieFlag() {
        return zombieFlag;
    }

    public void setZombieFlag(Integer zombieFlag) {
        this.zombieFlag = zombieFlag;
    }

    public String getZombieDeleteTime() {
        return zombieDeleteTime;
    }

    public void setZombieDeleteTime(String zombieDeleteTime) {
        this.zombieDeleteTime = zombieDeleteTime == null ? null : zombieDeleteTime.trim();
    }

    public Integer getZombieStatus() {
        return zombieStatus;
    }

    public void setZombieStatus(Integer zombieStatus) {
        this.zombieStatus = zombieStatus;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
}