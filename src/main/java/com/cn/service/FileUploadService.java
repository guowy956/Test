package com.cn.service;

import com.cn.mapper.FileUploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by newtouch on 2017/8/19.
 */
@Service
public class FileUploadService<T,S,PK extends Serializable> extends CommonsService<T,S, PK>{


    @Autowired
    FileUploadMapper<T, S, PK> mapper;

    @Override
    public FileUploadMapper<T, S, PK> getMapper() {
        return mapper;
    }

}
