package com.qianya.entity;

import java.io.Serializable;

public class Scheme implements Serializable {
    private Integer schemeId;

    private String schemeName;

    private Integer sex;

    private String checkNickName;

    private String checkVerify;

    private String remarks;

    private Integer status;

    private Integer userId;

    private String createTime;

    private Integer isDelete;

    private Integer saveType;

    private static final long serialVersionUID = 1L;

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName == null ? null : schemeName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCheckNickName() {
        return checkNickName;
    }

    public void setCheckNickName(String checkNickName) {
        this.checkNickName = checkNickName == null ? null : checkNickName.trim();
    }

    public String getCheckVerify() {
        return checkVerify;
    }

    public void setCheckVerify(String checkVerify) {
        this.checkVerify = checkVerify == null ? null : checkVerify.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getSaveType() {
        return saveType;
    }

    public void setSaveType(Integer saveType) {
        this.saveType = saveType;
    }
}