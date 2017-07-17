package com.cn.webService;

import com.cn.swagger2.API.SuccessModel;
import org.springframework.http.ResponseEntity;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Webservice
 *
 * @author guowy
 * @create 2017-07-03 10:19
 **/

@WebService
public interface RolesService {

    @WebMethod
    ResponseEntity<SuccessModel> getList();
}
