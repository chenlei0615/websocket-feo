package com.simple.feo.demo;

import com.simple.feo.demo.cache.RedisCacheService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@ComponentScan({"com.simple.feo.demo.cache"})
public class DemoApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作 k-v 字符串

    @Autowired
    private RedisCacheService redisCacheService;


    @Test
    public void test1() {
        stringRedisTemplate.opsForValue().set("StringKey", "字符串数值");
        String value = stringRedisTemplate.opsForValue().get("StringKey");
        Assert.assertNotNull(value);
        Assert.assertEquals(value,"字符串数值");
    }



}

