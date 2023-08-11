package com.qianya.util;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @Title: AjaxUtil.java
 * @Description: 
 * @Copyright: Copyright (c) 2017
 * @author: Sunt.
 * @date: 2018年4月9日下午4:10:01
 * @version: 1.0
 */
public class AjaxUtil {

	private AjaxUtil() {}


	/**
	 * 
	 * @Title: isAjax
	 * @Description: 判断是否为ajax请求
	 * @author Sunt.
	 * @time 2017年12月29日 上午9:53:17
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isAjax(ServletRequest request) {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String header = httpRequest.getHeader("X-Requested-With");

		if ("XMLHttpRequest".equalsIgnoreCase(header)) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}
	
	/**
	 * 
	 * @Title: printAjax
	 * @Description: 使用ajax方式输出
	 * @author Sunt.
	 * @time 2017年12月29日 上午9:53:29
	 * @return void 返回类型
	 * @throws
	 */
	public static void printAjax(ServletResponse response, String data) {

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setCharacterEncoding("UTF-8");
		httpResponse.setContentType("text/html; charset=UTF-8");

		try {
			PrintWriter out = httpResponse.getWriter();
			out.write(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			LogUtil.error(Object.class, e);
		}
	}
}
