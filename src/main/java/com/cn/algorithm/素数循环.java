package com.cn.algorithm;

import static java.lang.Math.sqrt;

/**
 * Created by newtouch on 2017/8/11.
 */
public class 素数循环 {

    public static int count = 0;

    public static void main(String[] args) {
        for(int i = 101 ;i<200;i++){
            Boolean flag = true;
            for(int j =2 ;j<sqrt(i);j++){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
                //System.out.println(count);
                System.out.println(i);
            }
        }
        System.out.println("/n素数的个数："+count);
    }
}
