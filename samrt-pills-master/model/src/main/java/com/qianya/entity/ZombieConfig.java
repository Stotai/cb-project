package com.qianya.entity;

import java.io.Serializable;

public class ZombieConfig implements Serializable {
    private Integer configId;

    private Integer autoStatus;

    private String lastTime;

    private Integer msgStatus;

    private String msg;

    private Integer deleteUnitS;

    private Integer deleteUnitE;

    private Integer userId;

    private String createTime;

    private String updateTime;

    private String addContent;

    private Integer addUnitS;

    private Integer addUnitE;

    private static final long serialVersionUID = 1L;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public Integer getAutoStatus() {
        return autoStatus;
    }

    public void setAutoStatus(Integer autoStatus) {
        this.autoStatus = autoStatus;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime == null ? null : lastTime.trim();
    }

    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Integer getDeleteUnitS() {
        return deleteUnitS;
    }

    public void setDeleteUnitS(Integer deleteUnitS) {
        this.deleteUnitS = deleteUnitS;
    }

    public Integer getDeleteUnitE() {
        return deleteUnitE;
    }

    public void setDeleteUnitE(Integer deleteUnitE) {
        this.deleteUnitE = deleteUnitE;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getAddContent() {
        return addContent;
    }

    public void setAddContent(String addContent) {
        this.addContent = addContent == null ? null : addContent.trim();
    }

    public Integer getAddUnitS() {
        return addUnitS;
    }

    public void setAddUnitS(Integer addUnitS) {
        this.addUnitS = addUnitS;
    }

    public Integer getAddUnitE() {
        return addUnitE;
    }

    public void setAddUnitE(Integer addUnitE) {
        this.addUnitE = addUnitE;
    }
}