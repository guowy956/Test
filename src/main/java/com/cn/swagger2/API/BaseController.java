package com.cn.swagger2.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseController
 *
 * @author guowy
 * @create 2017-05-27 10:32
 **/
//@Auth
@Service
public class BaseController {


    protected Logger logger = LoggerFactory.getLogger(getClass());

    public Map page(List list , int count){
        Map map 			            = new HashMap();
        map.put("recordsTotal", 		count);
        map.put("recordsFiltered", 		count);
        map.put("data",                 list);
        map.put("code", HttpStatus.OK.value());
        return map;
    }

}
