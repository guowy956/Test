package com.cn.swagger2.API;

import com.cn.model.login.Login;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * LoginApi
 *
 * @author guowy
 * @create 2017-05-27 15:05
 **/
//@Auth
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "Login", description = "the Login API")
public interface LoginApi {

    @ApiOperation(value = "登录", notes = "登录 ",  tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = SuccessModel.class) })
    @RequestMapping(value = "/login",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<SuccessModel> login( @ApiParam(value = "登陆信息") @RequestBody Login login);
    @ApiOperation(value = "登出", notes = "登出 ",  tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/loginOut",
            method = RequestMethod.GET)
    ResponseEntity<SuccessModel> loginOut();

}
