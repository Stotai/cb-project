package com.qianya.model.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-16  15:08
 * @Description: 群数据返回
 */
public class GroupDtoOut implements Serializable {


    private static final long serialVersionUID = -8386456599349178138L;

    @ApiModelProperty(value = "群id(数据库id)")
    private Integer groupId;

    @ApiModelProperty(value = "群官方id")
    private String groupWxId;


    @ApiModelProperty(value = "群昵称")
    private String groupName;

    @ApiModelProperty(value = "群头像")
    private String groupImg;

    @ApiModelProperty(value = "企业微信id")
    private String exriseUserId;

    @ApiModelProperty(value = "是否是外部群 0内部 其他外部群")
    private Integer groupType;

    @ApiModelProperty(value = "群成员数量")
    private Integer custNum;

    @ApiModelProperty(value = "分组id")
    private Integer groupingId;

    @ApiModelProperty(value = "分组名称")
    private String groupingName;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "身份(1普通成员;2:管理员;3:群主)")
    private Integer role;

    @ApiModelProperty(value = "群二维码")
    private String groupQrCode;


    public String getGroupWxId() {
        return groupWxId;
    }

    public void setGroupWxId(String groupWxId) {
        this.groupWxId = groupWxId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupImg() {
        return groupImg;
    }

    public void setGroupImg(String groupImg) {
        this.groupImg = groupImg;
    }

    public String getExriseUserId() {
        return exriseUserId;
    }

    public void setExriseUserId(String exriseUserId) {
        this.exriseUserId = exriseUserId;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getCustNum() {
        return custNum;
    }

    public void setCustNum(Integer custNum) {
        this.custNum = custNum;
    }

    public Integer getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(Integer groupingId) {
        this.groupingId = groupingId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getGroupQrCode() {
        return groupQrCode;
    }

    public void setGroupQrCode(String groupQrCode) {
        this.groupQrCode = groupQrCode;
    }
    public String getGroupingName() { return groupingName;
    }
    public void setGroupingName(String groupingName) { this.groupingName = groupingName; }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
