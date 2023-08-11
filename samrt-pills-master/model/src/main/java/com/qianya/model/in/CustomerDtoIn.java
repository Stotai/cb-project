package com.qianya.model.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("新增客户信息请求参数")
public class CustomerDtoIn implements Serializable {

    private static final long serialVersionUID = 5697936040860073211L;



    @ApiModelProperty(value = "客户企业微信ID", required = true, example = "2")
    private String custWxId;

    @ApiModelProperty(value = "客户企业微信名称", required = true, example = "客户")
    private String custWxName;

    @ApiModelProperty(value = "客户企业微信头像URL", example = "http://example.com/avatar.jpg")
    private String custWxHeadUrl;

    @ApiModelProperty(value = "验证内容", required = true, example = "验证信息")
    private String verifyContent;

    @ApiModelProperty(value = "性别", required = true, example = "1")
    private Integer sex;



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

    public String getCustWxHeadUrl() {
        return custWxHeadUrl;
    }

    public void setCustWxHeadUrl(String custWxHeadUrl) {
        this.custWxHeadUrl = custWxHeadUrl;
    }

    public String getVerifyContent() {
        return verifyContent;
    }

    public void setVerifyContent(String verifyContent) {
        this.verifyContent = verifyContent;
    }



    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}