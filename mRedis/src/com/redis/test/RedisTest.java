package com.redis.test;


/**
 * @author liuyl 2017/07/19
 *
 */
public class RedisTest {
    public static void main(String args[]){
        //JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //JedisPool jedisPool = new JedisPool("47.93.42.101",6379);
        Jedis jedis = new Jedis();
        Jedis jedis1 = new Jedis("47.93.42.101",6379);
        //jedis1.auth("root");
        jedis1.set("name","liuyl");
        //System.out.println(jedis.ping());
        System.out.println(jedis1.get("name"));
    }
}

