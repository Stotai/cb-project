package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-14  18:24
 * @Description: TODO
 */
public class ZombieFansEditDtoIn implements Serializable {


    private static final long serialVersionUID = 931198561244335112L;
    @ApiModelProperty("粉丝id数组")
    List<String> fanIds;


    @ApiModelProperty("操作类型(1:批量删除;2:批量忽略;3:批量添加)")
    private Integer opType;


    public List<String> getFanIds() {
        return fanIds;
    }

    public void setFanIds(List<String> fanIds) {
        this.fanIds = fanIds;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }
}
