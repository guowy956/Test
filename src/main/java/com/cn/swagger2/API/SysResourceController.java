package com.cn.swagger2.API;

import com.cn.model.entity.SysResource;
import com.cn.model.entity.TreeEntity;
import com.cn.service.SysResourceService;
import com.cn.util.ApiResponse;
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
    private SysResourceService sysResourceService;
    @Override
    public ResponseEntity<SuccessModel> menuTree() {
        List<SysResource> sysResources = sysResourceService.menuTree();
        List<TreeEntity> treeEntityList = getMenuTree(sysResources);
        return ApiResponse.success(treeEntityList, "查询成功");
    }

    private List<TreeEntity> getMenuTree(List<SysResource> temp) {
        if(temp==null && temp.size()==0)return null;
        List<TreeEntity> list =  new ArrayList<TreeEntity>();
        for(SysResource t : temp){
            TreeEntity te = new TreeEntity();
            te.setId(String.valueOf(t.getId()));
            te.setName(t.getName());
            te.setPid(String.valueOf(t.getParentId()));
            if("menu".equals(t.getType())){
                te.setParent(true);
            }else{
                te.setParent(false);
            }
            list.add(te);
        }
        return list;
    }
}
