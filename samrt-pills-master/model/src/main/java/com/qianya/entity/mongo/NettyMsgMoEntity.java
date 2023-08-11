package com.qianya.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "netty_msg")
public class NettyMsgMoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * <pre>
     * 记录id
     * </pre>
     */
    @Id
    private Long recordId;
    //用户id
    @Field("user_id")
    private Integer userId;
    //消息类型枚举
    @Field("msg_type")
    private Integer msgType;
    //发送内容
    @Field("content")
    private String content;
    //是否处理消息0否 1是
    @Field("is_deal")
    private Integer isDeal;
    //创建时间
    @Field("create_time")
    private String createTime;
    //处理时间
    @Field("deal_time")
    private String dealTime;
    //处理结果0未处理 1成功 2账号已离线 3.在线发送失败
    @Field("deal_state")
    private Integer dealState;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(Integer isDeal) {
        this.isDeal = isDeal;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getDealState() {
        return dealState;
    }

    public void setDealState(Integer dealState) {
        this.dealState = dealState;
    }
}