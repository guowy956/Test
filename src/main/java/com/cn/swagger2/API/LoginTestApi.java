package com.cn.swagger2.API;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LoginTest
 *
 * @author guowy
 * @create 2017-06-28 10:39
 **/
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-16T06:58:31.439Z")

@Api(value = "loginTest", description = "the loginTest API")
@RequestMapping(value = "/api")
public interface LoginTestApi {

    @ApiOperation(value = "登录探针", notes = "登录探针 ", response = SuccessModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = SuccessModel.class) })
    @RequestMapping(value = "/loginTest",
            method = RequestMethod.GET)
    ResponseEntity<SuccessModel> loginTest();
}
