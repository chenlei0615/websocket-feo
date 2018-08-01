package com.sunlands.feo.demo.user;

import com.sunlands.feo.demo.model.user.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.user
 * @Description : 用户持久层
 * @Author : chenlei
 * @Create Date : 2018年07月26日 17:28
 * ------------    --------------    ---------------------------------
 */
public interface SysUserDao extends JpaRepository<SysUser,String> {

    @Query(value = "select * from sys_user where user_name =?1 ",nativeQuery = true)
    SysUser findByUserName(String userName);
}
