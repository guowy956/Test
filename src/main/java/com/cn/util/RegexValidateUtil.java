package com.cn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 格式验证
 *
 * @author guowy
 * @create 2017-06-09 10:10
 **/

public class RegexValidateUtil {

    public static  boolean checkEmail(String name){
        Boolean flag = false ;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern compile = Pattern.compile(check);
            Matcher matcher = compile.matcher(name);
            flag = matcher.matches();
        }catch (Exception e){
            flag = false ;
        }
        return flag;
    }

    public static  boolean checkMobileNumber(String name){
        Boolean flag = false ;
        try {
        Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
        Matcher matcher = regex.matcher(name);
        flag = matcher.matches();
        }catch (Exception e){
            flag = false ;
        }
        return flag;
    }
}
