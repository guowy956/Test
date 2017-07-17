package com.cn.service;

import com.cn.exception.ServiceException;
import com.cn.filter.CurrentUserUtils;
import com.cn.mapper.UserMapper;
import com.cn.model.entity.User;
import com.cn.swagger2.API.SuccessModel;
import com.cn.util.*;
import com.cn.util.numUtil.GenerateRandomNumber;
import com.cn.util.security.jwt.JwtHelper;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 用户操作
 *
 * @author guowy
 * @create 2017-06-08 16:45
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SysResourceService sysResourceService;

    public ResponseEntity<SuccessModel> register(User user) {
        if(user.getIssuer().equals(StatusBooks.IS_SURE_YSE)){
            user.setLoginaccount(user.getMailbox());
        }
        user.setVerificationcode(nextInt());
        if(!RegexValidateUtil.checkEmail(user.getMailbox())){
            throw new ServiceException("请正确填写邮箱");
        }
        if(!RegexValidateUtil.checkMobileNumber(user.getUserphone())){
            throw new ServiceException("请正确填写手机号");
        }
        int insert = userMapper.insert(user);
        IfUtil.insertIf(insert);
        return ApiResponse.success("注册成功");
    }

    public  String nextInt(){
        Random random = new Random();
        String result = "";
        for(int i = 0;i<6;i++){
            result += random.nextInt(10);
        }
        return result;
    }

    public ResponseEntity<SuccessModel> loginOut() {
        CurrentUserUtils.getInstance().delUser();
        return ApiResponse.success("退出登录");
    }

    public ResponseEntity<SuccessModel> login(User user) {
        SuccessModel successModel = new SuccessModel();
        final ResponseEntity<SuccessModel> successModelResponseEntity = new ResponseEntity<>(successModel, HttpStatus.OK);
        User san = userMapper.loginName(user.getLoginaccount());
        if(!StringUtil.isEmpty(san)){
            User sac = userMapper.login(user);
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
        List<Map<String, Object>> menus = sysResourceService.getMenus(user.getLoginaccount());
        String charAndNumr = GenerateRandomNumber.getCharAndNumr(5);
        String token = JwtHelper.createJWT(user.getLoginaccount(), 10000, charAndNumr);
        map.put("token", token);
        System.out.println(token);
        map.put("menus", menus);
        map.put("user", user);
        CurrentUserUtils.getInstance().serUser(map);
        return ApiResponse.success(map,"登录成功");
    }
}
