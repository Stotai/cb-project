package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-16  16:57
 * @Description: 朋友圈入参明细
 */
public class CricleFriendsDetailDtoIn implements Serializable {


    private static final long serialVersionUID = -5421248105072751207L;
    @ApiModelProperty(value = "详情类型（1: 发布内容; 2: 评论内容）", required = true)
    private Integer detailType;

    @ApiModelProperty(value = "内容类型（1: 文本; 2: 图片; 3: 视频; 4: 卡片）", required = true)
    private Integer itemType;

    @ApiModelProperty(value = "朋友圈主任务ID", required = true)
    private Integer cricleId;

    @ApiModelProperty(value = "消息内容", required = true)
    private String itemContent;

    @ApiModelProperty(value = "好友验证几秒后执行", required = true)
    private Integer waitSeconds;

    @ApiModelProperty(value = "文件地址")
    private String fileUrl;

    @ApiModelProperty(value = "卡片标题")
    private String cardTitle;

    @ApiModelProperty(value = "卡片链接")
    private String cardUrl;

    @ApiModelProperty(value = "卡片描述")
    private String cardContent;

    @ApiModelProperty(value = "卡片图片地址")
    private String cardImgUrl;

    @ApiModelProperty(value = "序号")
    private Integer sort;

    public Integer getDetailType() {
        return detailType;
    }

    public void setDetailType(Integer detailType) {
        this.detailType = detailType;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getCricleId() {
        return cricleId;
    }

    public void setCricleId(Integer cricleId) {
        this.cricleId = cricleId;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public Integer getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(Integer waitSeconds) {
        this.waitSeconds = waitSeconds;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl;
    }

    public String getCardContent() {
        return cardContent;
    }

    public void setCardContent(String cardContent) {
        this.cardContent = cardContent;
    }

    public String getCardImgUrl() {
        return cardImgUrl;
    }

    public void setCardImgUrl(String cardImgUrl) {
        this.cardImgUrl = cardImgUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
