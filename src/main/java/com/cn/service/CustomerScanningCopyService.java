package com.cn.service;

import com.cn.mapper.CustomerScanningCopyMapper;
import com.cn.service.CommonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by newtouch on 2017/8/28.
 */
@Service
public class CustomerScanningCopyService <T,S,PK extends Serializable> extends CommonsService<T,S, PK> {

    @Autowired
    CustomerScanningCopyMapper mapper;

    public CustomerScanningCopyMapper <T,S,PK> getMapper(){
        return mapper;
    }
}
