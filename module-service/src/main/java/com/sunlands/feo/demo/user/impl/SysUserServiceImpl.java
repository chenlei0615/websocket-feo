package com.sunlands.feo.demo.user.impl;

import com.sunlands.feo.demo.model.user.SysUser;
import com.sunlands.feo.demo.user.SysUserDao;
import com.sunlands.feo.demo.user.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.user.impl
 * @Description : 用户业务层
 * @Author : chenlei
 * @Create Date : 2018年07月26日 17:20
 * ------------    --------------    ---------------------------------
 */
@Service
@EnableCaching
public class SysUserServiceImpl implements SysUserService {
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 通过用户名查找
     * @param userName
     * @return
     */
    @Override
    public SysUser findUserByName(String userName){
        SysUser sysUser=sysUserDao.findByUserName(userName);
        return sysUser;
    }

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public List<SysUser> getUserList() {
        return sysUserDao.findAll();
    }

    /**
     *  通过id查找用户
     * @param id
     * @return
     */
    @Override
    @Cacheable(value="userInfo-", key="#id")
    public SysUser findUserById(String id) {
        return sysUserDao.findById(id).get();
    }

    /**
     * 用户保存
     * @param sysUser
     * @return
     */
    @Override
    public SysUser save(SysUser sysUser) {
        return sysUserDao.saveAndFlush(sysUser);
    }
    /**
     * 用户更新
     * @param sysUser
     * @return
     */
    @Override
    public SysUser edit(SysUser sysUser) {
        return sysUserDao.saveAndFlush(sysUser);
    }
    /**
     * 用户删除
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value="userInfo")
    public void delete(String id) {
         sysUserDao.deleteById(id);
    }


    @Override
    public void test(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));

    }


    @Override
    public SysUser getUser(String id) {
        System.out.println(id+"进入实现类获取数据！");
        SysUser user = new SysUser();
        user.setId(id);
        user.setUsername("香菇,难受");
        return user;
    }

    @Override
    public void deleteUser(String id) {
        System.out.println(id+"进入实现类删除数据！");
    }

}
