package com.qianya.config.redis.impl;

import com.qianya.config.redis.RedisFacade;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis调用实现
 * 移除了第一版在各个方法里统一加前缀的代码-因为这种方式比较重，在做一些特殊技术方案的时候会有坑
 * 1.那么还要不要加key的前缀？
 * 要加的，因为如果不加前缀，测试和预发用一个redis,则key一样，预发有bug,会“污染线上数据”，导致线上BUG
 * 2.如何加前缀？
 * 不要在这个类的方法里统一加，而是在开发代码时根据自己的需要有意识的加前缀
 */
@Component(value = "redisFacade")
public class RedisFacadeImpl implements RedisFacade {

    private static final String DEFAULT_LOCK_VALUE = "1";
    private static final long DEFAULT_LOCK_TIME = 3L;
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public boolean lock(String key) {
        Boolean b = stringRedisTemplate.opsForValue()
                .setIfAbsent(key, DEFAULT_LOCK_VALUE, DEFAULT_LOCK_TIME, TimeUnit.SECONDS);
        return b != null && b;
    }

    @Override
    public void set(String key, String value, long timeout) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, unit);
    }



    @Override
    public String get(String key) {
        Object o = stringRedisTemplate.opsForValue().get(key);
        if (o == null) {
            return null;
        }
        return o.toString();
    }

    /**
     * 获取缓存值
     *
     * @param key 缓存key
     * @return 缓存值
     */
    public Set<String> keys(String key){
        Set<String> keys = stringRedisTemplate.keys(key + "*");
        return keys;
    }

    @Override
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

}


