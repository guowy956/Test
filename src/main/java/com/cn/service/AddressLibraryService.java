package com.cn.service;

import com.cn.mapper.AddressLibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by newtouch on 2017/9/7.
 */
@Service
public class AddressLibraryService<T,Q,PK extends Serializable> extends CommonsService<T,Q,PK> {

    @Autowired
    private AddressLibraryMapper mapper;

    @Override
    public AddressLibraryMapper<T,Q,PK> getMapper() {
        return mapper;
    }
}
