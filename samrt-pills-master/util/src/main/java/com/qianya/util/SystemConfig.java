package com.qianya.util;
import java.io.File;
import java.util.regex.Matcher;
/**
 * @Author lhl
 * @Date 2020年7月17日
 * @DES 系统常量配置
 */
public class SystemConfig {
	/**
	 * @desc 系统路径
	 * @author lhl
	 * @date 2020-07-17 11:28
	 * @return
	*/
	public static String filePath() {
		StringBuilder sb = new StringBuilder("");
		if (isLinux()){
			sb.append(File.separator).append("home").append(File.separator).append("jar");
		}else {
			sb.append(System.getProperty("user.dir"));
		}
		if(!sb.toString().endsWith(Matcher.quoteReplacement(File.pathSeparator))){ //如果不是/结尾的话加上/
			sb.append(File.separator);
		}
		return sb.append("qytech").append(File.separator).toString();
	}
	public static boolean isLinux(){
		String osName = System.getProperties().getProperty("os.name");
		if(osName.equals("Linux"))
		{
			return true;
		}
		return  false;
	}
}
