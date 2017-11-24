package com.liuyl.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by liuyl on 2017/11/21.
 */
public class RedisUtils {
    private static JedisPoolConfig jedisPoolConfig;
    private static JedisPool jedisPool;
    public static void initialPool(){
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxActive(20);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxWait(1000L);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPool = new JedisPool(jedisPoolConfig,"47.93.42.101",6379);
    }

    public static void main(String[] args) {
        RedisUtils.initialPool();
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.ping());
    }
}
