package com.cn.swagger2.API;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 菜单API
 *
 * @author guowy
 * @create 2017-06-20 10:43
 **/
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "sysResource", description = "the sysResource API")
public interface SysResourceAPI {

    @ApiOperation(value = "获取所有功能权限", notes = "获取所有功能权限 ", response = SuccessModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = SuccessModel.class) })
    @RequestMapping(value = "sysResource/menuTree"
            ,method = RequestMethod.GET)
    ResponseEntity<SuccessModel> menuTree(Long roleId);

}
