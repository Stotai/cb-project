package com.qianya.model.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("新增客户信息延迟")
public class AddCustomerDelay implements Serializable {

    private static final long serialVersionUID = 5697936040860073211L;

    @ApiModelProperty(value = "用户id集合")
    private List<String> userIds;
    @ApiModelProperty(value = "最小值")
    private Integer delayMin;
    @ApiModelProperty(value = "最大值")
    private Integer delayMax;
    @ApiModelProperty(value = "发送内容")
    private String content;
    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public Integer getDelayMin() {
        return delayMin;
    }

    public void setDelayMin(Integer delayMin) {
        this.delayMin = delayMin;
    }

    public Integer getDelayMax() {
        return delayMax;
    }

    public void setDelayMax(Integer delayMax) {
        this.delayMax = delayMax;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}