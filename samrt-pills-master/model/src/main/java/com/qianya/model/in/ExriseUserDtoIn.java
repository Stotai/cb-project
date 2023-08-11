package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-26  10:36
 * @Description: 企业微信入参
 */
public class ExriseUserDtoIn  implements Serializable {


    private static final long serialVersionUID = 4286031080278655101L;
    @ApiModelProperty(value = "企业微信id")
    private String exriseWxId;

    @ApiModelProperty(value = "主体id")
    private String companyId;

    @ApiModelProperty(value = "主体名称")
    private String companyName;

    @ApiModelProperty(value = "企业微信名称")
    private String exriseWxName;

    @ApiModelProperty(value = "备注")
    private String wxRemark;

    @ApiModelProperty(value = "企业微信头像")
    private String exriseWxUrl;

    @ApiModelProperty(value = "好友数量")
    private Integer customerNum;

    @ApiModelProperty(value = "群组数量")
    private Integer groupNum;

    @ApiModelProperty(value = "最新登录时间")
    private String loginTime;





    public String getExriseWxId() {
        return exriseWxId;
    }

    public void setExriseWxId(String exriseWxId) {
        this.exriseWxId = exriseWxId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getExriseWxName() {
        return exriseWxName;
    }

    public void setExriseWxName(String exriseWxName) {
        this.exriseWxName = exriseWxName;
    }

    public String getWxRemark() {
        return wxRemark;
    }

    public void setWxRemark(String wxRemark) {
        this.wxRemark = wxRemark;
    }

    public String getExriseWxUrl() {
        return exriseWxUrl;
    }

    public void setExriseWxUrl(String exriseWxUrl) {
        this.exriseWxUrl = exriseWxUrl;
    }

    public Integer getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(Integer customerNum) {
        this.customerNum = customerNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

}
