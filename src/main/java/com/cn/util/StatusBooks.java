package com.cn.util;

/**
 * 枚举类 -- 状态
 *
 * @author GUOWY
 * @create 2017-05-28 16:16
 **/

public enum StatusBooks {


    LOGIN_NAME_ERROR(001, "用户名错误"),
    LOGIN_PASS_ERROR(002, "密  码错误"),
    LOGIN_PASSANDNANE_ERROR(003,"用户名或密码错误"),
    IS_SURE_YSE(004,"用户将邮箱当作登录账户"),
    IS_SURE_NO(005,"用户不将邮箱当作登录账户"),
    INSERT_NO(006,"添加操作失败"),
    DELETE_NO(007,"删除操作失败"),
    UPDATE_NO(0010,"修改操作失败"),
    LOGIN_NO(0011,"未登录"),




    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    StatusBooks (int code ,String message){
        this.code = code;
        this.message =message;

    }
}
