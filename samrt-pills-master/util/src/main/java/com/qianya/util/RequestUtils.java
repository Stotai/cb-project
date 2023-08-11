package com.qianya.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class RequestUtils {

	/**
	 * @description 获取当前请求对象
	 * @return javax.servlet.http.HttpServletRequest
	 * @author Sunt.
	 * @since 2020-12-23 21:16
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attributes == null ? null : attributes.getRequest();
	}

	/**
	 * @description 从request参数中获取String类型参数
	 * @author Sunt.
	 * @since 2020-12-15 14:32
	 */
	public static String extractParameter(HttpServletRequest request, String name) {
		return (request == null || StringUtil.isEmpty(name)) ? null : request.getParameter(name);
	}

	/**
	 * @description 从request参数中获取Integer类型参数
	 * @author Sunt.
	 * @since 2020-12-15 14:32
	 */
	public static Integer extractParameterInt(HttpServletRequest request, String name) {
		return parseInteger(extractParameter(request, name));
	}

	/**
	 * @description 从request参数中获取Long类型参数
	 * @author Sunt.
	 * @since 2020-12-15 14:32
	 */
	public static Long extractParameterLong(HttpServletRequest request, String name) {
		return parseLong(extractParameter(request, name));
	}

	/**
	 * @description 从header参数中获取String类型参数
	 * @author Sunt.
	 * @since 2020-12-15 14:33
	 */
	public static String extractHeader(HttpServletRequest request, String name) {
		return (request == null || StringUtil.isEmpty(name)) ? null : request.getHeader(name);
	}

	/**
	 * @description 从header参数中获取Integer类型参数
	 * @author Sunt.
	 * @since 2020-12-15 14:33
	 */
	public static Integer extractHeaderInt(HttpServletRequest request, String name) {
		return parseInteger(extractHeader(request, name));
	}

	/**
	 * @description 从header参数中获取Long类型参数
	 * @author Sunt.
	 * @since 2020-12-15 14:33
	 */
	public static Long extractHeaderLong(HttpServletRequest request, String name) {
		return parseLong(extractHeader(request, name));
	}

	/**
	 * @description 类型转换为Integer
	 * @param value 需要被转换为Integer类型的值
	 * @return java.lang.Integer
	 * @author Sunt.
	 * @since 2020-12-15 14:31
	 */
	private static Integer parseInteger(String value) {
		if (StringUtil.isNotEmpty(value)) {
			try {
				return Integer.parseInt(value);
			} catch (Exception e) {}
		}
		return null;
	}

	/**
	 * @description 类型转换为Long
	 * @param value 需要被转换为Long类型的值
	 * @return java.lang.Long
	 * @author Sunt.
	 * @since 2020-12-15 14:32
	 */
	private static Long parseLong(String value) {
		if (StringUtil.isNotEmpty(value)) {
			try {
				return Long.parseLong(value);
			} catch (Exception e) {}
		}
		return null;
	}

	/**
	 * 打印参数
	 *
	 * @author Sunt.
	 * @since 2020年1月13日 下午4:08:33
	 */
	public static void printParams(HttpServletRequest request) {
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			LogUtil.info(RequestUtils.class, name + "\t--->\t" + request.getParameter(name));
		}
		names = null;
	}

	/**
	 * 打印请求客户端信息
	 *
	 * @author Sunt.
	 * @since 2020年5月19日 上午11:00:31
	 */
	public static void printClientInfo(HttpServletRequest request) {
		printClientInfo(request, null);
	}

	public static void printClientInfo(HttpServletRequest request, String tips) {
		String agent = request.getHeader("user-agent");
		String ipAddr = IpUtils.getIpAddr(request);
		String msg = "";
		if (StringUtil.isEmpty(agent)) {
			agent = "";
		}
		// 安卓系统
		if (agent.contains("Android")) {
			msg += "、Android";
		}
		// IOS系统
		if (agent.contains("iPhone") || agent.contains("iPod") || agent.contains("iPad")) {
			msg += "、IOS";
		}
		// 小米
		if (agent.contains("MI")) {
			msg += "、MI";
		}
		// 联想
		if (agent.contains("lenovo")) {
			msg += "、lenovo";
		}
		// 是否wifi
		if (agent.contains("WIFI")) {
			msg += "、WIFI";
		}
		LogUtil.info(RequestUtils.class, (tips==null?"":tips + "，") + "请求客户端信息：agent:【"+agent+"】，ip地址:【"+ipAddr+"】，device:【"+(msg.startsWith("、")?msg.substring(1):msg)+"】，相关参数如下");
	}
}