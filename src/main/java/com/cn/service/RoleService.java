package com.cn.service;

import com.cn.mapper.RoleMapper;
import com.cn.model.entity.Role;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guowy
 * @create 2017-06-09 15:43
 **/
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> list(int start, int length, String name) {
        List<Role> roleList =  roleMapper.selectRoleList(new RowBounds(start, length),name);
        return roleList;
    }

    public int getTotalCount() {
        return roleMapper.getTotalCount();
    }

    public int addRole(Role body) {
        return roleMapper.insert(body);
    }

    public int deleteRole(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    public int updateRole(Role body) {
        return roleMapper.updateByPrimaryKey(body);
    }

    public List<Role> getList() {
        return roleMapper.getList();
    }
}
