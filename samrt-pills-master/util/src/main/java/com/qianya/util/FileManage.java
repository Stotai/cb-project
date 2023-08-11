package com.qianya.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "文件类")
public class FileManage {
	@ApiModelProperty(value = "文件名称")
	private String name;
	@ApiModelProperty(value = "文件路径")
	private String path;
	@ApiModelProperty(value = "上级文件夹")
	private String parentPath;
	@ApiModelProperty(value = "文件大小")
	private String size;
	@ApiModelProperty(value = "文件最后修改时间")
	private String lastModifiedDate;
	@ApiModelProperty(value = "是否文件夹")
	private Boolean isDirectory;
	@ApiModelProperty(value = "文件后缀")
	private String contentType;
	@ApiModelProperty(value = "系统路径")
	private String staticPath;
	public FileManage(){}
	public FileManage(String name, String path, String parentPath, String size, String lastModifiedDate,
                      boolean isDirectory, String contentType) {
		super();
		this.name = name;
		this.path = path;
		this.parentPath = parentPath;
		this.size = size;
		this.lastModifiedDate = lastModifiedDate;
		this.isDirectory = isDirectory;
		this.contentType = contentType;
	}
	
}
