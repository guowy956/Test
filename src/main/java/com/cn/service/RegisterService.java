package com.cn.service;

import com.cn.mapper.CommonMapper;
import com.cn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by newtouch on 2017/11/6.
 */
@Service
public class RegisterService<T,Q,PK extends Serializable> extends CommonsService<T,Q,PK> {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserMapper<T,Q,PK>  getMapper() {
        return userMapper;
    }
}
