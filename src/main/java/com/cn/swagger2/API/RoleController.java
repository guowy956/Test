package com.cn.swagger2.API;

import com.cn.model.entity.Role;
import com.cn.service.RoleService;
import com.cn.util.ApiResponse;
import com.cn.util.IfUtil;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    private RoleService roleService;

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
        List<Role> list = roleService.list(start,length,roleName);
        for(int i =0 ; i<list.size() ;i++){
            String resourceIds = list.get(i).getResourceIds();
            String[] splitList = resourceIds.split(",");
            for(int j =0;j<splitList.length;j++){
                String s = splitList[j];
                System.out.print(s);
            }
        }
        int totalCount = roleService.getTotalCount();
        return ApiResponse.success(page(list, totalCount), "查询成功");
    }

    @Override
    public ResponseEntity<SuccessModel> addRole(@ApiParam(value = "角色") @RequestBody Role body) {
        IfUtil.insertIf(roleService.addRole(body));
        return ApiResponse.success("添加成功");
    }

    @Override
    public ResponseEntity<SuccessModel> deleteRole(@ApiParam(value = "ID") @RequestParam(value = "ID", required = false) Long ID) {
        IfUtil.deleteIf(roleService.deleteRole(ID));
        return ApiResponse.success(roleService.deleteRole(ID),"删除成功");
    }

    @Override
    public ResponseEntity<SuccessModel> updateRole(@ApiParam(value = "角色") @RequestBody Role body) {
        IfUtil.updateIf(roleService.updateRole(body));
        return ApiResponse.success("修改成功");
    }

    @Override
    public ResponseEntity<SuccessModel> getList() {
        List<Role> list =  roleService.getList();
        return ApiResponse.success(list,"查询成功");
    }
}
