package com.sunlands.feo.demo.config;

import com.sunlands.feo.demo.user.SysUser;
import com.sunlands.feo.demo.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.config
 * @Description : 自定义userDetailService
 * @Author : chenlei
 * @Create Date : 2018年07月26日 17:18
 * ------------    --------------    ---------------------------------
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        SysUser user = sysUserService.findUserByName(userName);

        if (user == null) {

            throw new UsernameNotFoundException("UserName " + userName + " not found");

        }


        return user;
    }
}
