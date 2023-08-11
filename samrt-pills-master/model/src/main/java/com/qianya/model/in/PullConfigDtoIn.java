package com.qianya.model.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "拉群配置请求参数")
public class PullConfigDtoIn implements Serializable {


    private static final long serialVersionUID = 6145949349914024892L;
    @ApiModelProperty(value = "工作时间段", example = "09:00-18:00")
    private String workTime;

    @ApiModelProperty(value = "间隔秒数", example = "60")
    private Integer waitSeconds;

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public Integer getWaitSeconds() {
        return waitSeconds;
    }

    public void setWaitSeconds(Integer waitSeconds) {
        this.waitSeconds = waitSeconds;
    }
}