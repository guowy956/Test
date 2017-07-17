package com.cn.swagger2.API;

import org.springframework.http.HttpStatus;

/**
 * Response
 *
 * @author guowy
 * @create 2017-05-27 13:28
 **/
//@Auth
public class Response {

    public static SuccessModel success(final Object data){
        SuccessModel sm = new SuccessModel();
        sm.setCode(         HttpStatus.OK.value());
        sm.setData(         data);
        return sm;
    }

    public static SuccessModel success(final Object data, final String message){
        SuccessModel sm = new SuccessModel();
        sm.setCode(         HttpStatus.OK.value());
        sm.setMessage(      message);
        sm.setData(         data);
        return sm;
    }
}
