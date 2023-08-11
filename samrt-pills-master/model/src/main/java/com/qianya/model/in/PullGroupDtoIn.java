package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-14  14:12
 * @Description: 拉群入参
 */
public class PullGroupDtoIn implements Serializable {


    private static final long serialVersionUID = 7338803018509917398L;
    //客户ids
    @ApiModelProperty(value = "选中的客户id 不传为所有")
    private List<String> customerIds;


    //群ids
    @ApiModelProperty(value = "要拉群的id")
    private List<String> groupIds;


    //拉群名称
    @ApiModelProperty(value = "拉群任务名称")
    private String pullGroupName;


    //群最大数量
    @ApiModelProperty(value = "群最大数量")
    private Integer maxSize;


    //每日处理最大数量
    @ApiModelProperty(value = "每日处理最大数量")
    private Integer dayMaxNum;


    //消息
    @ApiModelProperty(value = "消息")
    private List<PullGroupDetailDtoIn> detailDtoInList;

    public List<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    public List<String> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Integer getDayMaxNum() {
        return dayMaxNum;
    }

    public void setDayMaxNum(Integer dayMaxNum) {
        this.dayMaxNum = dayMaxNum;
    }

    public List<PullGroupDetailDtoIn> getDetailDtoInList() {
        return detailDtoInList;
    }

    public void setDetailDtoInList(List<PullGroupDetailDtoIn> detailDtoInList) {
        this.detailDtoInList = detailDtoInList;
    }

    public String getPullGroupName() {
        return pullGroupName;
    }

    public void setPullGroupName(String pullGroupName) {
        this.pullGroupName = pullGroupName;
    }
}
