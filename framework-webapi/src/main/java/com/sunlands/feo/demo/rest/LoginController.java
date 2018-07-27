package com.sunlands.feo.demo.rest;

import com.sunlands.feo.demo.rest.vo.MessageVo;
import com.sunlands.feo.demo.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.rest
 * @Description : 登陆
 * @Author : chenlei
 * @Create Date : 2018年07月26日 18:03
 * ------------    --------------    ---------------------------------
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/")
    public String index(Model model, HttpServletRequest request) {
        WebUtils.logRequestParams(request);
        MessageVo msg = new MessageVo("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }


}
