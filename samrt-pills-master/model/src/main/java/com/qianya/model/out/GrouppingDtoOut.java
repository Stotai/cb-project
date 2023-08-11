package com.qianya.model.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-12  17:36
 * @Description: 群分组返回
 */
public class GrouppingDtoOut  implements Serializable {


    private static final long serialVersionUID = 1586248643303707457L;
    @ApiModelProperty(value = "主键id")
    private int groupingId;

    @ApiModelProperty(value = "分组名称")
    private String name;


    @ApiModelProperty(value = "创建时间")
    private String createTime;

    public int getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(int groupingId) {
        this.groupingId = groupingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
