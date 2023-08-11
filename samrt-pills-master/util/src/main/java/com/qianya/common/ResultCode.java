package com.qianya.common;

import lombok.Getter;

/**
 * @Package: com.qianya.model.common
 * @ClassName: ResultCode
 * @Author: zzq
 * @Description:
 * @Date: 2020/6/9 14:26
 * @Version: 1.0
 */
@Getter
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(201, "操作失败"),
    EMPTY_RESULT(202, "未查询到数据"),

    ERROR(999, "操作失败"),

    NOSIGNSSTATE(444,"没有体征状态"),
    OTHER_EXCEPTION(666, "其他异常"),

    IMAGES_ExCEPTION(444,"图片"),
    FACE_NOT_FOUND(998, "人脸未检测到"),
    PATIENT_NOT_FOUND(997, "未查询到该患者"),
    Doctor_ORDER_NOT_FOUND(996, "未查询到该患者"),

    VALIDATE_FAILED(299, "参数检验失败"),
    VERIFY_CODE_ERROR(299, "验证码校验失败"),
    UNAUTHORIZED(900, "暂未登录或token已经过期"),
    FORBIDDEN(888, "没有相关权限"),

    NOPARAMETERSSELECTED(897,"没有相关的参数被选择");
    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
