package com.cn.swagger2.API;

import com.cn.model.entity.User;
import com.cn.model.login.Login;
import com.cn.service.UserService;
import com.cn.util.MD5;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * 登录
 *
 * @author guowy
 * @create 2017-05-27 15:03
 **/
@Controller
public class LoginController extends BaseController implements LoginApi{

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<SuccessModel> login (@ApiParam(value = "登陆信息") @RequestBody Login login) {
        User user = new User();
        user.setLoginaccount(login.getUsername());
        user.setUserpass(MD5.convertMD5(login.getPassword()));
        ResponseEntity<SuccessModel> flag = userService.login(user);
        return flag;
    }

    @Override
    public ResponseEntity<SuccessModel> register(
            @NotNull @ApiParam(value = "用户名", required = true) @RequestParam(name = "userName") String userName,
            @NotNull @ApiParam(value = "登录账户", required = true) @RequestParam(name = "loginAccount") String loginAccount,
            @NotNull @ApiParam(value = "真实姓名", required = true) @RequestParam(name = "realName") String realName,
            @NotNull @ApiParam(value = "密码", required = true) @RequestParam(name = "userPass") String userPass,
            @NotNull @ApiParam(value = "验证码", required = true) @RequestParam(name = "verificationCode") String verificationCode,
            @ApiParam(value = "邀请码") @RequestParam(name = "invitationCode") String invitationCode,
            @NotNull @ApiParam(value = "邮箱", required = true) @RequestParam(name = "mailbox") String mailbox,
            @NotNull @ApiParam(value = "性别", required = true) @RequestParam(name = "sex") String sex,
            @NotNull @ApiParam(value = "现地址", required = true) @RequestParam(name = "currentAddress") String currentAddress,
            @ApiParam(value = "是否将邮箱当作登录账户") @RequestParam(name = "isSuer") String isSuer,
            @NotNull @ApiParam(value = "手机号", required = true) @RequestParam(name = "userPhone") String userPhone) {
        User user = new User();
        user.setUsername(userName);
        user.setLoginaccount(loginAccount);
        user.setRealname(realName);
        user.setUserpass(MD5.convertMD5(userPass));
        user.setVerificationcode(verificationCode);
        user.setInvitationcode(invitationCode);
        user.setMailbox(mailbox);
        user.setSex(sex);
        user.setCurrentaddress(currentAddress);
        user.setIssuer(isSuer);
        user.setUserphone(userPhone);
        ResponseEntity<SuccessModel> flag  = userService.register(user);
        return flag;
    }

    @Override
    public ResponseEntity<SuccessModel> loginOut() {
        return userService.loginOut();
    }
}
