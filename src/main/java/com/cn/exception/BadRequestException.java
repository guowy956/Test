package com.cn.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by newtouch on 2017/8/23.
 */
public class BadRequestException extends BusinessException {

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.value(),message);
    }
}
