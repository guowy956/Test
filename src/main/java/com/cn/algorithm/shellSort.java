package com.cn.algorithm;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by newtouch on 2017/8/11.
 * 希尔排序（最小增量排序）
 */
public class shellSort {



    public static void main(String[] args) {
        int num[]={1,54,6,3,78,34,12,45,56,100};
        double numLength = num.length;
        int temp = 0;
        while (true){
            numLength = Math.ceil(numLength/2);
            int nums = (int) numLength;
            for(int i= 0 ;i<nums;i++){
                 for(int j = i+nums ;j<num.length; j+=nums){
                     int k = j-nums;
                     temp = num[j];
                     for(;k>=0&&temp<num[k];k-=nums){
                         num[k+nums] = num[k];
                     }
                     num[k+nums] = temp;
                 }
            }
            if(nums == 1){
                break;
            }
        }
        for(int i = 0 ; i<num.length ; i++){
            System.out.print(num[i]+",");
        }
    }
}
