package com.cn.swagger2.API;

import com.cn.model.domain.Role;

import com.cn.service.RoleManage;
import com.cn.util.ApiResponse;

import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 角色Controller
 *
 * @author guowy
 * @create 2017-06-09 13:41
 **/
@Controller
public class RoleController extends BaseController implements RoleApi {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);


    @Autowired
    private RoleManage manage;
    /**
     * @Author:guowy 【guowy956@163.com】
     * @Description: 角色列表查询
     * @param roleName
     * @param start
     * @param length
     * @Date: 2017-06-20 17:24
     */
    @Override
    public ResponseEntity<SuccessModel> list(
            @ApiParam(value = "角色名称") @RequestParam(value = "roleName", required = false) String roleName,
            @ApiParam(name = "start") @RequestParam(name = "start", defaultValue = "0") int start,
            @ApiParam(name = "length") @RequestParam(name = "length", defaultValue = "9") int length
    ){
        List<Map<String,Object>> list = manage.select_name(start,length,roleName);
        int totalCount = manage.getTotalCount(roleName);
        return ApiResponse.success(page(list, totalCount), "查询成功");
    }

    @Override
    public ResponseEntity<SuccessModel> addRole(@ApiParam(value = "角色") @RequestBody Role body) {
        manage.save(body);
        return ApiResponse.success("添加成功");
    }

    @Override
    public ResponseEntity<SuccessModel> deleteRole(@ApiParam(value = "ID") @RequestParam(value = "ID", required = false) Long ID) {
        manage.removeById(ID);
        return ApiResponse.success(manage.removeById(ID),"删除成功");
    }

    @Override
    public ResponseEntity<SuccessModel> updateRole(@ApiParam(value = "角色") @RequestBody Role body) {
        manage.modify(body);
        return ApiResponse.success("修改成功");
    }

    @Override
    public ResponseEntity<SuccessModel> getList() {
        List<Role> list =  manage.findAll();
        return ApiResponse.success(list,"查询成功");
    }
}
