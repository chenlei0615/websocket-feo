package com.sunlands.feo.demo.user.impl;

import com.sunlands.feo.demo.model.user.SysUser;
import com.sunlands.feo.demo.user.SysUserDao;
import com.sunlands.feo.demo.user.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SysUserServiceImpl implements SysUserService {
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

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
    public SysUser findUserById(String id) {
        return sysUserDao.findOne(id);
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
    public void delete(String id) {
         sysUserDao.delete(id);
    }
}
