package com.qianya.cbEnum;

import com.qianya.exception.CustomException;


public enum NettyMsgEnum {
    OK(1,"ok", "连接socket成功"),
    ADD_CUSTOMER(2,"add_cust", "新增好友"),
    CHECK_ZOMBIE(3,"check_zombie", "检测僵尸粉"),
    GROUP_SEND(4,"group_send", "高级群发"),
    PULL_GROUP(5,"pull_group", "批量拉群"),
    SPEED_GROUP_SEND(6,"speed_group_send", "极速群发"),
    CRICLE_FRIENDS_SEND(7,"cricle_firends_send", "极速群发");

    private final Integer type;
    private final String code;
    private final String description;

    NettyMsgEnum(Integer type,String code, String description) {
        this.type = type;
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public Integer getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static CustomerStatusEnum fromCode(String code) {
        for (CustomerStatusEnum status : CustomerStatusEnum.values()) {
            if (code.equals(status.getCode())) {
                return status;
            }
        }
        throw new CustomException("未知类型: " + code,false);
    }
}
