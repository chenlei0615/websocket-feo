package com.simple.feo.demo.cache;

/**
 * @Project : simple-feo
 * @Package Name : com.simple.feo.demo.cache
 * @Description : 自定义事务异常
 * @Author : chenlei
 * @Create Date : 2019年01月25日 17:39
 * ------------    --------------    ---------------------------------
 */
public class TransactionExecFailedException extends Exception {

    public TransactionExecFailedException(){}
    public TransactionExecFailedException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = 1L;
}
