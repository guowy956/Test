package com.cn.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by newtouch on 2017/8/28.
 */
public class BaseService <PK extends Serializable>{
    protected Logger logger  = LoggerFactory.getLogger(getClass());
}
