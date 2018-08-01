package com.sunlands.feo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.config
 * @Description : WebSocketConfig
 * @Author : chenlei
 * @Create Date : 2018年07月30日 16:10
 * ------------    --------------    ---------------------------------
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 这个方法的作用是添加一个服务端点，来接收客户端的连接
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //表示添加了一个websocket端点，客户端就可以通过这个端点来进行连接,withSockJS()的作用是开启SockJS支持
        registry.addEndpoint("/socket")
               // .setAllowedOrigins("*")//添加允许跨域访问
                .withSockJS();
    }

    /**
     * 定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        /**表示客户端订阅地址的前缀信息，也就是客户端 接收 服务端消息的地址的前缀信息
         * topic 代表发布广播，即群发
         * queue代表点对点，即发指定用户
         * */
        config.enableSimpleBroker("/topic");
        /**指服务端接收地址的前缀，就是说客户端给服务端 发送 消息的地址的前缀*/
        config.setApplicationDestinationPrefixes("/app");
      //  config.setUserDestinationPrefix("/user");//推送用户前缀，不设置，默认也是/user
    }


}
