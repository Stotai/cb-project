package com.qianya.file.util;

import com.aliyun.oss.OSSClient;
import com.qianya.common.JsonResult;
import com.qianya.util.DateUtil;
import com.qianya.util.LogUtil;

import java.io.InputStream;
import java.util.Date;

/**
 * 
 * @Title: OSSUtils.java
 * @Description: oss存储工具类
 * @Copyright: Copyright (c) 2018
 * @author: Sunt.
 * @date: 2019年3月19日下午6:58:16
 * @version: 1.0
 */
public class OSSUtils {

	/**
	 * 
	 * @Title: uploadFile 
	 * @Description: 上传文件
	 * @author Sunt.
	 * @time 2019年3月19日 下午6:58:39
	 * @return String    返回类型 
	 * @throws
	 */
	public static JsonResult uploadFile(String endpoint, String accessKeyId, String secretAccessKey, String bucketName, InputStream in, String remotePath, String fileName) {
		try {
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
			String relavitePath = remotePath.substring(0, remotePath.length()).replaceAll("\\\\", "/") + "/" + DateUtil.formatDate(new Date(), "yyyyMMdd") + "/" + fileName;
			ossClient.putObject(bucketName, relavitePath, in);
			ossClient.shutdown();
			in.close();
			return JsonResult.ok("/" + relavitePath);
		} catch (Exception e) {
			LogUtil.error(OSSUtils.class, e);
		}

		return JsonResult.error("上传失败");
	}

	/**
	 * 
	 * @Title: deleteFile 
	 * @Description: 删除文件
	 * @author Sunt.
	 * @time 2019年3月19日 下午6:58:54
	 * @return void    返回类型 
	 * @throws
	 */
	public static void deleteFile(String endpoint, String accessKeyId, String secretAccessKey, String bucketName, String filePath) {
		try {
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
			ossClient.deleteObject(bucketName, filePath);
		} catch (Exception e) {
			LogUtil.error(Object.class, e);
		}
	}
}