package com.cn.swagger2.API;

import com.cn.model.login.Login;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * ShopAppCustomerApi
 *
 * @author guowy
 * @create 2017-05-27 15:05
 **/
//@Auth
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-09T10:04:35.830Z")
@Api(value = "Login", description = "the Login API")
public interface LoginApi {

    @ApiOperation(value = "登录", notes = "登录 ",  tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = SuccessModel.class) })
    @RequestMapping(value = "/login",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<SuccessModel> login( @ApiParam(value = "登陆信息") @RequestBody Login login);
    @ApiOperation(value = "登出", notes = "登出 ",  tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" ,response = SuccessModel.class),
            @ApiResponse(code = 200, message = "unexpected error") })
    @RequestMapping(value = "/loginOut",
            method = RequestMethod.GET)
    ResponseEntity<SuccessModel> loginOut();

    @ApiOperation(value = "注册",notes = "注册" ,tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" , response = SuccessModel.class),
            @ApiResponse(code = 200, message = "Successful error" ) })
    @RequestMapping(value = "register", method = RequestMethod.POST)
    ResponseEntity<SuccessModel> register (
            @NotNull @ApiParam(value = "用户名",required = true)@RequestParam(name = "userName") String userName,
            @ApiParam(value = "登录账户")@RequestParam(name = "loginAccount") String loginAccount,
            @NotNull @ApiParam(value = "真实姓名",required = true)@RequestParam(name = "realName") String realName,
            @NotNull @ApiParam(value = "密码",required = true)@RequestParam(name = "userPass") String userPass,
            @NotNull @ApiParam(value = "验证码",required = true)@RequestParam(name = "verificationCode") String verificationCode,
            @ApiParam(value = "邀请码")@RequestParam(name = "invitationCode") String invitationCode,
            @NotNull @ApiParam(value = "邮箱",required = true)@RequestParam(name = "mailbox") String mailbox,
            @NotNull @ApiParam(value = "性别",required = true)@RequestParam(name = "sex") String sex,
            @NotNull @ApiParam(value = "现地址",required = true)@RequestParam(name = "currentAddress") String currentAddress,
            @ApiParam(value = "是否将邮箱当作登录账户")@RequestParam(name = "isSuer") String isSuer,
            @NotNull @ApiParam(value = "手机号",required = true)@RequestParam(name = "userPhone") String userPhone
    );

}
