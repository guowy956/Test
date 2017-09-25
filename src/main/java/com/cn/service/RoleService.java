package com.cn.service;

import com.cn.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author guowy
 * @create 2017-06-09 15:43
 **/
@Service
public class RoleService <T,Q,PK extends Serializable> extends CommonsService<T,Q,PK>{

    @Autowired
    private RoleMapper mapper;

    @Override
    public RoleMapper<T, Q, PK> getMapper() {
        return mapper;
    }
}
