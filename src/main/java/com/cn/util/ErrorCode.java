package com.cn.util;

/**
 * 错误代码
 *
 * @author guowy
 * @create 2017-05-23 11:34
 **/

public enum ErrorCode {
    /**
     * 服务器内部错误
     *
     * <b>code: 1</b>
     */
    ERROR(1, "服务器内部错误"),

    /**
     * 非法参数
     */
    ILLEGAL_ARGUMENT(2, "非法参数"),

    /**
     * 查询信息失败
     */
    SEARCH_INFO_ERROR(3, "查询信息失败"),

    /**
     * 用户名不存在或密码错误
     */
    ILLEGAL_ACCOUNT_OR_PASSWORD(1000, "用户名不存在或密码不正确"),

    /**
     * 短信验证码不正确
     */
    INVALIDE_SMS_CODE(1001, "短信验证码不正确或已过期"),

    /**
     * 用户名已存在
     */
    REPEATED_USERNAME(1002, "用户名已存在"),

    /**
     * 手机号已存在
     */
    REPEATED_MOBILE(1003, "手机号已被注册"),

    /**
     * 短信发送过于频繁
     */
    SEND_SMS_MUCH(1004, "短信发送过于频繁"),

    /**
     * 非法用户名
     */
    ILLEGAL_USERNAME(1005, "用户名不满足要求"),

    /**
     * 非法手机号
     */
    ILLEGAL_MOBILE(1006, "请输入正确的手机号"),

    /**
     * 非法密码
     */
    ILLEGAL_PASSWORD(1007, "密码不满足复杂性要求"),

    /**
     * 用户名不存在或与手机号不匹配，请重新输入
     */
    MOBILE_NOT_EXIST_OR_NOT_MATCH_USERNAME(1008, "用户名不存在或与手机号不匹配，请重新输入"),

    /**
     * 该身份信息已存在
     */
    REPEATED_ID_CARD_NO(1009, "该身份信息已存在"),

    /**
     * 输入的密码不一致参数不能为空
     */
    NOT_SAME_PWD(1009,"原登录密码输入错误，请重新输入"),

    /**
     * 余额不足
     */
    MONEY_NOT_ENOUGH(1010, "余额不足"),

    /**
     * 优惠卷无效
     */
    ACTIVATION_ERROR(1012,"优惠卷无效"),

    /**
     * 两次输入的支付密码不一致
     */
    PAY_PASSWORD_NOT_SANME(1014,"两次输入的支付密码不一致"),

    /**
     * 用户不存在"
     */
    NOT_EXIST_ACCOUNT(1015,"用户不存在"),

    /**
     * 身份证信息不合法
     */
    ILLEGAL_SAFENAMEORCARDNUMBER(1016,"身份证信息不合法"),

    /**
     * 身份证号与实名认证信息不一致
     */
    IDNUMBER_NOT_SAME_AUTH_REALNAME(1017,"身份证号与实名认证信息不一致"),
    /**
     * 债权余额不足
     */
    LENDING_NOT_ENOUGH(1018, "债权余额不足"),
    /**
     * 新手标新手才能买
     */
    NEW_BUY_LIMIT(1019, "新手标新手才能买"),

    /**
     * 可用余额不足
     */
    AVAILABLE_BALANCE_NOT_ENOUGH(1020, "可用余额不足"),

    /**
     * 冻结余额不足
     */
    FREEZE_BALANCE_NOT_ENOUGH(1021,"冻结余额不足"),

    /**
     * 点添加优惠券时
     */
    INVALIDE_ADD_HBQ(1022,"红包只能兑换,不能在此添加"),

    /**
     * 已实名
     */
    REPEATED_REAL_NAME_AUTH(1023, "您已经做过实名认证"),
    /**
     *优惠券类型不匹配
     */
    COUPON_TYPE_NOT_MATCH(1023,"优惠券类型不匹配"),

    /**
     * 优惠券已使用
     */
    COUPON_ALREADY_USED(1024,"优惠券已使用"),

