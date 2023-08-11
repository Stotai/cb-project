package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-16  16:55
 * @Description: 发朋友圈入参
 */
public class CricleFriendsDtoIn  implements Serializable {

    private static final long serialVersionUID = -8784632764899216709L;
    @ApiModelProperty(value = "用户ID", required = true)
    private Integer userId;

    @ApiModelProperty(value = "企业微信ID，多个以逗号分隔", required = true)
    private String exriseWxIds;

    @ApiModelProperty(value = "任务名称", required = true)
    private String circleName;

    @ApiModelProperty(value = "发送时间", required = true)
    private String sendTime;

    @ApiModelProperty(value = "发送类型（1: 单次; 2: 循环）", required = true)
    private Integer sendType;

    @ApiModelProperty(value = "发送次数", required = true)
    private Integer sendNum;

    @ApiModelProperty(value = "间隔时间", required = true)
    private Integer unitNum;

    @ApiModelProperty(value = "间隔单位（1: 时; 2: 天; 3: 周; 4: 月）", required = true)
    private Integer unit;

    @ApiModelProperty(value = "保存类型（0: 模板; 1: 正式朋友圈内容）", required = true)
    private Integer cricleType;

    @ApiModelProperty(value = "内容", required = true)
    List<CricleFriendsDetailDtoIn> detailDtoInList;

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

    public Integer getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Integer unitNum) {
        this.unitNum = unitNum;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getCricleType() {
        return cricleType;
    }

    public void setCricleType(Integer cricleType) {
        this.cricleType = cricleType;
    }

    public List<CricleFriendsDetailDtoIn> getDetailDtoInList() {
        return detailDtoInList;
    }

    public void setDetailDtoInList(List<CricleFriendsDetailDtoIn> detailDtoInList) {
        this.detailDtoInList = detailDtoInList;
    }
}
