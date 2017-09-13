package com.cn.exception;


import org.springframework.http.HttpStatus;

/**
 * Created by newtouch on 2017/8/23.
 */
public class BusinessException extends  RuntimeException{

    private int  code = HttpStatus.INTERNAL_SERVER_ERROR.value();

    private  String source;

    public String getSource(){
        return source;
    }

    public String setSource(String source){
        return  this.source = source;
    }

    public int getCode(){
        return code;
    }

    public int setCode(int code){
        return this.code = code;
    }

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(int code,String source){
        super(source);
        this.setCode(code);
    }
}