    /**
     * 优惠券已过期
     */
    COUPON_ALREADY_EXPIRED(1025,"优惠券已过期"),

    /**
     * 首信易转账处理失败
     */
    PAYEASE_FAIL(1026,"转账处理失败"),

    /**
     *卡号不存在
     */
    ACTIVATION_CODE_NOT_FOUND(1027,"卡号不存在"),

    /**
     * 卡号状态异常
     */
    ACTIVATION_CODE_STATUS_NOT_CORRECT(1028,"卡号状态异常"),

    /**
     * 卡号密码不正确
     */
    ACTIVATION_CODE_PASSWD_NOT_CORRECT(1029,"卡号密码不正确"),

    /**
     * 新手标只能买一次
     */
    NEW_BUY_ONLY_ONE(1030, "新手标只能购买一次"),

    /**
     * 支付密码锁定，请重置
     */
    INVALIDE_PAY_PASSWORD_0(1031, "支付密码锁定，请重置"),
    /**
     * 支付密码不正确，你还有N次输入机会，请重新输入
     */
    INVALIDE_PAY_PASSWORD_1(1032, "支付密码不正确，你还有1次输入机会，请重新输入"),
    INVALIDE_PAY_PASSWORD_2(1033, "支付密码不正确，你还有2次输入机会，请重新输入"),
    INVALIDE_PAY_PASSWORD_3(1034, "支付密码不正确，你还有3次输入机会，请重新输入"),

    INVALIDE_LOGIN_PASSWORD(1040, "您的帐号已经锁定"),
    INVALIDE_LOGIN_PASSWORD_0(1041, "您的帐号已经锁定，请{0}小时后重试"),
    INVALIDE_LOGIN_PASSWORD_1(1042, "用户名或密码错误,您还可输入1次,请重新输入"),
    INVALIDE_LOGIN_PASSWORD_2(1043, "用户名或密码错误,您还可输入2次,请重新输入"),
    INVALIDE_LOGIN_PASSWORD_3(1044, "用户名或密码错误,请重新输入"),
    INVALIDE_LOGIN_PASSWORD_4(1045, "用户名或密码错误,请重新输入"),
    NOT_INVALIDE_LOGIN_PASSWORD(1046, "账户名密码不能为空"),


    NOT_USER_BUY_TRANSFER_LENDING(1050, "您不能购买自己发布的转让债权"),


    LENDING_NOT_FOUND(1051,"购买债权不存在"),

    TRANSFER_LENDING_NOT_SUPPORT(1052,"不支持的转让类型"),

    U_PLAN_CLOSE(1060, "银多利已经关闭"),
    U_PLAN_PAY_ERROR(1061, "您购买的银多利支付失败"),
    U_PLAN_NOT_FOUND(1062, "银多利不存在"),
    U_PLAN_NOT_ENOUGH(1063, "您购买的银多利剩余金额不足"),

    /**
     * 实名认证失败次数超出限制
     */
    SAFENAME_CHECKFAILNUM(1064,"实名认证失败次数超出限制"),

    /**
     * 绑定银行卡失败次数超出限制
     */
    BINDINGBANKCARD_CHECKFAILNUM(1065,"绑定银行卡失败次数超出限制"),

    /**
     * 邀请码必须为6位数字或18位身份证号
     */
    INVITATION_LENGTH(1066,"邀请码必须为6位数字或18位身份证号"),
    /**
     * 邀请码无效，请输入正确的邀请码
     */
    INVITATION_FORMAT(1067,"邀请码无效，请输入正确的邀请码"),

    M_PLAN_CLOSE(1068, "月盈利已经关闭"),
    M_PLAN_PAY_ERROR(1069, "您购买的月盈利支付失败"),
    M_PLAN_NOT_FOUND(1070, "月盈利不存在"),
    M_PLAN_NOT_ENOUGH(1071, "您购买的月盈利剩余金额不足"),
    M_PLAN_NOT_DATE(1072, "计划募集期未开始,无法募集"),
    M_PLAN_BUY_INCREASE(1073, "您的支付金额必须是递增金额的整数倍"),
    M_PLAN_BUY_AMOUNT(1074, "您的支付金额必须是计划的剩余金额"),
    /**
     * 充值失败
     */
    RECHARGE_ERROR(1075,"充值失败"),

