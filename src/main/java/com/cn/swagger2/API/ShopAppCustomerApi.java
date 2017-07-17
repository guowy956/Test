package com.cn.swagger2.API;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * ShopAppCustomerApi
 *
 * @author guowy
 * @create 2017-05-27 15:05
 **/
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "customer", description = "the customer API")
@RequestMapping(value = "/api")
public interface ShopAppCustomerApi {

    @ApiOperation(value = "分页查询用户/客户列表", notes = "分页查询用户/客户列表 ",  tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/customer/shopAppCustomer",
            method = RequestMethod.POST)
    ResponseEntity<SuccessModel> list(@RequestParam(name = "start", defaultValue = "1" ) int start,
                                      @RequestParam(name = "length", defaultValue = "10") int length,
                                      @NotNull @ApiParam(value = "用户/客户ID",required = true)@RequestParam(name = "ID", defaultValue = "10" ,required = true) String ID);
}
