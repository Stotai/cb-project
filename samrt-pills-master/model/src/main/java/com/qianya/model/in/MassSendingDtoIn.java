package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-06  17:22
 * @Description: 群发主体信息
 */

public class MassSendingDtoIn implements Serializable {

    private static final long serialVersionUID = 8412002877376271673L;
    @ApiModelProperty(value = "群发id修改时传", example = "1")
    private Integer massId;

    @ApiModelProperty(value = "群发名称", example = "Test Mass Sending")
    private String massName;


    @ApiModelProperty(value = "群发类型(1:急速群发;2:高级群发)", required = true)
    private Integer massCommonType;

    @ApiModelProperty(value = "发送类型(1:好友群发;2:群聊群发)", example = "1")
    private Integer sendType;


    @ApiModelProperty(value = "状态(0:执行中;1:暂停)", example = "0")
    private Integer status;

    @ApiModelProperty(value = "保存类型(0:模板;1:群发)", example = "0")
    private Integer saveType;

    @ApiModelProperty(value = "发送类型(0:单次;1:循环;2:立刻)", example = "0")
    private Integer massType;

    @ApiModelProperty(value = "截止时间", example = "10")
    private String massTimes;

    @ApiModelProperty(value = "发送时间", example = "10")
    private String massTime;

    @ApiModelProperty(value = "是否截止(0:否;1:是)", example = "1")
    private Integer massInterval;

    @ApiModelProperty(value = "间隔发送时间(例: 间隔单位为月 ，参数则为每月发送时间)", example = "1")
    private String unitSendTime;

    @ApiModelProperty(value = "间隔单位(1:日;2:周;3:月)", example = "1")
    private Integer intervalUnit;



    @ApiModelProperty(value = "批次间隔秒数(以逗号分割)", example = "60,120,180")
    private String massBatchInterval;

    @ApiModelProperty(value = "客户对象间隔秒数(以逗号分割)", example = "60,120,180")
    private String customerInterval;

    @ApiModelProperty(value = "休眠时间段(以逗号分割)", example = "60,120,180")
    private String stopTime;

    @ApiModelProperty(value = "休眠时间段开关(0:开；1；关)", example = "0")
    private Integer stopTimeStatus;


    @ApiModelProperty(value = "客户微信id（以逗号拼接）不传是所有", example = "734545")
    private List<String> customerIds;

    @ApiModelProperty(value = "群官方微信id（以逗号拼接）不传是所有", example = "734545")
    private List<String> groupWxId;

    @ApiModelProperty(value = "消息信息", example = "60,120,180")
    private List<MassSendingDetailDtoIn> detailDtoInList;

    public Integer getMassId() {
        return massId;
    }

    public void setMassId(Integer massId) {
        this.massId = massId;
    }

    public String getMassName() {
        return massName;
    }

    public void setMassName(String massName) {
        this.massName = massName;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getMassType() {
        return massType;
    }

    public void setMassType(Integer massType) {
        this.massType = massType;
    }

    public String getMassTimes() {
        return massTimes;
    }

    public void setMassTimes(String massTimes) {
        this.massTimes = massTimes;
    }

    public Integer getMassInterval() {
        return massInterval;
    }

    public void setMassInterval(Integer massInterval) {
        this.massInterval = massInterval;
    }

    public Integer getIntervalUnit() {
        return intervalUnit;
    }

    public void setIntervalUnit(Integer intervalUnit) {
        this.intervalUnit = intervalUnit;
    }



    public String getMassBatchInterval() {
        return massBatchInterval;
    }

    public void setMassBatchInterval(String massBatchInterval) {
        this.massBatchInterval = massBatchInterval;
    }

    public List<MassSendingDetailDtoIn> getDetailDtoInList() {
        return detailDtoInList;
    }

    public void setDetailDtoInList(List<MassSendingDetailDtoIn> detailDtoInList) {
        this.detailDtoInList = detailDtoInList;
    }

    public List<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    public Integer getMassCommonType() {
        return massCommonType;
    }

    public void setMassCommonType(Integer massCommonType) {
        this.massCommonType = massCommonType;
    }


    public List<String> getGroupWxId() {
        return groupWxId;
    }

    public void setGroupWxId(List<String> groupWxId) {
        this.groupWxId = groupWxId;
    }

    public String getUnitSendTime() {
        return unitSendTime;
    }

    public void setUnitSendTime(String unitSendTime) {
        this.unitSendTime = unitSendTime;
    }

    public Integer getSaveType() {
        return saveType;
    }

    public void setSaveType(Integer saveType) {
        this.saveType = saveType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCustomerInterval() {
        return customerInterval;
    }

    public void setCustomerInterval(String customerInterval) {
        this.customerInterval = customerInterval;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getStopTimeStatus() {
        return stopTimeStatus;
    }

    public void setStopTimeStatus(Integer stopTimeStatus) {
        this.stopTimeStatus = stopTimeStatus;
    }

    public String getMassTime() {
        return massTime;
    }

    public void setMassTime(String massTime) {
        this.massTime = massTime;
    }
}
