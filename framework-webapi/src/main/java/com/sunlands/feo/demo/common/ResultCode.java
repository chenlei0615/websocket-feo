package com.sunlands.feo.demo.common;

/**
 * @Project : websocket-feo
 * @Package Name : com.sunlands.feo.demo.common
 * @Description : 异常枚举类
 * @Author : chenlei
 * @Create Date : 2018年07月26日 18:25
 * ------------    --------------    ---------------------------------
 */
public enum ResultCode {

    SUCCESS(Result.SUCCESS,"成功")
    ,ERROR(Result.ERROR,"系统错误")

    ;

    private Integer code;
    private String msg;


    /**
     * 拿到Result对象
     * @return
     */
    public Result get(){
        return new Result().setCode(this.code).setMessage(this.msg);
    }

    ResultCode(Integer status,String msg){
        this.code = status;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
