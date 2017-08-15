package com.cn.algorithm;

/**
 * Created by newtouch on 2017/8/11.
 *  排序
 *
 *  基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，
 *  现在要把第n 个数插到前面的有序数中，使得这 n个数也是排好顺序的。如此反复循环，
 *  直到全部排好顺序。
 */
public class insertSort {

    public static void main(String[] args) {
        int num[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int temp = 0;
        for(int i=0;i<num.length;i++){
            int j = i-1;
            temp = num[i];
            for(;j>=0&&temp<num[j];j--){
                num[j+1] = num[j];
            }
            num[j+1] = temp;
        }
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+",");
        }
    }
}
