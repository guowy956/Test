package com.cn.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 *
 * @author guowy
 * @create 2017-05-23 13:29
 **/

public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
