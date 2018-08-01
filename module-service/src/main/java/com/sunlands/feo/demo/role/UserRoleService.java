package com.sunlands.feo.demo.role;

import com.sunlands.feo.demo.model.role.UserRole;

import java.util.List;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.role
 * @Description : 用户角色接口
 * @Author : chenlei
 * @Create Date : 2018年07月27日 10:53
 * ------------    --------------    ---------------------------------
 */
public interface UserRoleService {
    List<UserRole> findByUserId(String userId);
}
