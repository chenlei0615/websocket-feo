package com.sunlands.feo.demo.service;

import com.sunlands.feo.demo.model.user.SysUser;
import com.sunlands.feo.demo.user.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Project : simple-feo
 * @Package Name : com.sunlands.feo.demo.service
 * @Description : TODO
 * @Author : chenlei
 * @Create Date : 2019年02月12日 16:32
 * ------------    --------------    ---------------------------------
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class RedisTest {


    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private SysUserService userService;

    @Test
    public void getUser() {
        for (int i = 0; i < 10; i++) {
            SysUser user = userService.getUser(String.valueOf(i));
            System.out.println(user);
        }

    }
}
