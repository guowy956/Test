package com.cn.exception;

/**
 * Created by newtouch on 2017/9/7.
 */
public class DBException extends RuntimeException {

    public  DBException(String msg){
        super(msg);
    }
}
