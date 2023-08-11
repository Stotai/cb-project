package com.qianya.model.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "朋友圈信息")
public class CircleFriendsDtoOut implements Serializable {

    private static final long serialVersionUID = 3828221956927621869L;
    @ApiModelProperty(value = "主键id")
    private Integer circleId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "企业微信id")
    private String exriseWxIds;

    @ApiModelProperty(value = "任务名称")
    private String circleName;

    @ApiModelProperty(value = "发送时间")
    private String sendTime;

    @ApiModelProperty(value = "发送类型(1:单次;2:循环）")
    private Integer sendType;

    @ApiModelProperty(value = "发送次数")
    private Integer sendNum;



    @ApiModelProperty(value = "任务内容")
    private String contentType;

    @ApiModelProperty(value = "状态(0:待执行;1:执行中;2:执行完成)")
    private Integer status;

    @ApiModelProperty(value = "执行次数")
    private Integer executeTimes;

    @ApiModelProperty(value = "最后执行时间")
    private String lastExecuteTime;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "内容")
    private String content;


    public Integer getCircleId() {
        return circleId;
    }

    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExriseWxIds() {
        return exriseWxIds;
    }

    public void setExriseWxIds(String exriseWxIds) {
        this.exriseWxIds = exriseWxIds;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getExecuteTimes() {
        return executeTimes;
    }

    public void setExecuteTimes(Integer executeTimes) {
        this.executeTimes = executeTimes;
    }

    public String getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(String lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}