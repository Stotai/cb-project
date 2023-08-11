package com.qianya.config.offline;

import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import com.qianya.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NacosConfig implements ApplicationRunner {

	@Autowired(required = false)
	private NacosAutoServiceRegistration registration;

	@Override
	public void run(ApplicationArguments args) {
		if (registration != null) {
			if (!registration.isRunning()) {
				registration.start();
			}
		}
		LogUtil.info(getClass(), "服务启动完成");
	}
}