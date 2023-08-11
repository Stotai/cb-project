package com.qianya.entity;

import java.io.Serializable;

public class PullCustRelation implements Serializable {
    private Integer pullCustId;

    private String custWxId;

    private Integer pullId;

    private String failMsg;

    private Integer status;

    private String sendTime;

    private static final long serialVersionUID = 1L;

    public Integer getPullCustId() {
        return pullCustId;
    }

    public void setPullCustId(Integer pullCustId) {
        this.pullCustId = pullCustId;
    }

    public String getCustWxId() {
        return custWxId;
    }

    public void setCustWxId(String custWxId) {
        this.custWxId = custWxId == null ? null : custWxId.trim();
    }

    public Integer getPullId() {
        return pullId;
    }

    public void setPullId(Integer pullId) {
        this.pullId = pullId;
    }

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg == null ? null : failMsg.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }
}