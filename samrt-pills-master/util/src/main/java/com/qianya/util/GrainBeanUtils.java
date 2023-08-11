package com.qianya.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * 
 * @Title: AioBeanUtils.java
 * @Description: 类型转换工具类
 * @Copyright: Copyright (c) 2018
 * @author: Sunt.
 * @date: 2019年9月3日上午10:01:28
 * @version: 1.0
 */
public class GrainBeanUtils {

	/**
	 * 
	 * @Title: convert 
	 * @Description: 单个类型转换
	 * @author Sunt.
	 * @time 2019年9月3日 上午11:15:39
	 * @return T    返回类型 
	 * @throws
	 */
	public static <T> T convert(Object source, Class<T> target) {
		if (source == null) {
			return null;
		}
		if (target == null) {
			return null;
		}
		try {
			T newInstance = target.newInstance();
			org.springframework.beans.BeanUtils.copyProperties(source, newInstance);
			return newInstance;
		} catch (Exception e) {
			LogUtil.error(GrainBeanUtils.class, e);
			return null;
		} finally {
			source = null;
		}
	}

	/**
	 *
	 * @Title: convertList
	 * @Description: 集合类型转换
	 * @author Sunt.
	 * @time 2019年9月3日 上午11:15:40
	 * @return T    返回类型
	 * @throws
	 */
	public static <T> List<T> convertList(List<?> source, Class<T> target) {
		return convertList(source, target, null);
	}
	
	/**
	 * 
	 * @Title: convertList 
	 * @Description: 转换时处理转换后的对象
	 * @author Sunt.
	 * @time 2020年2月22日 上午12:20:51
	 * @return List<T>    返回类型 
	 * @throws
	 */
	public static <T> List<T> convertList(List<?> source, Class<T> target, BeanFunction<T> function) {
		if (source == null) {
			return null;
		}
		if (target == null) {
			return null;
		}
		if (source.size() == 0) {
			return Collections.emptyList();
		}
		try {
			List<T> result = new ArrayList<>();
			for (Object obj : source) {
				T newInstance = target.newInstance();
				org.springframework.beans.BeanUtils.copyProperties(obj, newInstance);
				if (function != null) {
					function.invok(newInstance);
				}
				result.add(newInstance);
			}
			return result;
		} catch (Exception e) {
			LogUtil.error(GrainBeanUtils.class, e);
			return null;
		} finally {
			source = null;
		}
	}
	
	public static <N, O> List<N> convertLists(List<O> source, Class<N> target, BeanFunctions<N, O> function) {
		if (source == null) {
			return null;
		}
		if (target == null) {
			return null;
		}
		if (source.size() == 0) {
			return Collections.emptyList();
		}
		try {
			List<N> result = new ArrayList<>();
			for (O obj : source) {
				N newInstance = target.newInstance();
				org.springframework.beans.BeanUtils.copyProperties(obj, newInstance);
				function.invok(newInstance, obj);
				result.add(newInstance);
			}
			return result;
		} catch (Exception e) {
			LogUtil.error(GrainBeanUtils.class, e);
			return null;
		} finally {
			source = null;
		}
	}
	
	public interface BeanFunction<T> {
		public void invok(T obj);
	}
	
	public interface BeanFunctions<N, O> {
		public void invok(N n, O o);
	}
}