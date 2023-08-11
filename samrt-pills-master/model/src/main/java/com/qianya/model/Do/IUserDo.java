package com.qianya.model.Do;

import java.io.Serializable;

public class IUserDo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String phone;

    private String password;

    private String cbCode;

    private Integer enterpriseId;

    private String createTime;

    private String exriseWxId;

    private String exriseWxName;

    //授权到期时间
    private String authorizationTime;

    //是否能使用系统 0可以使用 1授权到期 2未授权微信
    private Integer useSystemFlag;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCbCode() {
        return cbCode;
    }

    public void setCbCode(String cbCode) {
        this.cbCode = cbCode;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExriseWxId() {
        return exriseWxId;
    }

    public void setExriseWxId(String exriseWxId) {
        this.exriseWxId = exriseWxId;
    }

    public String getExriseWxName() {
        return exriseWxName;
    }

    public void setExriseWxName(String exriseWxName) {
        this.exriseWxName = exriseWxName;
    }
    public Integer getUseSystemFlag() {
        return useSystemFlag;
    }
    public void setUseSystemFlag(Integer useSystemFlag) {
        this.useSystemFlag = useSystemFlag;
    }

    public String getAuthorizationTime() {
        return authorizationTime;
    }

    public void setAuthorizationTime(String authorizationTime) {
        this.authorizationTime = authorizationTime;
    }
}
