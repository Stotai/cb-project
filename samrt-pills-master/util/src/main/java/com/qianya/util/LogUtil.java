package com.qianya.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

	/**
	 * 
	 * @Title: error 
	 * @Description: 打印异常信息和异常类（常用），【禁止重载、重写】
	 * @author Sunt.
	 * @time 2018年5月15日 上午11:14:29
	 * @return void    返回类型 
	 * @throws
	 */
	public final static void error(Class<?> clazz, String message, Throwable t) {
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.error(message, t);
	}

	/**
	 * 
	 * @Title: error 
	 * @Description: 打印异常信息和异常类
	 * @author Sunt.
	 * @time 2018年5月15日 上午11:14:47
	 * @return void    返回类型 
	 * @throws
	 */
	public final static void error(Class<?> clazz, Throwable t) {
		error(clazz, t.getMessage(), t);
	}

	/**
	 * 
	 * @Title: info 
	 * @Description: 打印信息
	 * @author Sunt.
	 * @time 2018年5月15日 上午11:15:03
	 * @return void    返回类型 
	 * @throws
	 */
	public final static void info(Class<?> clazz, String message) {
		Logger logger = LoggerFactory.getLogger(clazz);
		logger.info(message);
	}
}