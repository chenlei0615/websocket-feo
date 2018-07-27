package com.sunlands.feo.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.rest
 * @Description : 用户接口
 * @Author : chenlei
 * @Create Date : 2018年07月27日 11:24
 * ------------    --------------    ---------------------------------
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
