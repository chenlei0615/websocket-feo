package com.sunlands.feo.demo.rest.vo;

import lombok.Data;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.rest.vo
 * @Description : MessageVo
 * @Author : chenlei
 * @Create Date : 2018年07月27日 12:23
 * ------------    --------------    ---------------------------------
 */
@Data
public class MessageVo {
    private String title;
    private String content;
    private String extraInfo;

    public MessageVo(){

    }

    public MessageVo(String title, String content, String extraInfo) {
        this.title = title;
        this.content = content;
        this.extraInfo = extraInfo;
    }
}
