package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-14  17:39
 * @Description: 群成员数据
 */
public class GroupCustParamsDtoIn implements Serializable {

    private static final long serialVersionUID = -8324023422710199520L;


    @ApiModelProperty(value = "群id(数据库主键id)")
    private Integer groupId;


    @ApiModelProperty(value = "加群开始时间")
    private String startTime;


    @ApiModelProperty(value = "加群结束时间")
    private String endTime;


    @ApiModelProperty("是否是管理员或者群主 1:是")
    private Integer isAdmin;


    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("昵称")
    private String nickeName;

    @ApiModelProperty("排序条件1:邀请人数;2:加群时间")
    private Integer sort;

    @ApiModelProperty("排序类型1:升序;2:降序")
    private Integer sortType;

    @ApiModelProperty("页大小")
    private Integer pageSize;


    @ApiModelProperty("页码")
    private Integer pageNum;

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

    public String getNickeName() {
        return nickeName;
    }

    public void setNickeName(String nickeName) {
        this.nickeName = nickeName;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
