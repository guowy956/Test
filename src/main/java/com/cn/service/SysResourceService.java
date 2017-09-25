package com.cn.service;

import com.cn.mapper.SysResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 菜单Service
 *
 * @author guowy
 * @create 2017-06-20 10:51
 **/

@Service
public class SysResourceService <T,Q,PK extends Serializable> extends CommonsService<T,Q,PK> {


    @Autowired
    private SysResourceMapper manager;

    @Override
    public SysResourceMapper<T,Q,PK> getMapper() {
        return manager;
    }
}
