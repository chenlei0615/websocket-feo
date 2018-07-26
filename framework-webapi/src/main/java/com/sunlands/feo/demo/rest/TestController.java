package com.sunlands.feo.demo.rest;

import com.sunlands.feo.demo.util.CommonMethod;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @ApiOperation("获取当前时间")
    @GetMapping("/time")
    public String getDate(){
        Date date=CommonMethod.getCurDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "当前时间："+sdf.format(date);
    }
}
