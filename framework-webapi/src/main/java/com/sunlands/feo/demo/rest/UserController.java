package com.sunlands.feo.demo.rest;

import com.sunlands.feo.demo.user.SysUser;
import com.sunlands.feo.demo.user.SysUserService;
import com.sunlands.feo.demo.util.MD5Util;
import com.sunlands.feo.demo.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.rest
 * @Description : 用户接口
 * @Author : chenlei
 * @Create Date : 2018年07月27日 11:24
 * ------------    --------------    ---------------------------------
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        WebUtils.logRequestParams(request);
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model,HttpServletRequest request) {
        WebUtils.logRequestParams(request);
        List<SysUser> users = sysUserService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("username") String name,
                      @RequestParam("password") String pass,
                      HttpServletRequest request) {
        WebUtils.logRequestParams(request);
        SysUser user = new SysUser();
        user.setUserName(name);
        user.setPassword(MD5Util.encode(pass));
        sysUserService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, String id,
                         HttpServletRequest request) {
        WebUtils.logRequestParams(request);
        SysUser user = sysUserService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(SysUser user) {
        sysUserService.edit(user);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        sysUserService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/403")
    public String error(){
        return "403";
    }
}
