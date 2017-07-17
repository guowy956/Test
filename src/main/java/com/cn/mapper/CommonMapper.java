package com.cn.mapper;

import com.cn.model.entity.Product;
import com.cn.model.select.ProductS;

import java.io.Serializable;
import java.util.List;

/**
 * CommonMapper
 *
 * @author guowy
 * @create 2017-06-22 10:19
 **/

public interface CommonMapper<T,S,PK extends Serializable> {

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(T record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(T record);

    <T> List<T> getAll();

}
