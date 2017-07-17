package com.cn.webService;

import com.cn.mapper.RoleMapper;
import com.cn.model.entity.Role;
import com.cn.swagger2.API.SuccessModel;
import com.cn.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * WebService
 *
 * @author guowy
 * @create 2017-07-03 10:21
 **/

public class RolesServiceImpl implements RolesService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public ResponseEntity<SuccessModel> getList() {
        List<Role> list = roleMapper.getList();
        return ApiResponse.success(list,"查询成功");
    }
}
