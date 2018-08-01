package com.sunlands.feo.demo.rest;

import com.sunlands.feo.demo.common.BaseResponse;
import com.sunlands.feo.demo.common.ResultCode;
import com.sunlands.feo.demo.entity.WSMessage;
import com.sunlands.feo.demo.entity.WSResponse;
import com.sunlands.feo.demo.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.rest
 * @Description :  消息推送(个人和广播)
 * @Author : chenlei
 * @Create Date : 2018年07月30日 16:09
 * ------------    --------------    ---------------------------------
 */
@Controller
@RequestMapping("/ws")
public class WebSocketController {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        WebUtils.logRequestParams(request);
        return "websocket/ws";
    }

    @MessageMapping("welcome")//1
    @SendTo("/topic/getResponse")//2
    public BaseResponse<WSResponse> say(WSMessage message) throws Exception {
        WSResponse wsResponse=new WSResponse("Welcome, " + message.getName() + "!");
        return new BaseResponse(ResultCode.SUCCESS,wsResponse);
    }


    /**
     * 这个方法是接收客户端发送功公告的WebSocket请求
     * @param value
     */
    @MessageMapping("/change-notice")
    public void greeting(String value){
        /**将给定的对象进行序列化，使用‘MessageConverter’进行包装转化成一条消息，发送到指定的目标*/
        this.simpMessagingTemplate.convertAndSend("/topic/notice", value);
    }

    /**
     * 功能同上
     * 当浏览器向服务端发送请求时,通过@MessageMapping映射/change-notice1这个地址,类似于@ResponseMapping
     * @param value
     * @return
     */
    @MessageMapping("/change-notice1")
    @SendTo("/topic/notice")  //当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
    public String greeting1(String value) {
        return value;
    }

    /**
     * 当有客户端订阅"/topic/getResponse"，会收到消息
     * @return
     */
    @SubscribeMapping("/topic/notice")
    public BaseResponse<WSResponse> sub(HttpServletRequest request) {
        WebUtils.logRequestParams(request);
        WSResponse wsResponse=new WSResponse("感谢你订阅了我。。。");
        logger.info("XXX用户订阅了我。。。");
        return new BaseResponse(ResultCode.SUCCESS,wsResponse);
    }
}
