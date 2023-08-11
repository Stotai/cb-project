package com.qianya.model.out;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-07  17:20
 * @Description: 企业客户列表输出dtoOut
 */
public class CustomerListDtoOut  implements Serializable {


    private static final long serialVersionUID = -2759437411132341937L;
    /* 客户id */
    private Integer customerId;

    /* 关联用户id */
    private Integer userId;

    /* 关联企业微信id */
    private String epriseWxId;

    /* 关联企业微信名称 */
    private String epriseWxName;

    /* 客户企业微信id */
    private String custWxId;

    /* 客户企业微信名称 */
    private String custWxName;

    /* 客户企业微信头像地址 */
    private String custWxHeadUrl;

    /* 验证内容 */
    private String verifyContent;

    /* 添加类型(1:软件添加;2:其他) */
    private Integer addType;

    /* 状态(0:待接受;1:已接受;2:已忽略) */
    private Integer status;

    /* 申请时间 */
    private String createTime;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEpriseWxId() {
        return epriseWxId;
    }

    public void setEpriseWxId(String epriseWxId) {
        this.epriseWxId = epriseWxId;
    }

    public String getEpriseWxName() {
        return epriseWxName;
    }

    public void setEpriseWxName(String epriseWxName) {
        this.epriseWxName = epriseWxName;
    }

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

    public Integer getAddType() {
        return addType;
    }

    public void setAddType(Integer addType) {
        this.addType = addType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
