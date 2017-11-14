package com.cn.util;

/**
 * Created by newtouch on 2017/11/6.
 */
public class RandomUtil {



    public RandomUtil randomUtil(){
        return null ;
    }

    public static String getRandom(){
        String str = "";
        str += (int)(Math.random()*9+1);
        for(int i = 0 ; i<5 ; i++){
            str += (int)(Math.random()*10);
        }
        int num = Integer.parseInt(str);
        return String.valueOf(num);
    }
}
