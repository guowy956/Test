package com.cn.swagger2.API;

import com.cn.model.domain.User;
import com.cn.model.login.Login;
import com.cn.service.UserManage;
import com.cn.util.MD5;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 登录
 *
 * @author guowy
 * @create 2017-05-27 15:03
 **/
@Controller
public class LoginController extends BaseController implements LoginApi{

    @Autowired
    private UserManage userManage;

    @Override
    public ResponseEntity<SuccessModel> login (@ApiParam(value = "登陆信息") @RequestBody Login login) {
        User user = new User();
        user.setLoginaccount(login.getUsername());
        user.setUserpass(MD5.convertMD5(login.getPassword()));
        ResponseEntity<SuccessModel> flag = userManage.login(user);
        return flag;
    }

    @Override
    public ResponseEntity<SuccessModel> loginOut() {
        return userManage.loginOut();
    }
}
