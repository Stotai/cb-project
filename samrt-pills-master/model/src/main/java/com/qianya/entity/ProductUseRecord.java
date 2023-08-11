package com.qianya.entity;

import java.io.Serializable;

public class ProductUseRecord implements Serializable {
    private Integer recordId;

    private String carmi;

    private Integer status;

    private String payUserPhone;

    private Integer payUserId;

    private String userPhone;

    private Integer userId;

    private String exriseWxName;

    private String exriseUserId;

    private String productName;

    private Integer productType;

    private Integer productId;

    private String createTime;

    private String useTime;

    private static final long serialVersionUID = 1L;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getCarmi() {
        return carmi;
    }

    public void setCarmi(String carmi) {
        this.carmi = carmi == null ? null : carmi.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPayUserPhone() {
        return payUserPhone;
    }

    public void setPayUserPhone(String payUserPhone) {
        this.payUserPhone = payUserPhone == null ? null : payUserPhone.trim();
    }

    public Integer getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(Integer payUserId) {
        this.payUserId = payUserId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExriseWxName() {
        return exriseWxName;
    }

    public void setExriseWxName(String exriseWxName) {
        this.exriseWxName = exriseWxName == null ? null : exriseWxName.trim();
    }

    public String getExriseUserId() {
        return exriseUserId;
    }

    public void setExriseUserId(String exriseUserId) {
        this.exriseUserId = exriseUserId == null ? null : exriseUserId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime == null ? null : useTime.trim();
    }
}