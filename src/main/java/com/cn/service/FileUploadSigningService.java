package com.cn.service;

import com.cn.mapper.CommonMapper;
import com.cn.mapper.FileUploadSigningMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by newtouch on 2017/8/25.
 */
@Service
public class FileUploadSigningService <T,S,PK extends Serializable> extends CommonsService<T,S, PK>{


    @Autowired
    FileUploadSigningMapper<T, S, PK> mapper;

    @Override
    public FileUploadSigningMapper<T, S, PK> getMapper() {
        return mapper;
    }
}
