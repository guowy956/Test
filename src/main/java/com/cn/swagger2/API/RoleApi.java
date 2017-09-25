package com.cn.swagger2.API;

import com.cn.model.domain.Role;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Null;

/**
 * 角色API
 *
 * @author guowy
 * @create 2017-06-09 13:41
 **/
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "role", description = "the role API")
@RequestMapping(value = "/api")
public interface RoleApi {

    @ApiOperation(value = "角色列表", notes = "角色列表",tags = { })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "roleList",method = RequestMethod.GET , produces="application/json;charset=utf-8")
    ResponseEntity<SuccessModel> list(
            @ApiParam(value = "角色名称") @RequestParam(value = "roleName", required = false) String roleName,
            @Null@ApiParam(name = "start",required = true)@RequestParam(name = "start",defaultValue = "0") int start,
            @Null@ApiParam(name = "length",required = true)@RequestParam(name = "length",defaultValue = "9") int length
    );
    @ApiOperation(value = "添加角色", notes = "添加角色",response = SuccessModel.class, tags={  })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "addRole",method = RequestMethod.POST , produces="application/json;charset=utf-8")
    ResponseEntity<SuccessModel> addRole( @ApiParam(value = "角色") @RequestBody Role body );

    @ApiOperation(value = "删除角色", notes = "删除角色",response = SuccessModel.class, tags={  })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "deleteRole",method = RequestMethod.DELETE , produces="application/json;charset=utf-8")
    ResponseEntity<SuccessModel> deleteRole(
            @ApiParam(value = "ID") @RequestParam(value = "ID", required = false) Long ID
    );
    @ApiOperation(value = "修改角色", notes = "修改角色" ,response = SuccessModel.class, tags={  })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "updateRole",method = RequestMethod.PUT , produces="application/json;charset=utf-8")
    ResponseEntity<SuccessModel> updateRole( @ApiParam(value = "角色") @RequestBody Role body );

    @ApiOperation(value = "角色列表", notes = "角色列表",tags = { })
    @ApiResponses({
            @ApiResponse(code = 200,message = "Successful response",response = SuccessModel.class),
            @ApiResponse(code = 200,message = "unexpected error")    })
    @RequestMapping(value = "getLists",method = RequestMethod.GET , produces="application/json;charset=utf-8")
    ResponseEntity<SuccessModel> getList();
}
