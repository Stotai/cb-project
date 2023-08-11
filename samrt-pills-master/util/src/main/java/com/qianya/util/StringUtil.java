package com.qianya.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: StringUtil
 * @Description: 字符串工具类
 * @author txy
 * @date 2016年4月12日 下午3:17:51
 *
 */
public class StringUtil {

	/**
	 * 
	 * @Title: isEmpty 
	 * @Description: 判断多个字符串中有至少一个为空
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:25:40
	 * @return Boolean    返回类型 
	 * @throws
	 */
	public static Boolean isEmpty(Object... objs) {
		for (Object object : objs) {
			if (isEmpty(object)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @Title: isEmpty 
	 * @Description: 判断对象是否为空
	 * @author Sunt.
	 * @time 2019年6月5日 上午11:41:54
	 * @return Boolean    返回类型 
	 * @throws
	 */
	public static Boolean isEmpty(Object obj) {
		if (obj != null) {
			return isEmpty(obj.toString());
		}
		return true;
	}

	/**
	 * 
	 * @Title: isNotEmpty 
	 * @Description: 判断多个字符串中有没有一个为空
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:25:26
	 * @return Boolean    返回类型 
	 * @throws
	 */
	public static Boolean isNotEmpty(Object... objs) {
		return !isEmpty(objs);
	}

	/**
	 * 
	 * @Title: isEmpty 
	 * @Description: 判断字符串为空
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:24:20
	 * @return Boolean    返回类型 
	 * @throws
	 */
	public static Boolean isEmpty(String str) {
		if (str != null) {
			str = str.replaceAll(" ", "");
			if (!"".equals(str)) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}
	
	/**
	 * 
	 * @Title: isNotEmpty 
	 * @Description: 判断字符串不为空
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:26:15
	 * @return Boolean    返回类型 
	 * @throws
	 */
	public static Boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 
	 * @Title: getSmsVerfyCode 
	 * @Description: 生成6位数字的验证码
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:32:37
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getSmsVerfyCode() {
		return getSmsVerfyCode(6);
	}

	/**
	 * @description 获取指定位数验证码
	 * @param len
	 * @return java.lang.String
	 * @author Sunt.
	 * @since 2021-11-04 15:45
	 */
	public static String getSmsVerfyCode(int len) {
		double n = Math.random();
		while (n < 0.1) {
			n = Math.random();
		}
		return (""+n).substring(2, 2 + len);
	}

	/**
	 * 只截取最后一位是","的字符串str 如果不是就返回原字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String substringLast(String str) {
		return substringLast(str, ",");
	}

	/**
	 * 截取最后一位是str2的字符串str
	 * 
	 * @param str
	 * @return
	 */
	public static String substringLast(String str, String lastStr) {
		if (isNotEmpty(lastStr)) {
			if (lastStr.equals(str.substring(str.length() - 1))) {
				if (isNotEmpty(str)) {
					str = str.substring(0, str.length() - 1);
				}
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: changePhone 
	 * @Description: 手机号码加*号183****7281
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:34:04
	 * @return String    返回类型 
	 * @throws
	 */
	public static String changePhone(String phone) {
		if (phone.length()<7) {
			return phone;
		}
		StringBuffer str = new StringBuffer();
		str.append(phone.substring(0, 3));
		for (int i = 0; i < phone.length() - 7; i++) {
			str.append("*");
		}
		str.append(phone.substring(phone.length() - 4, phone.length()));
		return str.toString();
	}

	/**
	 * 
	 * @Title: twoDecimal 
	 * @Description: 两个数相除 保留两位小数
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:34:45
	 * @return String    返回类型 
	 * @throws
	 */
	public static String twoDecimal(Object divisor, Object dividend) {
		DecimalFormat df = new DecimalFormat("0.00");
		if (dividend != null && !"0".equals(dividend.toString()) &&!"0.0".equals(dividend.toString())) {
			return df.format(Double.parseDouble(divisor.toString()) / Double.parseDouble(dividend.toString()));
		}
		return "0";
	}
	/***
	 * 
	 * @Title: getPercentageByAexceptB 
	 * @Description: 返回a/b的百分数
	 * @author yehg.
	 * @param a 
	 * @param b
	 * @param c 精度表示百分后的几位小数
	 * @return
	 * @return String    返回类型 
	 * @throws
	 * 
	 */
	public static String getPercentageByAexceptB(double a,double b,int c){
		   double percent = a / b;
		   NumberFormat nt = NumberFormat.getPercentInstance();
		   nt.setMinimumFractionDigits(2);
		return nt.format(percent);
	}
	
	public static List<String> getListToString(String str) {
		List<String> list = new ArrayList<String>();
		String strs[] = str.split(",");
		for (String string : strs) {
			list.add(string);
		}
		return list;
	}
	
	/**
	 * 
	 * @Title: getSeason 
	 * @Description: 返回所属季度
	 * @author Sunt.
	 * @time 2016年11月17日 下午2:38:39
	 * @return Long    返回类型 
	 * @throws
	 */
	public static Long getSeason(Date date) {
		
		Long season = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM");
			Long result = Long.parseLong(sdf.format(date));
			
			if (result >= 1 && result <= 3) {
				season = 1l;
			} else if (result >= 4 && result <= 6) {
				season = 2l;
			} else if (result >= 7 && result <= 9) {
				season = 3l;
			} else {
				season = 4l;
			}
		} catch (Exception e) {
			LogUtil.error(Object.class, e);
		}
		
		return season;
	}

	/**
	 * 
	 * @Title: isNumeric 
	 * @Description: 利用正则表达式判断字符串是否是数字
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:38:14
	 * @return boolean    返回类型 
	 * @throws
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @Title: charToByteAscii 
	 * @Description: 字符转换为Ascii
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:38:22
	 * @return byte    返回类型 
	 * @throws
	 */
	public static byte charToByteAscii(char ch) {
		byte byteAscii = (byte) ch;
		return byteAscii;
	}

	/**
	 * 
	 * @Title: byteAsciiToChar 
	 * @Description: ascii转换为字符
	 * @author Sunt.
	 * @time 2019年6月5日 上午10:38:34
	 * @return char    返回类型 
	 * @throws
	 */
	public static char byteAsciiToChar(int ascii) {
		char ch = (char) ascii;
		return ch;
	}
	
	/**
	 * 
	 * @Title: StringFilter 
	 * @Description: 过滤特殊字符
	 * @author Sunt.
	 * @time 2019年5月10日 下午4:04:09
	 * @return String    返回类型 
	 * @throws
	 */
	public static String StringFilter(String str) {
		if (isEmpty(str)) {
			return "";
		}
		// 清除掉所有特殊字符
		try {
			String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：\"”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			return m.replaceAll("").trim();
		} catch (Exception e) {
			LogUtil.error(Object.class, e);
		}
		return "";
	}
	/**
	 *  去掉集合中的重复元素
	 *
	 * @author ZhouXiaoGang
	 * @date 2019/6/12 0012 下午 4:38
	 * @param list
	 * @return java.util.List<java.lang.Integer>
	 */
	public static List<String> getRepeatList(List<String> list){
		HashSet<String> h = new HashSet<>(list);
		list.clear();
		list.addAll(h);
		return list;
	}
}