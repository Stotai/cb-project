package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-12  19:01
 * @Description: 群成员入参dtoIn
 */
public class GroupCustDtoIn implements Serializable {


    private static final long serialVersionUID = 2763865964251175149L;
    @ApiModelProperty(value = "群官方id")
    private String groupWxId;

    @ApiModelProperty(value = "客户企业微信id")
    private String custWxId;

    @ApiModelProperty(value = "客户企业微信名称")
    private String custWxName;

    @ApiModelProperty(value = "性别(0:男;1女)")
    private Integer sex;

    @ApiModelProperty(value = "客户企业微信头像地址")
    private String custWxHeadUrl;

    @ApiModelProperty(value = "加群时间")
    private String joinTime;

    @ApiModelProperty(value = "是否是管理员(0:否;1:是)")
    private Integer isAdmin;

    @ApiModelProperty(value = "邀请次数")
    private Integer invitationsTimes;


    @ApiModelProperty(value = "邀请人id")
    private String invitaUserId;

    public String getGroupWxId() {
        return groupWxId;
    }

    public void setGroupWxId(String groupWxId) {
        this.groupWxId = groupWxId;
    }

    public String getCustWxId() {
        return custWxId;
    }

    public void setCustWxId(String custWxId) {
        this.custWxId = custWxId;
    }

    public String getCustWxName() {
        return custWxName;
    }

    public void setCustWxName(String custWxName) {
        this.custWxName = custWxName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCustWxHeadUrl() {
        return custWxHeadUrl;
    }

    public void setCustWxHeadUrl(String custWxHeadUrl) {
        this.custWxHeadUrl = custWxHeadUrl;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getInvitationsTimes() {
        return invitationsTimes;
    }

    public void setInvitationsTimes(Integer invitationsTimes) {
        this.invitationsTimes = invitationsTimes;
    }

    public String getInvitaUserId() {
        return invitaUserId;
    }

    public void setInvitaUserId(String invitaUserId) {
        this.invitaUserId = invitaUserId;
    }
}
