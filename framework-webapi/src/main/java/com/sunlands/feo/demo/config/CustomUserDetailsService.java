package com.sunlands.feo.demo.config;

import com.sunlands.feo.demo.role.UserRole;
import com.sunlands.feo.demo.role.UserRoleService;
import com.sunlands.feo.demo.user.SysUser;
import com.sunlands.feo.demo.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.config
 * @Description : 自定义userDetailService
 * @Author : chenlei
 * @Create Date : 2018年07月26日 17:18
 * ------------    --------------    ---------------------------------
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SysUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        SysUser user = sysUserService.findUserByName(userName);

        if (user == null) {

            throw new UsernameNotFoundException("UserName " + userName + " not found");

        }

        List<UserRole> roleList=userRoleService.findByUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        if(roleList!=null && roleList.size()>0) {
            roleList.forEach(r->grantedAuthorities.add(new SimpleGrantedAuthority(r.getRoleName())));
        }
        return user;
    }
}
