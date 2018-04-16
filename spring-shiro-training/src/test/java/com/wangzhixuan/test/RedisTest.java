package com.wangzhixuan.test;

import redis.clients.jedis.Jedis;

/**
 * Created by liuyl on 2018/1/12.
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("120.79.4.109",6379);
        System.out.println(jedis.ping());
    }
}
