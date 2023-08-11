package com.qianya.file.util;

import java.util.Random;
import java.util.UUID;

/**
 * 
 * @Title: IDUtils.java
 * @Description: 各种id生成策略
 * @Copyright: Copyright (c) 2017
 * @author: Sunt.
 * @date: 2018年4月18日下午4:20:29
 * @version: 1.0
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	public static long genIdNumber() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	public static String genIdString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 
	 * @Title: genUuidPrefixEight 
	 * @Description: 获取uuid前八位
	 * @author Sunt.
	 * @time 2018年12月17日 下午3:51:52
	 * @return String    返回类型 
	 * @throws
	 */
	public static String genUuidPrefixEight() {
		return IDUtils.genIdString().substring(24);
	}
}
