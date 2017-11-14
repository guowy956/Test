package com.cn.swagger2.API;

import com.cn.exception.BusinessException;
import com.cn.redis.RedisUtils;
import com.cn.service.RegisterManage;
import com.cn.util.ApiResponse;
import com.cn.util.RandomUtil;
import com.cn.util.RegisterStatus;
import com.cn.util.SendMailUtil;
import io.swagger.annotations.ApiParam;
import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

/**
 * Created by newtouch on 2017/11/6.
 */


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-07T09:32:08.696Z")

@Controller
public class RegisterApiController extends BaseController implements RegisterApi {


    @Autowired
    private RegisterManage registerManage;

    @Autowired
    private SendMailUtil sendMailUtil;

    @Autowired
    private RedisUtils redisUtils;

    private String REGISTER_SEND_MAIL = "注册";

    @Override
    public ResponseEntity<SuccessModel> register(
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
    ) {
        Boolean flag = registerManage.findBy(userName,loginAccount,realName,mailbox);
        if(flag){
            throw new BusinessException("用户已存在,不可重复注册");
        }
        if(step.equals(RegisterStatus.BACK_PASSWORD_STEP_ONE)){
            Boolean mailFlag = registerManage.findByMail(mailbox);
            if(mailFlag){
                throw new BusinessException("这个邮箱已经注册过了");
            }else{
                return ApiResponse.success("邮箱可用");
            }
        }else if(step.equals(RegisterStatus.BACK_PASSWORD_STEP_TWO)){
            //获取验证码
            String random = RandomUtil.getRandom();
            redisUtils.set(mailbox,random);
            sendMailUtil.sendMailForHtml(mailbox,random,REGISTER_SEND_MAIL);
        }else if(step.equals(RegisterStatus.BACK_PASSWORD_STEP_THREE)){
            //redis 验证 邮箱验证码是否正确
        }else if(step.equals(RegisterStatus.BACK_PASSWORD_STEP_FOUR)){
//            注册 -- 进行存库
            registerManage.registerSave(userName,loginAccount,realName,userPass,invitationCode,mailbox,verificationCode,sex,currentAddress,isSuer,userPhone);
        }


        return null;
    }
}
