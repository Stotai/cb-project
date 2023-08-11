package com.qianya.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/***
 * @Description: 群发记录表 用于查询
 * @Author: Wangxin
 * @date 2023-07-03 17:59
 * @Param null:
 * @return: null
**/
@Document(collection = "mass_sending_record")
public class MassSendingRecordMoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long recordId;

    //群发id
    @Field("mass_id")
    private Integer massId;
    //群发id
    @Field("main_id")
    private Long mainId;

    //客户id
    @Field("customer_wx_id")
    private String customerWxId;
    //客户id
    @Field("work_type")
    private Integer workType;

    //状态(0:待发送;1:发送成功;2:发送失败)
    @Field("status")
    private Integer status;


    //发送时间
    @Field("send_time")
    private String sendTime;
    //完成时间
    @Field("complete_time")
    private String completeTime;

    //失败原因
    @Field("fail_msg")
    private String failMsg;


    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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
        this.sendTime = sendTime;
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

    public Integer getMassId() {
        return massId;
    }

    public void setMassId(Integer massId) {
        this.massId = massId;
    }

    public String getCustomerWxId() {
        return customerWxId;
    }

    public void setCustomerWxId(String customerWxId) {
        this.customerWxId = customerWxId;
    }

    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }
}