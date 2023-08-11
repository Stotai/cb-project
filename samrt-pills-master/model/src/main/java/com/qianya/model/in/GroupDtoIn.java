package com.qianya.model.in;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: wangxin
 * @CreateTime: 2023-06-12  18:20
 * @Description: 群入参
 */
public class GroupDtoIn implements Serializable {

    private static final long serialVersionUID = -1338683567237705407L;


    @ApiModelProperty(value = "群官方id")
    private String groupWxId;
    @ApiModelProperty(value = "群昵称")
    private String groupName;

    @ApiModelProperty(value = "群头像")
    private String groupImg;
    @ApiModelProperty(value = "是否是外部群 0内部 其他外部群")
    private Integer groupType;

    @ApiModelProperty(value = "群成员数量")
    private Integer custNum;

    @ApiModelProperty(value = "分组id")
    private Integer groupingId;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "群主id")
    private String createUserId;

    @ApiModelProperty(value = "群二维码")
    private String groupQrCode;

    public String getGroupWxId() {
        return groupWxId;
    }

    public void setGroupWxId(String groupWxId) {
        this.groupWxId = groupWxId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupImg() {
        return groupImg;
    }

    public void setGroupImg(String groupImg) {
        this.groupImg = groupImg;
    }



    public Integer getCustNum() {
        return custNum;
    }

    public void setCustNum(Integer custNum) {
        this.custNum = custNum;
    }

    public Integer getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(Integer groupingId) {
        this.groupingId = groupingId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGroupQrCode() {
        return groupQrCode;
    }

    public void setGroupQrCode(String groupQrCode) {
        this.groupQrCode = groupQrCode;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }


}
