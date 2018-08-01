package com.sunlands.feo.demo.user;

import com.sunlands.feo.demo.model.user.SysUser;

import java.util.List;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.role
 * @Description : 用户业务接口
 * @Author : chenlei
 * @Create Date : 2018年07月26日 17:20
 * ------------    --------------    ---------------------------------
 */
public interface SysUserService {
    /**
     * 通过用户名查找
     * @param userName
     * @return
     */
     SysUser findUserByName(String userName);

    /**
     * 获取所有用户
     * @return
     */
    List<SysUser> getUserList();

    /**
     *  通过id查找用户
     * @param id
     * @return
     */
    SysUser findUserById(String id);

    /**
     * 用户保存
     * @param sysUser
     * @return
     */
    SysUser save(SysUser sysUser);

    /**
     * 用户更新
     * @param sysUser
     * @return
     */
    SysUser edit(SysUser sysUser);

    /**
     * 用户删除
     * @param id
     * @return
     */
    void delete(String id);

}
