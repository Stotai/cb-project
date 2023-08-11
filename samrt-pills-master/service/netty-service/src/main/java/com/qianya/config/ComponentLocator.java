package com.qianya.config;

import com.qianya.config.redis.RedisFacade;
import com.qianya.config.redis.impl.RedisFacadeImpl;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 组件定位器
 */
@Component
public class ComponentLocator implements ApplicationContextAware {

    private static RedisFacade redisFacade;
    private static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> clz) {
        return applicationContext.getBean(clz);
    }


    public static RedisFacade getRedis() {
        if (redisFacade == null) {
            redisFacade = getBean(RedisFacadeImpl.class);
        }
        return redisFacade;
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        ComponentLocator.applicationContext = applicationContext;
    }

}
