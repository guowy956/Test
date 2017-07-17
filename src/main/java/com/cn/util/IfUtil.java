package com.cn.util;

import com.cn.exception.ServiceException;

/**
 * 判断 -- 工具类
 *
 * @author guowy
 * @create 2017-06-09 10:35
 **/

public class IfUtil {

    public static boolean insertIf(int index){
        Boolean flag = true;
        if(index != 1){
            flag = false;
            throw new ServiceException(StatusBooks.INSERT_NO);
        }
        return flag;
    }
    public static boolean deleteIf(int index){
        Boolean flag = true;
        if(index != 1){
            flag = false;
            throw new ServiceException(StatusBooks.DELETE_NO);
        }
        return flag;
    }
    public static boolean updateIf(int index){
        Boolean flag = true;
        if(index != 1){
            flag = false;
            throw new ServiceException(StatusBooks.UPDATE_NO);
        }
        return flag;
    }
}
