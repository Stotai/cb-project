package com.qianya.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @Title: RedisConfig.java
 * @Description: Redis配置
 * @Copyright: Copyright (c) 2018
 * @author: Sunt.
 * @date: 2018年8月18日上午10:30:27
 * @version: 1.0
 */
@Configuration
public class RedisConfig {

	/** redis账号配置 start**/
	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.password}")
	private String password;
	/** redis账号配置 end**/
	
	/** redis连接池 start**/
	@Value("${spring.redis.jedis.pool.max-active}")
	private Integer maxActive;
	
	@Value("${spring.redis.jedis.pool.max-idle}")
	private Integer maxIdle;

	@Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;

	@Value("${spring.redis.jedis.pool.max-wait}")
    private Integer maxWait;
	
//	@Value("${spring.redis.jedis.pool.test-on-create}")
//	private Boolean testOnCreate;
//
//	@Value("${spring.redis.jedis.pool.test-on-borrow}")
//    private Boolean testOnBorrow;//在获取连接的时候检查有效性
//
//	@Value("${spring.redis.jedis.pool.test-on-return}")
//    private Boolean testOnReturn;//当调用return Object方法时，是否进行有效性检查
//
//	@Value("${spring.redis.jedis.pool.test-while-idle}")
//    private Boolean testWhileIdle;//在空闲时检查有效性
	/** redis连接池 end**/
	
	/**
	 * 
	 * @Title: jedisPoolConfig 
	 * @Description: redis连接池配置
	 * @author Sunt.
	 * @time 2018年10月9日 下午2:11:12
	 * @return JedisPoolConfig    返回类型 
	 * @throws
	 */
	@Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
       // jedisPoolConfig.setTestOnCreate(testOnCreate);
       // jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        //jedisPoolConfig.setTestOnReturn(testOnReturn);
       // jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        return jedisPoolConfig;
    }
	
	/**
	 * 
	 * @Title: getRedisConnectionFactory 
	 * @Description: 获取redis连接工厂
	 * @author Sunt.
	 * @time 2018年8月7日 下午7:49:46
	 * @return RedisConnectionFactory    返回类型 
	 * @throws
	 */
	@Bean("redisConnectionFactory")
	@SuppressWarnings("deprecation")
	public RedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setTimeout(timeout);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
		return jedisConnectionFactory;
	}
	
	/**
	 * 
	 * @Title: redisTemplate 
	 * @Description: 获取redisTemplate模板对象
	 * @author Sunt.
	 * @time 2018年8月18日 上午10:32:56
	 * @return RedisTemplate<String,Object>    返回类型 
	 * @throws
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		// 创建redis模板
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		// 设置模板操作的redis数据库
		template.setConnectionFactory(redisConnectionFactory());
		// 设置模板对redis中key的序列化器
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		// 初始化连接pool
		template.afterPropertiesSet();
		return template;
	}
}