package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ZombieConfigDtoIn implements Serializable {


    private static final long serialVersionUID = 3595358222303526783L;


    @ApiModelProperty(value = "自动检测状态(0:开启;1:关闭)")
    private Integer autoStatus;

    @ApiModelProperty(value = "上次检测时间")
    private String lastTime;

    @ApiModelProperty(value = "删除前是否发消息(0:否;1:是)")
    private Integer msgStatus;

    @ApiModelProperty(value = "消息")
    private String msg;

    @ApiModelProperty(value = "删除间隔起始秒数")
    private Integer deleteUnitS;

    @ApiModelProperty(value = "删除间隔结束秒数")
    private Integer deleteUnitE;

    @ApiModelProperty(value = "申请好友验证内容")
    private String  addContent;


    @ApiModelProperty(value = "重新添加好友间隔起始秒数")
    private Integer addUnitS;

    @ApiModelProperty(value = "重新添加好友间隔结束秒数")
    private Integer addUnitE;



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
        this.lastTime = lastTime;
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
        this.msg = msg;
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

    public String getAddContent() {
        return addContent;
    }

    public void setAddContent(String addContent) {
        this.addContent = addContent;
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
