package com.qianya.annotations;

import com.qianya.config.offline.OfflineNacos;
import com.qianya.config.offline.OfflineNacosAndMQ;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import java.lang.annotation.*;

/**
 * @description 开启下线处理
 * @author Sunt.
 * @since 2022-01-20 11:55
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ImportAutoConfiguration({
	OfflineNacos.class,
	OfflineNacosAndMQ.class
})
public @interface EnableOffline {}