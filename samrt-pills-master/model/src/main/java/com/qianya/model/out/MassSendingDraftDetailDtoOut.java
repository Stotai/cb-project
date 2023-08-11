package com.qianya.model.out;

import com.qianya.model.in.MassSendingDetailDtoIn;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-05  17:17
 * @Description: 群发模板详情
 */
public class MassSendingDraftDetailDtoOut implements Serializable {

    @ApiModelProperty(value = "群发id", example = "1")
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

    @ApiModelProperty(value = "发送类型(0:单次;1:循环)", example = "0")
    private Integer massType;

    @ApiModelProperty(value = "截止时间", example = "10")
    private String massTimes;

    @ApiModelProperty(value = "是否截止(0:否;1:是)", example = "1")
    private Integer massInterval;

    @ApiModelProperty(value = "间隔发送时间(例: 间隔单位为月 ，参数则为每月发送时间)", example = "1")
    private String unitSendTime;

    @ApiModelProperty(value = "间隔单位(1:日;2:周;3:月)", example = "1")
    private Integer intervalUnit;


    @ApiModelProperty(value = "批次间隔秒数(以逗号分割)", example = "60,120,180")
    private String massBatchInterval;

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

    public Integer getMassCommonType() {
        return massCommonType;
    }

    public void setMassCommonType(Integer massCommonType) {
        this.massCommonType = massCommonType;
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

    public Integer getSaveType() {
        return saveType;
    }

    public void setSaveType(Integer saveType) {
        this.saveType = saveType;
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

    public String getUnitSendTime() {
        return unitSendTime;
    }

    public void setUnitSendTime(String unitSendTime) {
        this.unitSendTime = unitSendTime;
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

    public List<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    public List<String> getGroupWxId() {
        return groupWxId;
    }

    public void setGroupWxId(List<String> groupWxId) {
        this.groupWxId = groupWxId;
    }

    public List<MassSendingDetailDtoIn> getDetailDtoInList() {
        return detailDtoInList;
    }

    public void setDetailDtoInList(List<MassSendingDetailDtoIn> detailDtoInList) {
        this.detailDtoInList = detailDtoInList;
    }
}
