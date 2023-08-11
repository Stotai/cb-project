package com.qianya.entity;

import java.io.Serializable;

public class CricleDetail implements Serializable {
    private Integer cricleDetailId;

    private Integer detailType;

    private Integer itemType;

    private Integer cricleId;

    private String itemContent;

    private Integer sort;

    private Integer waitSeconds;

    private String fileUrl;

    private String cardTitle;

    private String cardUrl;

    private String cardContent;

    private String cardImgUrl;

    private static final long serialVersionUID = 1L;

    public Integer getCricleDetailId() {
        return cricleDetailId;
    }

    public void setCricleDetailId(Integer cricleDetailId) {
        this.cricleDetailId = cricleDetailId;
    }

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
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle == null ? null : cardTitle.trim();
    }

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl == null ? null : cardUrl.trim();
    }

    public String getCardContent() {
        return cardContent;
    }

    public void setCardContent(String cardContent) {
        this.cardContent = cardContent == null ? null : cardContent.trim();
    }

    public String getCardImgUrl() {
        return cardImgUrl;
    }

    public void setCardImgUrl(String cardImgUrl) {
        this.cardImgUrl = cardImgUrl == null ? null : cardImgUrl.trim();
    }
}