package com.cn.algorithm;

/**
 * Created by newtouch on 2017/8/11.
 * 希尔排序（最小增量排序）
 *
 * 算法先将要排序的一组数按某个增量 d（n/2,n为要排序数的个数）分成若干组，
 * 每组中记录的下标相差 d.对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，
 * 在每组中再进行直接插入排序。当增量减到 1 时，进行直接插入排序后，排序完成。
 */
public class shellSort {



    public static void main(String[] args) {
        int num[]={1,54,6,3,78,34,12,45,56,100};
        double numLength = num.length; // 要排序数组的长度
        int temp = 0;
        while (true){
            numLength = Math.ceil(numLength/2); //除法运算  -- 除二
            int nums = (int) numLength;  // 转化为int
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
