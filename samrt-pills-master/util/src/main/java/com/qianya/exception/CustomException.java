package com.qianya.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 自定义异常
 * @author Sunt.
 * @since 2021-10-29 09:38
 */
public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	// 开发人员查看的错误提示
	private String inMsg;
	// 向外部展示的错误提示
	private String outMsg;
	// 开发人员查看的扩展参数
	private Map<String, Object> exMap = new HashMap<>();
	//是否发邮件.默认都要发
	private Boolean isEmail;
	public CustomException() {}

	/**
	 * @param msg 对内对外统一提示语
	 */
	public CustomException(String msg) {
		this.inMsg = msg;
		this.outMsg = msg;
		this.isEmail=true;
	}

	public CustomException(String msg,Boolean isEmail) {
		this.inMsg = msg;
		this.outMsg = msg;
		this.isEmail = isEmail;
	}
	/**
	 * @param inMsg 开发人员查看的提示信息
	 * @param outMsg 向外部展示的错误提示
	 */
	public CustomException(String inMsg, String outMsg) {
		this.inMsg = inMsg;
		this.outMsg = outMsg;
		this.isEmail=true;
	}

	public CustomException(String inMsg, String outMsg,Boolean isEmail) {
		this.inMsg = inMsg;
		this.outMsg = outMsg;
		this.isEmail = isEmail;
	}

	/**
	 * @param inMsg 开发人员查看的提示信息
	 * @param outMsg 向外部展示的错误提示
	 * @param exMap 开发人员查看的扩展参数
	 */
	public CustomException(String inMsg, String outMsg, Map<String, Object> exMap) {
		this.inMsg = inMsg;
        this.outMsg = outMsg;
        this.exMap = exMap;
		this.isEmail=true;
    }
	public CustomException(String inMsg, String outMsg, Map<String, Object> exMap,Boolean isEmail) {
		this.inMsg = inMsg;
        this.outMsg = outMsg;
        this.exMap = exMap;
		this.isEmail = isEmail;
    }

	public String getInMsg() {
		return this.inMsg;
	}
	
	public String getOutMsg() {
		return this.outMsg;
	}
	
	public Map<String, Object> getExMap() {
		return this.exMap;
	}
	public Boolean getIsEmail() {
		return this.isEmail;
	}
}