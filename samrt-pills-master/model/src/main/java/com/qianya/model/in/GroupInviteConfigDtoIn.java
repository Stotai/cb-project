package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-19  18:42
 * @Description: 群邀请配置入参dtoIn
 */
public class GroupInviteConfigDtoIn implements Serializable {


    private static final long serialVersionUID = 2510800290661893964L;

    @ApiModelProperty(value = "自动通过状态(0:关闭;1:开起)")
    private Integer autoStatus;


    @ApiModelProperty(value = "免打扰状态(0:关闭;1:开起)")
    private Integer disturbStatus;


    @ApiModelProperty(value = "通过频率已逗号拼接")
    private String passRate;

    public Integer getDisturbStatus() {
        return disturbStatus;
    }

    public void setDisturbStatus(Integer disturbStatus) {
        this.disturbStatus = disturbStatus;
    }

    public String getPassRate() {
        return passRate;
    }

    public void setPassRate(String passRate) {
        this.passRate = passRate;
    }

    public Integer getAutoStatus() {
        return autoStatus;
    }

    public void setAutoStatus(Integer autoStatus) {
        this.autoStatus = autoStatus;
    }
}
