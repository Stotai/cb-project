package com.qianya.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;

@Document(collection = "netty_channel")
public class NettyChannelMoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * <pre>
     * 记录id
     * 表字段 : xp_house_work_record.record_id
     * </pre>
     */
    @Id
    private Long recordId;

    @Field("user_id")
    private Integer userId;

    @Field("channel_id")
    private String channelId;

    @Field("create_time")
    private String createTime;

    @Field("update_time")
    private String updateTime;
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}