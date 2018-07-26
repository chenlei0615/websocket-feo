package com.sunlands.feo.demo.common;

import java.io.Serializable;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.common
 * @Description : result
 * @Author : chenlei
 * @Create Date : 2018年07月26日 18:27
 * ------------    --------------    ---------------------------------
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int SUCCESS = 200;

    public static final int ERROR = 500;

    /**
     * 状态
     */
    public Integer code;

    /**
     * 数据
     */
    public Object data;

    /**
     * 消息
     */
    public String message;

    private void assertNotNull(){
        if(code == null){
            throw new RuntimeException("code can not be null");
        }
    }


    public Result setData(Object data) {
        this.data = data;
        return this;
    }
    public Integer getCode() {
        return code;
    }
    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }
    public String getMessage() {
        return message;
    }
    public Result setMessage(String message) {
        this.message = message;
        return this;
    }
}
