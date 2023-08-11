package com.qianya.util;

import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.io.IOException;
import java.util.*;

/**
 * @description redis相关操作工具类
 * @author lhl
 * @since 2022-02-21 12:24
 */
public class RedisUtils {

    /**
     * @description 获取匹配到的redis中key的信息，默认为集群模式
     * @param pattern 匹配的key字符串，不包括*号
     * @return java.util.Set<java.lang.String>
     * @author lhl.
     * @since 2022-02-22 15:00
     */
    public static Set<String> scan(RedisTemplate<String, Object> redisTemplate, String pattern) {
        return scanCluster(redisTemplate, pattern);
    }

    /**
     * @description 扫描单节点下匹配的key信息
     * @param pattern 待匹配值
     * @return java.util.Set<java.lang.String>
     * @author lhl.
     * @since 2022-02-22 14:58
     */
    public static Set<String> scanSingle(RedisTemplate<String, Object> redisTemplate, String pattern) {

        if (redisTemplate == null) {
            throw new RuntimeException("redisTemplate不能为空");
        }

        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();

        if (connectionFactory == null) {
            throw new RuntimeException("redis connectionFactory获取失败");
        }

        ScanOptions options = ScanOptions.scanOptions()
                .count(1000) //指定每次扫描key的数量
                .match(pattern) //需要匹配的key
                .build();
        Set<String> keys = new HashSet<>();

        Cursor<byte[]> cursor = connectionFactory.getConnection().scan(options);
        while(cursor.hasNext()){
            keys.add(new String(cursor.next()));
        }

        try {
            cursor.close();
        } catch (IOException e) {
            LogUtil.error(RedisUtils.class, "关闭单节点redis游标失败", e);
        }

        cursor = null;
        redisTemplate = null;
        pattern = null;
        connectionFactory = null;
        options = null;

        return keys;
    }
    /**
     *  
     * @author lhl 
     * @date 2022-06-17 下午 02:37
     * @param matchKey
     */
    public static Set<String> scanMatch(RedisTemplate<String, Object> redisTemplate,String matchKey) {
        Set<String> keys = new HashSet();
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection redisConnection = connectionFactory.getConnection();
        Cursor<byte[]> scan = null;
        if(redisConnection instanceof JedisClusterConnection){
            RedisClusterConnection clusterConnection = connectionFactory.getClusterConnection();
            Iterable<RedisClusterNode> redisClusterNodes = clusterConnection.clusterGetNodes();
            Iterator<RedisClusterNode> iterator = redisClusterNodes.iterator();
            while (iterator.hasNext()) {
                RedisClusterNode next = iterator.next();
                scan = clusterConnection.scan(next, ScanOptions.scanOptions().match(matchKey).count(Integer.MAX_VALUE).build());
                while (scan.hasNext()) {
                    keys.add(new String(scan.next()));
                }
                try {
                    if(scan !=null){
                        scan.close();
                    }
                } catch (IOException e) {
                    LogUtil.error(RedisUtils.class,"scan遍历key关闭游标异常",e);
                }
            }
            return keys;
        }
        if(redisConnection instanceof JedisConnection){
            scan = redisConnection.scan(ScanOptions.scanOptions().match(matchKey).count(Integer.MAX_VALUE).build());
            while (scan.hasNext()){
                //找到一次就添加一次
                keys.add(new String(scan.next()));
            }
            try {
                if(scan !=null){
                    scan.close();
                }
            } catch (IOException e) {
                LogUtil.error(RedisUtils.class,"scan遍历key关闭游标异常",e);
            }
            return keys;
        }

        return keys;

    }
    /**
     * 模糊判断key在redis是否存在
     * @author lhl
     * @date 2022-06-17 下午 02:37
     * @param matchKey
     */
    public static Map<String,Boolean> scanMatchIsExist(RedisTemplate<String, Object> redisTemplate,Set<String> matchKey) {
        Map<String,Boolean> flagMap=new HashMap<>();
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection redisConnection = connectionFactory.getConnection();
        Cursor<byte[]> scan = null;
        if (redisConnection instanceof JedisConnection) {
            for (String str : matchKey) {
                scan = redisConnection.scan(ScanOptions.scanOptions().match(str).count(1).build());
                if (scan.hasNext()) {
                    //找到一次就添加一次
                    flagMap.put(str, true);
                } else {
                    flagMap.put(str, false);
                }
            }
            try {
                if (scan != null) {
                    scan.close();
                }
            } catch (IOException e) {
                LogUtil.error(RedisUtils.class, "scan遍历key关闭游标异常", e);
            }
            return flagMap;
        }
        return flagMap;
    }
    /**
     * @description 扫描集群下匹配的key信息
     * @param pattern 待匹配值
     * @return java.util.Set<java.lang.String>
     * @author lhl.
     * @since 2022-02-22 14:58
     */
    public static Set<String> scanCluster(RedisTemplate<String, Object> redisTemplate, String pattern) {

        if (redisTemplate == null) {
            throw new RuntimeException("redisTemplate不能为空");
        }
        JedisConnectionFactory connectionFactory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();

        if (connectionFactory == null) {
            throw new RuntimeException("redis connectionFactory获取失败");
        }

        Set<String> keys = new HashSet<>();
        ScanParams scanParams = new ScanParams().match(pattern).count(1000);
        Map<String, JedisPool> nodes = ((JedisClusterConnection) connectionFactory.getClusterConnection()).getNativeConnection().getClusterNodes();

        if (nodes == null || nodes.isEmpty()) {
            throw new RuntimeException("未获取到redis集群节点");
        }

        for (Map.Entry<String, JedisPool> entry : nodes.entrySet()) {

            String cursor = ScanParams.SCAN_POINTER_START;
            Jedis jedis = entry.getValue().getResource();

            if (jedis.info("Replication").contains("role:master")) {
                do {
                    ScanResult<String> scanResult = jedis.scan(cursor, scanParams);

                    cursor = scanResult.getCursor();
                    List<String> list = scanResult.getResult();

                    if (!list.isEmpty()) {
                        keys.addAll(list);
                    }

                } while (!ScanParams.SCAN_POINTER_START.equals(cursor));
            }

            jedis.close();
            cursor = null;
        }

        redisTemplate = null;
        pattern = null;
        connectionFactory = null;
        scanParams = null;
        nodes = null;

        return keys;
    }
}