    /**
     * 您当前账户余额不为0，无法解绑银行卡
     */
    CANCEL_BINDING_BANKCARD(1076,"您当前账户余额不为0，无法解绑银行卡"),

    /**
     * 银行卡不存在
     */
    NOT_EXIST_BANKCARD(1077,"银行卡不存在"),

    /**
     * 银行卡不支持快捷支付
     */
    BANKCARD_NOT_SUPPORT_QUICK_PAY(1078,"银行卡不支持快捷支付"),


    /**
     * 新手标不存在
     */
    NEW_LENDING_NOT_FOUND(1079, "新手标不存在"),

    /**
     * 新手标已经关闭
     */
    NEW_LENDING_CLOSE(1080, "新手标已经关闭"),

    /**
     * 新手标支付失败
     */
    NEW_LENDING_PAY_ERROR(1081, "您购买的新手标支付失败"),

    /**
     * 新手标剩余金额不足
     */
    NEW_LENDING_NOT_ENOUGH(1082, "您购买的新手标剩余金额不足"),

    /**
     * 新手标募集期未开始
     */
    NEW_LENDING_NOT_DATE(1083, "新手标募集期未开始,无法募集"),

    /**
     * 您的支付金额必须是计划的剩余金额
     */
    NEW_LENDING_BUY_AMOUNT(1084, "您的支付金额必须是计划的剩余金额"),

    /**
     * 投资金额超出允许的最大投资限额
     */
    OUT_OF_MAXAMOUNT(1085,"投资金额超出允许的最大投资限额"),

    /**
     * 新手标投资金额必须等于起投金额
     */
    NEW_LENDING_NOT_MINAMOUNT(1086,"投资金额必须等于起投金额"),

    /**
     * 该活动不存在
     */
    ACTIVITY_NOT_FOUND(1087,"该活动不存在"),

    /**
     * 优惠券使用异常
     */
    COUPON_USE_ERROR(1088,"优惠券使用异常"),




    /**
     * 手机号不能为空
     */
    PHONE_NOT_NULL(2000,"手机号不能为空"),

    /**
     * 密码不能为空
     */
    PASSWORD_NOT_NULL(2001,"密码不能为空"),
    /**
     * 客户端类型不能为空
     */
    CLIENT_NOT_NULL(2002,"客户端类型不能为空"),

    /**
     * 用户名不能为空
     */
    USER_NOT_NULL(2003,"用户名不能为空"),

    /**
     * 用户没有登录，没有操作权限
     */
    NO_LOGIN(2004,"用户没有登录，没有操作权限"),


    /**
     * 未实名认证
     */
    NO_REAL_NAME_AUTH(2005, "未进行实名认证"),

    PAY_PWD_SIX(2006, "密码长度为6位"),

    CHECK_CODE(2007, "校验码不能为空"),

    AMOUNT_OF_LOAN(2008, "出借金额不能为空！"),


    CREDIT_NUMBER(2009, "债权编号不能为空！"),

    TRANSFER_NUMBER(2010, "转让编号不能为空！"),

    USER_ID_NOT(2011, "用户ID不能为空！"),

    TRSNSACTION_AMOUNT(2012, "交易金额不能为空！"),

    INFO_ID_NOT(2013, "消息Id不能为空！"),

    NO_RISK_ASSESSMENT(2014, "未进行风险评估！"),

    NO_PASSWORD_SET(2015, "未进行密码设置！"),

    NO_BIND_BANKCARD(2016, "未绑定银行卡！"),

    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode (int  code ,String message){
        this.code = code;
        this.message =message;

    }
}
