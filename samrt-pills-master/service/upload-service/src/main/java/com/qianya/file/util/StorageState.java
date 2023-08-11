package com.qianya.file.util;

import java.io.Serializable;

public class StorageState implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 上传是否成功 **/
	private Boolean success;
	
	/** 消息 **/
	private String msg;
	
	/** 相对路径 **/
	private String relativePath;
	
	/** 当前图片服务器请求地址前缀 **/
	private String imagePathPrefix;
	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getImagePathPrefix() {
		return imagePathPrefix;
	}

	public void setImagePathPrefix(String imagePathPrefix) {
		this.imagePathPrefix = imagePathPrefix;
	}
}