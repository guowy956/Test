package com.cn.swagger2.API;

import com.cn.model.User;
import com.cn.util.AjaxResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * API
 *
 * @author guowy
 * @create 2017-05-26 18:39
 **/
//@Auth
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "user", description = "the user API")
@RequestMapping(value = "/user")
public interface UserApi {

    @ApiOperation(value = "分页查询用户列表", notes = "分页查询用户列表 ",  tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/user/modifyService",
            method = RequestMethod.GET)
     Map<String, Object> json(@RequestParam(name = "page", defaultValue = "1" ) int page,
                                    @RequestParam(name = "rows", defaultValue = "10") int rows,
                                    @NotNull @ApiParam(value = "用户ID",required = true)@RequestParam(name = "ID", defaultValue = "10" ,required = true) Long ID);

    @ApiOperation(value = "用户查询(无分页)", notes = "用户查询(无分页) ")
    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
     String list() ;

    @ApiOperation(value = "用户添加", notes = "用户添加 ",  tags={  })
    @RequestMapping(value = "/user/save",produces = { "application/json" } ,method = RequestMethod.GET)
     AjaxResult save(@RequestBody User user);

}
