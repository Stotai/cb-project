package com.qianya.entity;

import java.io.Serializable;

public class MassSending implements Serializable {
    private Integer massId;

    private String massName;

    private Integer userId;

    private String exexriseUserId;

    private Integer massCommonType;

    private Integer sendType;

    private String unitSendTime;

    private Integer status;

    private String massContent;

    private String massTime;

    private Integer massType;

    private String massTimes;

    private Integer massInterval;

    private Integer intervalUnit;

    private String customerInterval;

    private Integer stopTimeStatus;

    private String stopTime;

    private String massBatchInterval;

    private Integer isDel;

    private Integer massNum;

    private Integer executeTimes;

    private Integer saveType;

    private String createTime;

    private static final long serialVersionUID = 1L;

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
        this.massName = massName == null ? null : massName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExexriseUserId() {
        return exexriseUserId;
    }

    public void setExexriseUserId(String exexriseUserId) {
        this.exexriseUserId = exexriseUserId == null ? null : exexriseUserId.trim();
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

    public String getUnitSendTime() {
        return unitSendTime;
    }

    public void setUnitSendTime(String unitSendTime) {
        this.unitSendTime = unitSendTime == null ? null : unitSendTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMassContent() {
        return massContent;
    }

    public void setMassContent(String massContent) {
        this.massContent = massContent == null ? null : massContent.trim();
    }

    public String getMassTime() {
        return massTime;
    }

    public void setMassTime(String massTime) {
        this.massTime = massTime == null ? null : massTime.trim();
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
        this.massTimes = massTimes == null ? null : massTimes.trim();
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

    public String getCustomerInterval() {
        return customerInterval;
    }

    public void setCustomerInterval(String customerInterval) {
        this.customerInterval = customerInterval == null ? null : customerInterval.trim();
    }

    public Integer getStopTimeStatus() {
        return stopTimeStatus;
    }

    public void setStopTimeStatus(Integer stopTimeStatus) {
        this.stopTimeStatus = stopTimeStatus;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime == null ? null : stopTime.trim();
    }

    public String getMassBatchInterval() {
        return massBatchInterval;
    }

    public void setMassBatchInterval(String massBatchInterval) {
        this.massBatchInterval = massBatchInterval == null ? null : massBatchInterval.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getMassNum() {
        return massNum;
    }

    public void setMassNum(Integer massNum) {
        this.massNum = massNum;
    }

    public Integer getExecuteTimes() {
        return executeTimes;
    }

    public void setExecuteTimes(Integer executeTimes) {
        this.executeTimes = executeTimes;
    }

    public Integer getSaveType() {
        return saveType;
    }

    public void setSaveType(Integer saveType) {
        this.saveType = saveType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}