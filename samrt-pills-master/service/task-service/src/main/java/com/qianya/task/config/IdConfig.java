package com.qianya.task.config;

import com.qianya.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @Title: IdConfig.java
 * @Description: 推特雪花算法
 * @Copyright: Copyright (c) 2018
 * @author: Sunt.
 * @date: 2018年9月10日下午1:21:26
 * @version: 1.0
 */
@Configuration
public class IdConfig {

	@Bean
	public IdWorker feignEncoder() {
		return new IdWorker(0, 4, 5);
	}
}