package com.sunlands.feo.demo.entity;

import lombok.Data;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.entity
 * @Description : 服务器发往客户端消息实体
 * @Author : chenlei
 * @Create Date : 2018年07月31日 15:38
 * ------------    --------------    ---------------------------------
 */
@Data
public class WSResponse {

    private String responseMessage;

    public WSResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
