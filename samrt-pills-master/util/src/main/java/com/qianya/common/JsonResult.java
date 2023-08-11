package com.qianya.common;

import java.io.Serializable;

/**
 * 
 * @Title: JsonResult.java
 * @Description: 自定义响应结构
 * @Copyright: Copyright (c) 2017
 * @author: Sunt.
 * @date: 2018年3月7日下午3:30:25
 * @version: 1.0
 */
public class JsonResult implements Serializable {

	/** 成功 **/
	public static final int CODE_200 = 200;
	/** 成功 **/
	public static final int CODE_201 = 201;
	/** 校验失败 **/
	public static final int CODE_400 = 400;
	/** 未登录 **/
	public static final int CODE_401 = 401;
	/** 未授权 **/
	public static final int CODE_402 = 402;
	/** 没有权限 **/
	public static final int CODE_403 = 403;
	/** 找不到资源 **/
	public static final int CODE_404 = 404;
	/** 验证码发送频繁 **/
	public static final int CODE_405 = 405;
	/** 服务器错误 **/
	public static final int CODE_500 = 500;

	private static final long serialVersionUID = 1L;

	// 响应业务状态
	private Integer status;

	// 成功与否布尔值
	private Boolean success;

	// 响应消息
	private String msg = "";

	// 响应中的数据
	private Object data;

	public JsonResult() {
		this.success = true;
	}

	public JsonResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
		if (status != null && status != CODE_200) {
			this.success = false;
		} else {
			this.success = true;
		}
	}

	public JsonResult(Object data) {
		this.status = CODE_200;
		this.data = data;
		this.success = true;
	}

	public JsonResult(Boolean success, Integer status, String msg) {
		this.success = success;
		this.status = status;
		this.msg = msg;
	}

	public static JsonResult ok() {
		return ok(null);
	}

	public static JsonResult ok(Object data) {
		return new JsonResult(JsonResult.CODE_200, "操作成功", data);
	}
	
	public static JsonResult ok(String msg, Object data) {
		return new JsonResult(JsonResult.CODE_200, msg, data);
	}

	public static JsonResult error() {
		return error("操作失败");
	}

	public static JsonResult error(String msg) {
		return error(CODE_500, msg);
	}

	public static JsonResult error(Integer status, String msg) {
		return error(status, msg, null);
	}

	public static JsonResult error(Integer status, String msg, Object data) {
		return new JsonResult(status != null ? status : CODE_500, msg, data);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "JsonResult [status=" + status + ", success=" + success + ", msg=" + msg + ", data=" + data + "]";
	}
}
