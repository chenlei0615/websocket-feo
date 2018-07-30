package com.sunlands.feo.demo.rest;

import com.sunlands.feo.demo.websocket.WebSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.rest
 * @Description :  消息推送(个人和广播)
 * @Author : chenlei
 * @Create Date : 2018年07月30日 16:09
 * ------------    --------------    ---------------------------------
 */
@Controller
@RequestMapping("websocket")
public class WebSocketController {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    private WebSocketService webSocketService;

    @RequestMapping(value = "/index")
    public String idnex() {

        return "index";
    }

    @RequestMapping(value = "/admin")
    public String admin(Model model) {
        int num = webSocketService.getOnlineNum();
        String str = webSocketService.getOnlineUsers();
        List<String> list = null;
        if (str.length() > 2) {
            str = str.substring(0,str.length()-1);
            String [] strs = str.split(",");
            list =  Arrays.asList(strs);
        }


        model.addAttribute("num",num);
        model.addAttribute("users",list);
        return "admin";
    }

    /**
     * 个人信息推送
     * @return
     */
    @RequestMapping("sendmsg")
    @ResponseBody
    public String sendmsg(String msg, String username){
        //第一个参数 :msg 发送的信息内容
        //第二个参数为用户长连接传的用户人数
        String [] persons = username.split(",");
        webSocketService.SendMany(msg,persons);
        return "success";
    }

    /**
     * 推送给所有在线用户
     * @return
     */
    @RequestMapping("sendAll")
    @ResponseBody
    public String sendAll(String msg){
        webSocketService.sendAll(msg);
        return "success";
    }

    /**
     * 获取当前在线用户
     * @return
     */
    @RequestMapping("webstatus")
    public String webstatus(){
        //当前用户个数
        int count = webSocketService.getOnlineNum();
        //当前用户的username
        webSocketService.getOnlineUsers();
        return "tongji";
    }
}
