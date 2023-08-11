package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-24  17:55
 * @Description: 接受新客户配置入参
 */
public class UserConfigDtoIn implements Serializable {
    private static final long serialVersionUID = -2690357918888117551L;


    //接受新客户配置/修改时传
    @ApiModelProperty(value = "接受新客户配置id/修改时传")
    private Integer userConfigId;


    @ApiModelProperty(value = "私人微信自动添加好友状态(0:关闭;1:正常)")
    private Integer autoStatus;

    @ApiModelProperty(value = "企业微信自动添加好友状态(0:关闭;1:正常)")
    private Integer exriseAutoStatus;

    @ApiModelProperty(value = "工作开始时间")
    private Integer workStartTime;

    @ApiModelProperty(value = "工作结束时间")
    private Integer workEndTime;

    @ApiModelProperty(value = "每日好友上限")
    private Integer maxNum;

    @ApiModelProperty(value = "好友通过等待区间(以逗号拼接,秒为单位)")
    private String waitSeconds;

    @ApiModelProperty(value = "发送消息等待区间(以逗号拼接,秒为单位)")
    private String msgWaitSeconds;

    @ApiModelProperty(value = "验证信息关键字包含直接通过(以|分割)")
    private String verifyKeywords;

    @ApiModelProperty(value = "验证信息关键字包含不通过(以|分割)")
    private String verifyNoKeywords;

    @ApiModelProperty(value = "昵称信息关键字包含不通过(以|分割)")
    private String nickNameNoKeywords;


    public Integer getAutoStatus() {
        return autoStatus;
    }

    public void setAutoStatus(Integer autoStatus) {
        this.autoStatus = autoStatus;
    }

    public Integer getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(Integer workStartTime) {
        this.workStartTime = workStartTime;
    }

    public Integer getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Integer workEndTime) {
        this.workEndTime = workEndTime;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public String getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(String waitSeconds) {
        this.waitSeconds = waitSeconds;
    }

    public String getMsgWaitSeconds() {
        return msgWaitSeconds;
    }

    public void setMsgWaitSeconds(String msgWaitSeconds) {
        this.msgWaitSeconds = msgWaitSeconds;
    }

    public String getVerifyKeywords() {
        return verifyKeywords;
    }

    public void setVerifyKeywords(String verifyKeywords) {
        this.verifyKeywords = verifyKeywords;
    }

    public String getVerifyNoKeywords() {
        return verifyNoKeywords;
    }

    public void setVerifyNoKeywords(String verifyNoKeywords) {
        this.verifyNoKeywords = verifyNoKeywords;
    }

    public String getNickNameNoKeywords() {
        return nickNameNoKeywords;
    }

    public void setNickNameNoKeywords(String nickNameNoKeywords) {
        this.nickNameNoKeywords = nickNameNoKeywords;
    }

    public Integer getUserConfigId() {
        return userConfigId;
    }

    public void setUserConfigId(Integer userConfigId) {
        this.userConfigId = userConfigId;
    }

    public Integer getExriseAutoStatus() {
        return exriseAutoStatus;
    }

    public void setExriseAutoStatus(Integer exriseAutoStatus) {
        this.exriseAutoStatus = exriseAutoStatus;
    }
}
