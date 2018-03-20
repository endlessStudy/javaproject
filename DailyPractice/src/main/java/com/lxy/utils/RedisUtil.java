package com.lxy.utils;

import java.util.ResourceBundle;

/**
 * Created by liuyl on 2017/11/21.
 */
public class RedisUtil {
        private static ResourceBundle bundle = ResourceBundle.getBundle("props.redis");

        public static String getConfigKey(String key) {
            return bundle.getString(key);
        }

        public static void initRedisPool(){
            String maxAcive = RedisUtil.getConfigKey("redis.pool.maxActive");
            String maxIdle = RedisUtil.getConfigKey("redis.pool.maxIdle");
            String maxWait = RedisUtil.getConfigKey("redis.pool.maxWait");
            String port = RedisUtil.getConfigKey("redis.port");
            String testOnBorrow = RedisUtil.getConfigKey("redis.pool.testOnBorrow");
            String timeout = RedisUtil.getConfigKey("redis.timeout");
            String IP = RedisUtil.getConfigKey("redis.ip");
            /** Redis服务器密码 */
            String AUTH = RedisUtil.getConfigKey("redis.password");
            //设置redis的连接池
            CacheManagerClient.initRedisPool(IP, port, AUTH, timeout, maxAcive, maxIdle, maxWait, Boolean.valueOf(testOnBorrow));
        }
}
