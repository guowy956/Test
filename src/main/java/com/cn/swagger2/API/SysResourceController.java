package com.cn.swagger2.API;

import com.cn.model.domain.Role;
import com.cn.model.domain.SysResource;
import com.cn.model.entity.TreeEntity;
import com.cn.service.RoleManage;
import com.cn.service.SysResourceManage;
import com.cn.util.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 *
 * @author guowy
 * @create 2017-06-20 10:42
 **/
@Controller
public class SysResourceController extends BaseController implements SysResourceAPI{

    @Autowired
    private RoleManage roleManage;

    @Autowired
    private SysResourceManage sysResourceManage;

    @Override
    public ResponseEntity<SuccessModel> menuTree(Long roleId) {
        Role role = null;
        String resourceIds = null;
        String functionIds = null;
        if(roleId != null){
            role = roleManage.get(roleId);
             resourceIds = role.getResourceIds();
             functionIds = role.getFunctionIds();
        }
        List<SysResource> resources = sysResourceManage.getSysResources();
        List<TreeEntity> treeEntity = setResource(resources,resourceIds,functionIds);
        return ApiResponse.success(treeEntity,"查询成功");
    }

    private List<TreeEntity> setResource(List<SysResource> temp, String resourceIds, String functionIds) {
        if(null == temp || temp.size()<=0){
            return null;
        }
        List<TreeEntity> treeEntityList  = new ArrayList<>();
        for (SysResource sr:temp){
            TreeEntity ot = new TreeEntity();
            ot.setId(String.valueOf(sr.getId()));
            ot.setPid(String.valueOf(sr.getParentId()));
            ot.setName(String.valueOf(ot.getName()));
            if("menu".equals(sr.getType())){
                ot.setParent(true);
            }else {
                ot.setParent(true);
            }
            if(StringUtils.isNotBlank(resourceIds)){
                if(hasIt(ot.getId(),resourceIds)){
                   ot.setChecked(true);
                } else {
                    ot.setChecked(false);
                }
            }
            treeEntityList.add(ot);
        }

        return treeEntityList;
    }

    public Boolean hasIt(String id, String resourceIds){
        String[] split = resourceIds.split(",");
        Boolean res = false;
        for (String str : split){
            if(id.equals(str)){
                res = true;
            }
        }
        return res;
    }
}
