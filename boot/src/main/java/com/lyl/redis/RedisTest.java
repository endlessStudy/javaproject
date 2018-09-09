package com.lyl.redis;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyl on 2018/3/20.
 */
@RestController
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/redis")
    public void test(){
        redisTemplate.opsForValue().set("age","eight");
        stringRedisTemplate.opsForValue().set("name","lyl");
        Assert.assertEquals("lyl",stringRedisTemplate.opsForValue().get("name"));
    }
}
