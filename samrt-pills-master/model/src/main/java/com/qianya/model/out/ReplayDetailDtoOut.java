package com.qianya.model.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ReplayDetailDtoOut  implements Serializable {


    private static final long serialVersionUID = 6565195341108659495L;
    @ApiModelProperty(value = "配置项ID")
    private Integer itemId;

    @ApiModelProperty(value = "方案主键ID")
    private Integer schemeId;

    @ApiModelProperty(value = "消息类型(1:文本;2:图片;3:动图;4:视频;5:卡片消息;6:小程序;7:视频号;8:邀请入群;9:催入群;10:退群消息)", required = true)
    private Integer messageType;

    @ApiModelProperty(value = "消息内容")
    private String itemContent;

    @ApiModelProperty(value = "好友验证几秒后执行")
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

    @ApiModelProperty(value = "小程序username")
    private String userName;

    @ApiModelProperty(value = "小程序appid")
    private String appId;

    @ApiModelProperty(value = "小程序appName")
    private String appName;

    @ApiModelProperty(value = "小程序title")
    private String title;

    @ApiModelProperty(value = "小程序pagepath")
    private String pagePath;

    @ApiModelProperty(value = "小程序file_id")
    private String fileId;

    @ApiModelProperty(value = "小程序aes_key")
    private String aesKey;

    @ApiModelProperty(value = "小程序md5")
    private String md5;

    @ApiModelProperty(value = "小程序size")
    private String size;

    @ApiModelProperty(value = "视频号nickName")
    private String nickName;

    @ApiModelProperty(value = "视频号desc")
    private String videoDesc;

    @ApiModelProperty(value = "视频号avatar")
    private String avatar;

    @ApiModelProperty(value = "视频号cover_url")
    private String coverUrl;

    @ApiModelProperty(value = "视频号feed_type")
    private String feedType;

    @ApiModelProperty(value = "视频号thumb_url")
    private String thumbUrl;

    @ApiModelProperty(value = "视频号url")
    private String url;

    @ApiModelProperty(value = "视频号extras")
    private String extras;

    @ApiModelProperty(value = "邀请入群id(以逗号拼接)")
    private String groupIds;

    @ApiModelProperty(value = "催退群消息类型(1:文本;2:图片:邀入群)")
    private Integer urgeExitType;

    @ApiModelProperty(value = "序号")
    private Integer sort;


    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }


    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }

    public Integer getUrgeExitType() {
        return urgeExitType;
    }

    public void setUrgeExitType(Integer urgeExitType) {
        this.urgeExitType = urgeExitType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
