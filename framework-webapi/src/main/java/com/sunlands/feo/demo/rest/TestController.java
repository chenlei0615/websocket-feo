package com.sunlands.feo.demo.rest;

import com.sunlands.feo.demo.model.user.SysUser;
import com.sunlands.feo.demo.user.SysUserService;
import com.sunlands.feo.demo.util.DateUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.rest
 * @Description : 测试接口
 * @Author : chenlei
 * @Create Date : 2018年07月26日 14:42
 * ------------    --------------    ---------------------------------
 */
@RestController
@RequestMapping("/open")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("获取当前时间")
    @GetMapping("/time")
    public String getDate(){
        Date date=DateUtil.getCurrentTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "当前时间："+sdf.format(date);
    }

    @ApiOperation("你好")
    @GetMapping("/hello")
    public String hello(){
        return "hello ：huayra";
    }

    @GetMapping("/test")
    public String test(){

        SysUser loaded = sysUserService.findUserById("8a77c2f764db70720164db70da9a0000");

        System.out.println("loaded="+loaded);

        SysUser cached = sysUserService.findUserById("8a77c2f764db70720164db70da9a0000");

        System.out.println("cached="+cached);

        loaded =sysUserService.findUserById("8a77c2f764db70720164db71a75e0001");

        System.out.println("loaded2="+loaded);

        return"ok";

    }

    @PutMapping("/test1")
    public@ResponseBody String test1(){

        sysUserService.test();

        System.out.println("DemoInfoController.test1()");

        return"ok";

    }
}
