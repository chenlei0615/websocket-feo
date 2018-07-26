package com.sunlands.feo.demo.user;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.role
 * @Description : 用户业务接口
 * @Author : chenlei
 * @Create Date : 2018年07月26日 17:20
 * ------------    --------------    ---------------------------------
 */
public interface SysUserService {
    public SysUser findUserByName(String userName);
}
