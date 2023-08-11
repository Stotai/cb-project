package com.qianya.cbEnum;

import com.qianya.exception.CustomException;

public enum CustomerStatusEnum {
    PENDING(0, "待接受"),
    ACCEPTED(1, "已接受"),
    IGNORED(2, "已忽略");

    private final int code;
    private final String description;

    CustomerStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static CustomerStatusEnum fromCode(int code) {
        for (CustomerStatusEnum status : CustomerStatusEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new CustomException("未知类型: " + code,false);
    }
}
