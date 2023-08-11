package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-14  17:39
 * @Description: TODO
 */
public class GroupParamsDtoIn implements Serializable {

    private static final long serialVersionUID = -8324023422710199520L;
    @ApiModelProperty(value = "建群开始时间")
    private String startTime;


    @ApiModelProperty(value = "建群结束时间")
    private String endTime;


    @ApiModelProperty("身份(0 普通成员;1:群主或管理员;2:管理员;3:群主)")
    private Integer role;


    @ApiModelProperty("群昵称")
    private String nickeName;

    @ApiModelProperty("包含昵称(0包含;1:不包含) 空默认")
    private Integer isContain;

    @ApiModelProperty("群成员数开始")
    private Integer custNumStart;


    @ApiModelProperty("群成员数结束")
    private Integer custNumEnd;


    private String exriseUserId;

    @ApiModelProperty("分组id")
    private Integer groupingId;



    //用户id
    private Integer userId;


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getNickeName() {
        return nickeName;
    }

    public void setNickeName(String nickeName) {
        this.nickeName = nickeName;
    }

    public Integer getCustNumStart() {
        return custNumStart;
    }

    public void setCustNumStart(Integer custNumStart) {
        this.custNumStart = custNumStart;
    }

    public Integer getCustNumEnd() {
        return custNumEnd;
    }

    public void setCustNumEnd(Integer custNumEnd) {
        this.custNumEnd = custNumEnd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExriseUserId() {
        return exriseUserId;
    }

    public void setExriseUserId(String exriseUserId) {
        this.exriseUserId = exriseUserId;
    }

    public Integer getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(Integer groupingId) {
        this.groupingId = groupingId;
    }

    public Integer getIsContain() {
        return isContain;
    }

    public void setIsContain(Integer isContain) {
        this.isContain = isContain;
    }
}
