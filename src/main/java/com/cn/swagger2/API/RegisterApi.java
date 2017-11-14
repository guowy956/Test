package com.cn.swagger2.API;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * Created by newtouch on 2017/11/6.
 */


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-07T09:32:08.696Z")
@Api(value = "register", description = "the register API")
public interface RegisterApi {



    @ApiOperation(value = "注册",notes = "注册" ,tags = {"注册",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response" , response = SuccessModel.class),
            @ApiResponse(code = 200, message = "Successful error" ) })
    @RequestMapping(value = "register", method = RequestMethod.POST)
    ResponseEntity<SuccessModel> register (
            @NotNull @ApiParam(value = "用户名",required = true)@RequestParam(name = "userName") String userName,
            @ApiParam(value = "登录账户")@RequestParam(name = "loginAccount") String loginAccount,
            @NotNull @ApiParam(value = "真实姓名",required = true)@RequestParam(name = "realName") String realName,
            @NotNull @ApiParam(value = "密码",required = true)@RequestParam(name = "userPass") String userPass,
            @ApiParam(value = "邀请码")@RequestParam(name = "invitationCode") String invitationCode,
            @NotNull @ApiParam(value = "邮箱",required = true)@RequestParam(name = "mailbox") String mailbox,
            @NotNull @ApiParam(value = "验证码",required = true)@RequestParam(name = "verificationCode") String verificationCode,
            @NotNull @ApiParam(value = "性别",required = true)@RequestParam(name = "sex") String sex,
            @NotNull @ApiParam(value = "现地址",required = true)@RequestParam(name = "currentAddress") String currentAddress,
            @ApiParam(value = "是否将邮箱当作登录账户")@RequestParam(name = "isSuer") String isSuer,
            @NotNull @ApiParam(value = "手机号",required = true)@RequestParam(name = "userPhone") String userPhone,
            @NotNull @ApiParam(value = "步骤",required = true)@RequestParam(name = "step") String step
    );

}
