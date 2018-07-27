package com.sunlands.feo.demo.role.impl;

import com.sunlands.feo.demo.role.UserRole;
import com.sunlands.feo.demo.role.UserRoleRepository;
import com.sunlands.feo.demo.role.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.role.impl
 * @Description : 用户角色业务层
 * @Author : chenlei
 * @Create Date : 2018年07月27日 10:54
 * ------------    --------------    ---------------------------------
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findByUserId(String userId) {
        return userRoleRepository.findByUserId(userId);
    }
}
