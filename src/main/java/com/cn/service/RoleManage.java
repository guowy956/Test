package com.cn.service;

import com.cn.exception.BadRequestException;
import com.cn.mapper.BaseManage;
import com.cn.model.domain.Role;
import com.cn.model.domain.RoleExample;
import com.cn.model.domain.SysResource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by newtouch on 2017/9/15.
 */
@Service
public class RoleManage extends BaseManage<Long> {

    @Autowired
    private RoleService<Role,RoleExample,Long> service;
    @Override
    public  RoleService<Role,RoleExample,Long> getService() {
        return service;
    }
    @Autowired
    private SysResourceManage manage;

    public int save(Role body) {
        return getService().save(body);
    }

    public List<Map<String,Object>> select_name(int start, int length, String roleName) {
        RoleExample roleExample = new RoleExample();
        if(StringUtils.isNoneBlank(roleName)){
            roleExample.or().andRolenameLike("%"+roleName+"%");
        }
        List<Role> roles = getService().findBy(new RowBounds(start, length), roleExample);
        List<Map<String,Object>> list = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(roles)){
            for(Role role : roles){
                Map<String, Object> map = new HashMap();
                map.put("id",role.getId());
                map.put("name",role.getRolename());
                map.put("resourceIds",role.getResourceIds());
                map.put("functionIds",role.getFunctionIds());
                List<SysResource> rList = manage.getListByIdResource(role.getResourceIds());
                List<SysResource> fList = manage.getListByIdFunction(role.getFunctionIds());
                StringBuilder sb = new StringBuilder();
                StringBuilder fb = new StringBuilder();
                if(CollectionUtils.isNotEmpty(rList) && CollectionUtils.isNotEmpty(fList)){
                    for(int i = 0;i<rList.size();i++){
                        SysResource sysResource = rList.get(i);
                        sb.append(sysResource.getName());
                        if(i<rList.size()-1){
                            sb.append(",");
                        }
                    }
                    for(int j = 0;j<fList.size();j++){
                        SysResource sysResource = fList.get(j);
                        fb.append(sysResource.getName());
                        if(j<fList.size()-1){
                            fb.append("-");
                        }
                    }
                }
                String res = sb.toString();
                String fun = fb.toString();
                map.put("resourceNames",res);
                map.put("functionNames",fun);
                list.add(map);
            }
        }
        return list;
    }

    public int getTotalCount(String roleName) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM role  ");
        sb.append("WHERE 1=1");
        if(StringUtils.isNotBlank(roleName)){
            sb.append("AND roleName = "+roleName);
        }
        return getService().countBySQL(sb.toString());
    }


    public Role get(Long roleId) {
        if(roleId==null){
            throw new BadRequestException("roleId 不能为空");
        }
        return getService().findByID(roleId);
    }
    public Role getRoleByEmpNo(String empNo){
        if(StringUtils.isBlank(empNo)){
            return null;
        }
        StringBuilder sql = new StringBuilder();
        sql.append("select r.id roleId ,r.`roleName` roleName , r.resource_ids resourceIds ");
        sql.append(" from `user` u LEFT JOIN user_role ur ON u.id = ur.user_id LEFT JOIN role r ON ur.role_id = r.id ");
        sql.append(" WHERE u.loginAccount = '"+ empNo+"'");
        List<Map<String, Object>> maps = getService().findBySQL(sql.toString());
        try {
            if(CollectionUtils.isNotEmpty(maps) && maps.size()>=1 && maps.get(0) != null){
                Map<String, Object> map = maps.get(0);
                Role role = new Role();
                role.setId(map.get("roleId")==null?null:Long.parseLong(map.get("roleId").toString()));
                role.setRolename(map.get("roleName")==null?null:map.get("roleName").toString());
                role.setResourceIds(map.get("resourceIds")==null?null:map.get("resourceIds").toString());
                return role;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
