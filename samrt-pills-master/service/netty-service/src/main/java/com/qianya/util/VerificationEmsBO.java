package com.qianya.util;


/**
 * 验证码短信
 *
 * @author hl.Wu
 * @date 2022/7/14
 **/
public class VerificationEmsBO extends BaseBO{

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 短信内容
     */
    private String message;

    public VerificationEmsBO(String mobile, String message) {
        this.mobile = mobile;
        this.message = message;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}