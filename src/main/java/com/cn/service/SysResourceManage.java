package com.cn.service;

import com.cn.mapper.BaseManage;
import com.cn.model.domain.Role;
import com.cn.model.domain.SysResource;
import com.cn.model.domain.SysResourceExample;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by newtouch on 2017/9/15.
 */
@Service
public class SysResourceManage extends BaseManage<Long> {

    @Autowired
    private  SysResourceService<SysResource,SysResourceExample,Long> service;

    @Override
    public  SysResourceService<SysResource,SysResourceExample,Long> getService() {
        return service;
    }

    @Autowired
    private RoleManage  roleManage;
    @Autowired
    SysResourceManage sysResourceManage;

    public List<SysResource> getListByIdResource(String resourceIds) {
        if(StringUtils.isBlank(resourceIds) || resourceIds.indexOf(",")<1){
            return null;
        }
        String[] resList = resourceIds.split(",");
        List<Long> resourceIdList = new ArrayList<>();
        for(String idR : resList){
            resourceIdList.add(Long.parseLong(idR));
        }
        SysResourceExample example = new SysResourceExample();
        SysResourceExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(resourceIdList);
        criteria.andAvailableEqualTo(true);
        return getService().findBy(example);
    }

    public List<SysResource> getListByIdFunction(String functionIds) {
        if(StringUtils.isBlank(functionIds) || functionIds.indexOf(";")<1){
            return null;
        }
        String[] resList = functionIds.split(";");
        List<Long> resourceIdList = new ArrayList<>();
        for(String idR : resList){
            resourceIdList.add(Long.parseLong(idR));
        }
        SysResourceExample example = new SysResourceExample();
        SysResourceExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(resourceIdList);
        criteria.andAvailableEqualTo(true);
        return getService().findBy(example);
    }

    public List<SysResource> getSysResources() {
        return getService().findAll();
    }


    public List<Map<String,Object>> getMenus(String empNo){
        Role role = roleManage.getRoleByEmpNo(empNo);
        if(role == null){
            return null;
        }
        String ids = role.getResourceIds();
        if(StringUtils.isBlank(ids)){
            return null;
        }
        List<SysResource> resources = sysResourceManage.getListByIds(ids);
        List<SysResource> lv2Resources = new ArrayList<>();
        List<SysResource> lv3Resources = new ArrayList<>();
        for (SysResource resource : resources){
            String parentIds = resource.getParentIds();
            if(parentIds.split("/").length == 3){
                lv2Resources.add(resource);
            }
            if(parentIds.split("/").length == 4){
                lv3Resources.add(resource);
            }
        }

        List<Map<String, Object>> menus = new ArrayList<>();
        for(SysResource lv2Resource : lv2Resources){
            List<Map<String, String>> childrenMenu = new ArrayList<>();
            for(SysResource lv3Resource : lv3Resources){
                if(lv3Resource.getParentIds().indexOf(lv2Resource.getParentIds())>-1){
                    Map<String,String> map = new HashedMap();
                    map.put("childMenuName", lv3Resource.getName());
                    map.put("path", lv3Resource.getUrl());
                    childrenMenu.add(map);
                }
            }
            Map<String, Object> map2 = new HashedMap();
            map2.put("menuName", lv2Resource.getName());
            map2.put("childrenMenu", childrenMenu);
            menus.add(map2);
        }
        return menus;
    }
    public List<SysResource> getListByIds(String ids){
        System.out.println(ids);
        if(StringUtils.isBlank(ids) || ids.indexOf(",") < 1){
            return null;
        }
        String[] arr = ids.split(",");
        List<Long> idList = new ArrayList<>();
        for (String id : arr) {
            idList.add(Long.parseLong(id));
        }
        SysResourceExample query = new SysResourceExample();
        SysResourceExample.Criteria criteria = query.createCriteria();
        criteria.andIdIn(idList);
        criteria.andAvailableEqualTo(true);
        return getService().findBy(query);
    }
}
