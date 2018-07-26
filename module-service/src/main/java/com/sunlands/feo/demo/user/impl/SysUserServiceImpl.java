package com.sunlands.feo.demo.user.impl;

import com.sunlands.feo.demo.user.SysUser;
import com.sunlands.feo.demo.user.SysUserDao;
import com.sunlands.feo.demo.user.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public SysUser findUserByName(String userName){
        SysUser sysUser=sysUserDao.findByUserName(userName);
        return sysUser;
    }
}
