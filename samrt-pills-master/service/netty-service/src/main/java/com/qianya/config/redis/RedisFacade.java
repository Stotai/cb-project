package com.qianya.config.redis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis调用封装
 */
public interface RedisFacade {

    /**
     * 尝试加锁
     *
     * @param key 加锁使用的key
     * @return true:加锁成功  false:加锁失败
     */
    boolean lock(String key);

    /**
     * 设置缓存
     *
     * @param key     缓存key
     * @param value   缓存结果值
     * @param timeout 缓存有效期 单位s
     */
    void set(String key, String value, long timeout);

    /**
     * 设置缓存
     *
     * @param key     缓存key
     * @param value   缓存结果值
     * @param timeout 缓存有效期
     * @param unit    缓存有效期时间的时间单位（参考TimeUnit）
     */
    void set(String key, String value, long timeout, TimeUnit unit);

    /**
     * 获取缓存值
     *
     * @param key 缓存key
     * @return 缓存值
     */
    String get(String key);

    /**
     * 获取缓存值
     *
     * @param key 缓存key
     * @return 缓存值
     */
    Set<String> keys(String key);

    /**
     * 删除缓存
     *
     * @param key 缓存的key
     */
    void del(String key);


}
