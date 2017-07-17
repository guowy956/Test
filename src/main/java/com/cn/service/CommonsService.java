package com.cn.service;

import com.cn.mapper.CommonMapper;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;

/**
 * CommonsService
 *
 * @author guowy
 * @create 2017-06-22 10:15
 **/

public abstract class CommonsService<T,S,PK extends Serializable> {

    public abstract CommonMapper<T, S, PK> getMapper();

    public  int insert(T body) {
        return insert(body,true);
    }

    public int insert(T body,boolean isSelective){
        if(isSelective){
            return getMapper().insertSelective(body);
        }else{
            return getMapper().insert(body);
        }
    }

    public List<T> getAll() {
        return getMapper().getAll();
    }

}
