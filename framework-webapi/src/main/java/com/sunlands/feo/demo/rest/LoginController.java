package com.sunlands.feo.demo.rest;

import com.sunlands.feo.demo.rest.vo.MessageVo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.rest
 * @Description : 登陆
 * @Author : chenlei
 * @Create Date : 2018年07月26日 18:03
 * ------------    --------------    ---------------------------------
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/index")
    public String index(Model model) {
        MessageVo msg = new MessageVo("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
}
