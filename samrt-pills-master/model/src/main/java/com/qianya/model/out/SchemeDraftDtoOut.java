package com.qianya.model.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-07-02  13:34
 * @Description: 模板输出dtoOut
 */
public class SchemeDraftDtoOut implements Serializable {

    private static final long serialVersionUID = -4962550761438412300L;
    @ApiModelProperty(value = "模板id")
    private  Integer schemeId;

    @ApiModelProperty(value = "模板名称")
    private  String schemeName;

    @ApiModelProperty(value = "创建人")
    private String createUser;


    @ApiModelProperty(value = "创建时间")
    private String createTime;


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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
