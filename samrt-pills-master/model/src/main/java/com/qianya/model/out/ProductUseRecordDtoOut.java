package com.qianya.model.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

// 定义卡密使用记录类
public  class ProductUseRecordDtoOut implements Serializable {
     private static final long serialVersionUID = 367037090619295100L;

    @ApiModelProperty(value = "记录id")
    private Integer recordId;
    @ApiModelProperty(value = "卡密")
    private String carmi;
    @ApiModelProperty(value = "使用账号")
    private String userPhone;
    @ApiModelProperty(value = "微信ID")
    private String exriseUserId;
    @ApiModelProperty(value = "使用时间")
    private String useTime;

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
        this.carmi = carmi;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getExriseUserId() {
        return exriseUserId;
    }

    public void setExriseUserId(String exriseUserId) {
        this.exriseUserId = exriseUserId;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }
}