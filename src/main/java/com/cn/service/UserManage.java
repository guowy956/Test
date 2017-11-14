package com.cn.service;

import com.cn.filter.CurrentUserUtils;
import com.cn.mapper.BaseManage;
import com.cn.model.domain.User;
import com.cn.model.domain.UserExample;
import com.cn.swagger2.API.SuccessModel;
import com.cn.util.*;
import com.cn.util.numUtil.GenerateRandomNumber;
import com.cn.util.security.jwt.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户操作
 *
 * @author guowy
 * @create 2017-06-08 16:45
 **/
@Service
public class UserManage extends BaseManage<Long> {

    @Autowired
    private UserService<User,UserExample,Long> service;

    @Override
    public  UserService<User,UserExample,Long> getService() {
        return service;
    }



    @Autowired
    private SysResourceManage manage;



    public ResponseEntity<SuccessModel> loginOut() {
        CurrentUserUtils.getInstance().delUser();
        return ApiResponse.success("退出登录");
    }

    public ResponseEntity<SuccessModel> login(User user) {
        SuccessModel successModel = new SuccessModel();
        final ResponseEntity<SuccessModel> successModelResponseEntity = new ResponseEntity<>(successModel, HttpStatus.OK);
        int loginCount = getLoginCount(user.getLoginaccount());
        if(loginCount>0){
            User sac = loginTo(user);
            if(StringUtil.isEmpty(sac)){
                successModel.code(HttpStatus.UNAUTHORIZED.value());
                successModel.data("");
                successModel.message("登录失败");
                return successModelResponseEntity;
            }
        }else{
            successModel.code(StatusBooks.LOGIN_NAME_ERROR.getCode());
            successModel.data("");
            successModel.message("账户不存在");
            return successModelResponseEntity;
        }
        Map<String,Object> map = new HashMap();
        List<Map<String, Object>> menus = manage.getMenus(user.getLoginaccount());
        String charAndNumr = GenerateRandomNumber.getCharAndNumr(5);
        String token = JwtHelper.createJWT(user.getLoginaccount(), 10000, charAndNumr);
        map.put("token", token);
        System.out.println(token);
        map.put("menus", menus);
        map.put("user", user);
        CurrentUserUtils.getInstance().setUser(map);
        return ApiResponse.success(map,"登录成功");
    }

    public int getLoginCount(String LoginAccount){
        UserExample example = new UserExample();
        example.or().andLoginaccountEqualTo(LoginAccount);
        return getService().countByExample(example);
    }

    public User loginTo(User user){
        UserExample example = new UserExample();
        example.or().andLoginaccountEqualTo(user.getLoginaccount()).
                andUserpassEqualTo(MD5.convertMD5(user.getUserpass()));
        return getService().selectOneByExample(example);
    }

}
