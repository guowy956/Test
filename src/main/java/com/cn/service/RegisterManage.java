package com.cn.service;

import com.cn.mapper.BaseManage;
import com.cn.model.domain.User;
import com.cn.model.domain.UserExample;
import com.cn.util.MD5;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by newtouch on 2017/11/6.
 */
@Service
public class RegisterManage extends BaseManage<Long> {


    @Autowired
    private RegisterService<User,UserExample,Long> service;

    @Override
    public  RegisterService<User,UserExample,Long> getService() {
        return service;
    }

    public Boolean findBy(String userName,String loginAccount, String realName, String mailbox) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append(" FROM ")
                .append(" USER U ")
                .append(" WHERE 1=1 ");
        if(StringUtils.isNotBlank(userName)){
            sql.append(" AND U.USERNAME = "+userName+" ");
        }
        if(StringUtils.isNotBlank(loginAccount)){
            sql.append(" OR U.LOGINACCOUNT = "+loginAccount+" ");
        }
        if(StringUtils.isNotBlank(realName)){
            sql.append(" OR U.REALNAME = "+realName+" ");
        }
        if(StringUtils.isNotBlank(mailbox)){
            sql.append(" OR U.MAILBOX="+mailbox+" ");
        }
        int count  = getService().countBySQL(sql.toString());
        return count == 0 ? false : true;
    }

    public Boolean findByMail(String mailbox) {
        UserExample example = new UserExample();
        example.or().andMailboxEqualTo(mailbox);
        int count = getService().countByExample(example);
        return count == 0 ? false : true;
    }

    public int registerSave(String userName, String loginAccount, String realName, String userPass,
                             String invitationCode, String mailbox, String verificationCode, String sex
            , String currentAddress, String isSuer, String userPhone) {
        com.cn.model.domain.User user = new com.cn.model.domain.User();
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
        return getService().save(user);
    }
}
