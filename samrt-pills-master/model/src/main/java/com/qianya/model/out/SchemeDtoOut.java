package com.qianya.model.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "方案DTO")
public class SchemeDtoOut implements Serializable {

    private static final long serialVersionUID = 5690342075524008664L;
    @ApiModelProperty(value = "方案主键ID")
    private Integer schemeId;

    @ApiModelProperty(value = "方案名称")
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

    @ApiModelProperty(value = "明细数据列表")
    private List<SchemeItemDtoOut> itemList;

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

    public List<SchemeItemDtoOut> getItemList() {
        return itemList;
    }

    public void setItemList(List<SchemeItemDtoOut> itemList) {
        this.itemList = itemList;
    }
}
