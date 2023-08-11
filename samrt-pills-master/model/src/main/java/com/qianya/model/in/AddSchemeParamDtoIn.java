package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: wangxin
 * @CreateTime: 2023-05-15  18:36
 * @Description: 方案入参
 */
public class AddSchemeParamDtoIn implements Serializable {

    // 主表信息实体
    @ApiModelProperty(value = "方案名称", required = true)
    private String schemeName;

    @ApiModelProperty(value = "触发条件(0:不限;1:男;2:女)", required = true)
    private Integer sex;

    @ApiModelProperty(value = "昵称触发规则")
    private String checkNickName;

    @ApiModelProperty(value = "验证内容触发规则")
    private String checkVerify;

    @ApiModelProperty(value = "自动备注")
    private String remarks;

    @ApiModelProperty(value = "开启状态(0:关闭;1:开启)", required = true)
    private Integer status;
    // 明细表信息列表
    @ApiModelProperty(value = "明细表信息列表", required = true)
    private List<SchemeItemDtoIn> itemList;

    //操作类型(0:新增;1:修改)
    @ApiModelProperty(value = "操作类型(0:新增;1:修改)", required = true)
    private  Integer operationType;


    @ApiModelProperty(value = "方案主键id修改时传", required = true)
    private Integer schemeId;

    @ApiModelProperty(value = "方案类型(1:模板;2:方案)", required = true)
    private Integer saveType;


    public List<SchemeItemDtoIn> getItemList() {
        return itemList;
    }

    public void setItemList(List<SchemeItemDtoIn> itemList) {
        this.itemList = itemList;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

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
        this.schemeName = schemeName;
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
        this.checkNickName = checkNickName;
    }

    public String getCheckVerify() {
        return checkVerify;
    }

    public void setCheckVerify(String checkVerify) {
        this.checkVerify = checkVerify;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSaveType() {
        return saveType;
    }

    public void setSaveType(Integer saveType) {
        this.saveType = saveType;
    }
}
