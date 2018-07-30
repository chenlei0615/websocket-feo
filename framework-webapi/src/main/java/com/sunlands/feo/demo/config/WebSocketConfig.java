package com.sunlands.feo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.config
 * @Description : WebSocketConfig
 * @Author : chenlei
 * @Create Date : 2018年07月30日 16:10
 * ------------    --------------    ---------------------------------
 */
public class WebSocketConfig {
    /**
     * 首先要注入ServerEndpointExporter，
     * 这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint。要注意，如果使用独立的servlet容器，
     * 而不是直接使用springboot的内置容器，就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
