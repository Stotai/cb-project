package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 僵尸粉检测录入
 */
public class ZombieFanDtoIn  implements Serializable {


    private static final long serialVersionUID = -5177369321761709987L;


    @ApiModelProperty(value = "客户微信id")
    private String custWxId;
    @ApiModelProperty(value = "消息来源")
    private Integer source;

    public String getCustWxId() {
        return custWxId;
    }

    public void setCustWxId(String custWxId) {
        this.custWxId = custWxId;
    }



    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

}
