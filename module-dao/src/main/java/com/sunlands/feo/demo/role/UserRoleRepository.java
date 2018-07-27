package com.sunlands.feo.demo.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.role
 * @Description : 用户角色持久层
 * @Author : chenlei
 * @Create Date : 2018年07月27日 10:57
 * ------------    --------------    ---------------------------------
 */
public interface UserRoleRepository extends JpaRepository<UserRole,String> {
    @Query(value = "select * from user_role where id in(select role_id from sys_user_role where user_id=?1)  ",nativeQuery = true)
    List<UserRole> findByUserId(String userId);

}
