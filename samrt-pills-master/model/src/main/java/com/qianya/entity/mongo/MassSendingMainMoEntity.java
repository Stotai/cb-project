package com.qianya.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "mass_sending_main")
public class MassSendingMainMoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long recordId;

    //群发id
    @Field("mass_id")
    private Integer massId;
    //群发类型 1 极速群发 2.高级群发
    @Field("mass_type")
    private Integer massType;

    //群发名称
    @Field("mass_name")
    private String massName;

    //发送时间
    @Field("send_time")
    private String sendTime;


    //状态(0:待发送;1:发送成功;2:发送失败)
    @Field("status")
    private Integer status;


    //用户id
    @Field("user_id")
    private Integer userId;

    //企业微信id
    @Field("exrise_wx_id")
    private String exriseWxId;

    //完成时间
    @Field("complete_time")
    private String completeTime;

    //失败原因
    @Field("fail_msg")
    private String failMsg;

    //描述
    @Field("detail")
    private String detail;

    //人数统计
    @Field("send_count")
    private Integer sendCount;
    //完成人数统计
    @Field("complete_count")
    private Integer completeCount;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Integer getMassId() {
        return massId;
    }

    public void setMassId(Integer massId) {
        this.massId = massId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    public Integer getMassType() {
        return massType;
    }

    public void setMassType(Integer massType) {
        this.massType = massType;
    }

    public Integer getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(Integer completeCount) {
        this.completeCount = completeCount;
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
        this.exriseWxId = exriseWxId;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public String getFailMsg() {
        return failMsg;
    }

    public void setFailMsg(String failMsg) {
        this.failMsg = failMsg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMassName() {
        return massName;
    }

    public void setMassName(String massName) {
        this.massName = massName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}