package com.cn.exception;

import com.cn.util.StatusBooks;

/**
 * 异常
 *
 * @author guowy
 * @create 2017-05-26 17:20
 **/

public class ServiceException extends  RuntimeException{
    public ServiceException(String msg){
        super(msg);
    }

    public ServiceException() {
        super();
    }

    public ServiceException(String msg, Throwable clause) {
        super(msg, clause);
    }

    public ServiceException(Throwable clause) {
        super(clause);
    }

    public ServiceException(StatusBooks statusBooks) {
        super(String.valueOf(statusBooks.getMessage()));
    }
}
