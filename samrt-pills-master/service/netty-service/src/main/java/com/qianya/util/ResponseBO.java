package com.qianya.util;


import lombok.Builder;

/**
 * @author lhl
 * @date 2022/7/14
 **/
@Builder
public class ResponseBO extends BaseBO{

    private String requestUid;
    /**
     * 响应code
     */
    private String code;

    /**
     * 响应提示信息
     */
    private String message;

    /**
     * 是否成功
     */
    private Boolean success;

    public ResponseBO(String requestUid, String code, String message, Boolean success) {
        this.requestUid = requestUid;
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public String getRequestUid() {
        return requestUid;
    }

    public void setRequestUid(String requestUid) {
        this.requestUid = requestUid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}