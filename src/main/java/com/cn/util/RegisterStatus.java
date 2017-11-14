package com.cn.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by newtouch on 2017/11/9.
 */
public enum RegisterStatus {


    BACK_PASSWORD_STEP_ONE("100", "注册第一步，验证邮箱"),
    BACK_PASSWORD_STEP_TWO("200", "注册第二步，发送邮箱验证码"),
    BACK_PASSWORD_STEP_THREE("300", "注册第三步，校验验证码"),
    BACK_PASSWORD_STEP_FOUR("400", "注册第四步，修改密码"),

    UPDATE_PASSWORD_STEP_ONE("500", "修改密码第一步，校验旧密码"),
    UPDATE_PASSWORD_STEP_TWO("600", "修改密码第二步，修改新密码"),;

    String value;
    String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    RegisterStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static RegisterStatus getStep(String value) {
        RegisterStatus[] values = RegisterStatus.values();
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        for (RegisterStatus status : values) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        return null;
    }
}