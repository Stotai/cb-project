package com.qianya.model.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-24  17:49
 * @Description: 用户配置
 */
@ApiModel(description = "用户配置DTO")
public class UserConfigDtoOut implements Serializable {

    @ApiModelProperty(value = "配置ID")
    private int configId;



    @ApiModelProperty(value = "自动添加好友状态(0:关闭;1:正常)")
    private int autoStatus;

    @ApiModelProperty(value = "工作开始时间")
    private int workStartTime;

    @ApiModelProperty(value = "工作结束时间")
    private int workEndTime;

    @ApiModelProperty(value = "每日好友上限")
    private int maxNum;

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

    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }



    public int getAutoStatus() {
        return autoStatus;
    }

    public void setAutoStatus(int autoStatus) {
        this.autoStatus = autoStatus;
    }

    public int getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(int workStartTime) {
        this.workStartTime = workStartTime;
    }

    public int getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(int workEndTime) {
        this.workEndTime = workEndTime;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
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
}
