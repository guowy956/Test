package com.cn.service;

import com.cn.mapper.RoleMapper;
import com.cn.mapper.SysResourceMapper;
import com.cn.model.entity.Role;
import com.cn.model.entity.SysResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单Service
 *
 * @author guowy
 * @create 2017-06-20 10:51
 **/

@Service
public class SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Autowired
    private RoleMapper roleMapper;

    public List<SysResource> menuTree() {
        return sysResourceMapper.menuTree();
    }

    public List<Map<String, Object>> getMenus(String username) {
        Role role = roleMapper.selectByEmployeeNumber(username);
        if(role ==null){
            return null;
        }
        String ids = role.getResourceIds();
        if(StringUtils.isBlank(ids)){
            return null;
        }
        String[] arr = ids.split(",");
        List<Long> idList = new ArrayList<>();
        for (String id : arr) {
            idList.add(Long.parseLong(id));
        }
        List<SysResource> sysResourceList = sysResourceMapper.getListByIds(idList);
        List<SysResource> lv2Resources = new ArrayList<>();
        List<SysResource> lv3Resources = new ArrayList<>();
        for(SysResource sysResource : sysResourceList){
            String parentIds = sysResource.getParentIds();
            if(parentIds.split("/").length==3){
                lv2Resources.add(sysResource);
            }
            if(parentIds.split("/").length==4){
                lv3Resources.add(sysResource);
            }
        }
        List<Map<String, Object>> menus = new ArrayList<>();
        for(SysResource lv2Resource : lv2Resources){
            List<Map<String, String>> childrenMenu = new ArrayList<>();
            for(SysResource lv3Resource : lv3Resources){
                if(lv3Resource.getParentIds().indexOf(lv2Resource.getParentIds())>-1){
                    Map<String,String> map = new HashMap<>();
                    map.put("childMenuName",lv3Resource.getName());
                    map.put("path",lv3Resource.getUrl());
                    childrenMenu.add(map);
                }
            }
            Map<String, Object> map2 = new HashMap<>();
            map2.put("menuName", lv2Resource.getName());
            map2.put("childrenMenu", childrenMenu);
            menus.add(map2);
        }
        return menus;
    }
}
