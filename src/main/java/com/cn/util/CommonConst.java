package com.cn.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Timestamp;
import java.util.Date;

/**
 * 全局常量接口
 *
 * @author guowy
 * @create 2017-05-23 11:29
 **/

public interface CommonConst {

    /** 默认字符 */
    String DFT_CHARSET = "UTF-8";
    /** 日期格式 */
    String DFT_DATE_FORMAT = "yyyy-MM-dd";
    /** 日期时间格式 */
    String DFT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 时间格式 */
    String DFT_TIME_FORMAT = "HH:mm:ss";

    /** 每秒的毫秒数 */
    int MILL_SECONDS_PER_SECOND = 1000;
    /** 每分钟秒数 */
    int SECONDS_PER_MINUTE = 60;
    /** 每分钟毫秒数 */
    int MILL_SECONDS_PER_MINUTE = MILL_SECONDS_PER_SECOND * SECONDS_PER_MINUTE;
    /** 每小时分钟数 */
    int MINUTES_PER_HOUR = 60;
    /** 每小时秒数 */
    int SECONDS_PER_HOUR = MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
    /** 每小时毫秒数 */
    int MILL_SECONDS_PER_HOUR = SECONDS_PER_HOUR * MILL_SECONDS_PER_SECOND;
    /** 每天小时数 */
    int HOURS_PER_DAY = 24;
    /** 每天分钟数 */
    int MINUTES_PER_DAY = HOURS_PER_DAY * MINUTES_PER_HOUR;
    /** 每天秒数 */
    int SECONDS_PER_DAY = MINUTES_PER_DAY * SECONDS_PER_MINUTE;
    /** 每天毫秒数 */
    int MILL_SECONDS_SECOND_PER_DAY = SECONDS_PER_DAY * MILL_SECONDS_PER_SECOND;

    /** 默认整数值 */
    int DFT_INTEGER_VAL = 0;
    /** 默认字节值 */
    byte DFT_BYTE_VAL = 0;
    /** 默认短整数值 */
    short DFT_SHORT_VAL = 0;
    /** 默认长整数值 */
    long DFT_LONG_VAL = 0L;
    /** 默认单精度浮点数值 */
    float DFT_FLOAT_VAL = 0.0F;
    /** 默认双精度浮点数值 */
    double DFT_DOUBLE_VAL = 0.0D;
    /** 默认布尔值 */
    boolean DFT_BOOLEAN_VAL = false;
    /** 默认字符串值 */
    String DFT_STRING_VAL = "".intern();
    /** 默认字符串值-NULL */
    String DFT_NULL_STRING_VAL = "NULL".intern();
    /** 默认大整数数值 */
    BigInteger DFT_BIGINTEGER_VAL = new BigInteger("0");
    /** 默认大小数数值 */
    BigDecimal DFT_BIGDECIMAL_VAL = new BigDecimal("0");
    /** 默认日期数值 */
    Date DFT_DATE_VAL = null;
    /** 默认时间戳值 */
    Timestamp DFT_TIMESTAMP_VAL = null;

    /** 空Object数组 */
    Object[] EMPTY_OBJECT_ARRAY = new Object[]{};
    /** 空整型数组 */
    int[] EMPTY_INTEGER_ARRAY = new int[]{};
    /** 空整数对象类型数组 */
    Integer[] EMPTY_INTEGER_WRAP_ARRAY = new Integer[]{};
    /** 空字节类型数组 */
    byte[] EMPTY_BYTE_ARRAY = new byte[]{};
    /** 空字节对象类型数组 */
    Byte[] EMPTY_BYTE_WRAP_ARRAY = new Byte[]{};
    /** 空短整数类型数组 */
    short[] EMPTY_SHORT_ARRAY = new short[]{};
    /** 空短整数对象类型数组 */
    Short[] EMPTY_SHORT_WRAP_ARRAY = new Short[]{};
    /** 空长整数类型数组 */
    long[] EMPTY_LONG_ARRAY = new long[]{};
    /** 空长整数对象类型数组 */
    Long[] EMPTY_LONG_WRAP_ARRAY = new Long[]{};
    /** 空单精度浮点类型数组 */
    float[] EMPTY_FLOAT_ARRAY = new float[]{};
    /** 空单精度浮点对象类型数组 */
    Float[] EMPTY_FLOAT_WRAP_ARRAY = new Float[]{};
    /** 空双精度浮点类型数组 */
    double[] EMPTY_DOUBLE_ARRAY = new double[]{};
    /** 空双精度浮点对象类型数组 */
    Double[] EMPTY_DOUBLE_WRAP_ARRAY = new Double[]{};
    /** 空布尔类型数组 */
    boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[]{};
    /** 空布尔对象类型数组 */
    Boolean[] EMPTY_BOOLEAN_WRAP_ARRAY = new Boolean[]{};
    /** 空字符串类型数组 */
    String[] EMPTY_STRING_ARRAY = new String[]{};
    /** 空大整数类型数组 */
    BigInteger[] EMPTY_BIGINTEGER_ARRAY = new BigInteger[]{};
    /** 空大小数类型数组 */
    BigDecimal[] EMPTY_BIGDECIMAL_ARRAY = new BigDecimal[]{};
    /** 空日期类型数组 */
    Date[] EMPTY_DATE_ARRAY = new Date[]{};
    /** 空时间戳类型数组 */
    Timestamp[] EMPTY_TIMESTAMP_ARRAY = new Timestamp[]{};

    /** 默认名称 */
    String CNAME = "nature";
    /**缓存key分隔符*/
    String CACHE_KEY_SEPARATOR = "_";


    // ~~~~~~~~~~~~~~session变量
    public static final String SESSION_USERNAME = "userName"; // 用户账户
    public static final String SESSION_REALNAME = "realName"; // 用户姓名
    public static final String SESSION_USERMOBILE = "userMobile"; // 用户手机
    public static final String SESSION_USEREMAIL = "userEmail"; // 用户邮箱
    public static final String SESSION_LASTLOGONTIME= "lastLogonTime"; // 最近登录时间
    public static final String SESSION_USERCARD= "userCard"; // 最近登录时间
}
