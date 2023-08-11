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
public class JsonResultT<T> implements Serializable {

	/** 成功 **/
	public static final int CODE_200 = 200;
	/** 金额变动 **/
	public static final int CODE_201 = 201;
	/** 商品下架 **/
	public static final int CODE_202 = 202;
	/** 校验失败 **/
	public static final int CODE_400 = 400;
	/** 未登录 **/
	public static final int CODE_401 = 401;
	/** 未授权 **/
	public static final int CODE_402 = 402;
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
	private T data;

	public JsonResultT() {
		this.success = true;
	}

	public JsonResultT(Integer status, String msg, T data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
		if (status != null && status != CODE_200) {
			this.success = false;
		} else {
			this.success = true;
		}
	}

	public JsonResultT(T data) {
		this.status = CODE_200;
		this.data = data;
		this.success = true;
	}

	public JsonResultT(Boolean success, Integer status, String msg) {
		this.success = success;
		this.status = status;
		this.msg = msg;
	}

	public static <T> JsonResultT<T> ok() {
		return ok(null);
	}

	public static <T> JsonResultT<T> ok(T data) {
		return ok("操作成功", data);
	}

	public static <T> JsonResultT<T> ok(String msg, T data) {
		return new JsonResultT<T>(CODE_200, msg != null ? msg : "操作成功", data);
	}

	public static <T> JsonResultT<T> error() {
		return error("操作失败");
	}

	public static <T> JsonResultT<T> error(String msg) {
		return error(null, msg);
	}

	public static <T> JsonResultT<T> error(Integer status, String msg) {
		return error(status, msg, null);
	}

	public static <T> JsonResultT<T> error(Integer status, String msg, T data) {
		return new JsonResultT<T>(status != null ? status : CODE_500, msg, data);
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

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
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
		return "JsonResultT [status=" + status + ", success=" + success + ", msg=" + msg + ", data=" + data + "]";
	}
}