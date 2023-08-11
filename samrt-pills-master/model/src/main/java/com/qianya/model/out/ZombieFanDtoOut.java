package com.qianya.model.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "僵尸粉DTO")
public class ZombieFanDtoOut  implements Serializable {
    private static final long serialVersionUID = -4773196445709930412L;
    @ApiModelProperty(value = "粉丝主键id")
    private Integer fansId;

    @ApiModelProperty(value = "企业微信id")
    private String exriseUserId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "企业微信名称")
    private String exriseUserName;

    @ApiModelProperty(value = "性别(1:男;2女)")
    private Integer sex;

    @ApiModelProperty(value = "粉丝微信id")
    private String custWxId;

    @ApiModelProperty(value = "粉丝昵称")
    private String custNickName;

    @ApiModelProperty(value = "粉丝头像")
    private String custHeadUrl;

    @ApiModelProperty(value = "添加时间")
    private String addTime;

    @ApiModelProperty(value = "删除时间")
    private String deleteTime;

    @ApiModelProperty(value = "处理状态(0:未处理;1:已删除;2:已忽略;4:重新申请;5:无法确认)")
    private Integer status;

    @ApiModelProperty(value = "消息来源")
    private Integer source;


    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }

    public String getExriseUserId() {
        return exriseUserId;
    }

    public void setExriseUserId(String exriseUserId) {
        this.exriseUserId = exriseUserId;
    }

    public String getCustWxId() {
        return custWxId;
    }

    public void setCustWxId(String custWxId) {
        this.custWxId = custWxId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExriseUserName() {
        return exriseUserName;
    }

    public void setExriseUserName(String exriseUserName) {
        this.exriseUserName = exriseUserName;
    }



    public String getCustNickName() {
        return custNickName;
    }

    public void setCustNickName(String custNickName) {
        this.custNickName = custNickName;
    }

    public String getCustHeadUrl() {
        return custHeadUrl;
    }

    public void setCustHeadUrl(String custHeadUrl) {
        this.custHeadUrl = custHeadUrl;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
