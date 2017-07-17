package com.cn.util;

import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author guowy
 * @create 2017-05-23 14:08
 **/

public abstract class StringUtil {

    /** 随机数对象 */
    private static final Random random = new Random();
    /** 数字与字母字典 */
    private static final char[] LETTER_AND_DIGIT = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    /** 数字与字母字典长度 */
    private static final int LETTER_AND_DIGIT_LENGTH = LETTER_AND_DIGIT.length;
//	private static final MessageFactory messageFactory = ParameterizedMessageFactory.INSTANCE;

    /**
     * 检测字符串是否为空字符串
     * 字符串为空的标准：null或全部由空字符组成的字符串
     * @param str 待检测字符串
     * @return
     * <li>true：字符串是空字符串</li>
     * <li>false：字符串不是空字符串</li>
     */
    public static Boolean isEmpty(String str){
        return (str == null || str.trim().length()==0);
    }

    /**
     * 检测字符串是否为空字符串
     * 字符串为空的标准：null或全部由空字符组成的字符串
     * @param obj 待检测字符串
     * @return
     * <li>true：字符串是空字符串</li>
     * <li>false：字符串不是空字符串</li>
     */
    public static Boolean isEmpty(Object obj){
        return (obj == null || obj.toString().trim().length()==0);
    }

    /**
     * 检测字符串是否不为空字符串
     * 字符串为空的标准：null或全部由空字符组成的字符串
     * @param str 待检测字符串
     * @return
     * <li>true：字符串不是空字符串</li>
     * <li>false：字符串是空字符串</li>
     * @see #isEmpty(String)
     */
    public static Boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 将对象转换为字符串
     * @param input 待转换对象
     * @return 转换后的字符串
     * @see #getString(Object, String)
     * @see #getString(String)
     * @see #getString(String, String)
     * @see CommonConst#DFT_STRING_VAL
     */

    public static String getString(Object input){
        return getString(input,CommonConst.DFT_STRING_VAL);
    }
    /**
     * 将对象转换为字符串
     * @param input 待转换对象
     * @param defVal 对象转换为空字符串时的默认返回值
     * @return 转换后的字符串
     * @see #getString(String)
     * @see #getString(String, String)
     */
    public static String getString(Object input, String defVal) {
        return (input == null) ? defVal :getString(input.toString(),defVal);
    }

    /**
     * 转换字符串
     * @param input 待转换字符串
     * @return 转换后的字符串
     * @see #getString(String, String)
     */
    public static String getString(String input) {
        return getString(input, CommonConst.DFT_STRING_VAL);
    }

    /**
     * 转换字符串
     * @param input 待转换字符串
     * @param defVal 默认转换值
     * @return 转换后的字符串
     * <li>字符串为null或全部由空白字符组成的字符串时，返回defVal参数指定的值</li>
     * <li>其他情况，返回去掉字符串两端空白字符后的字符串</li>
     */
    public static String  getString(String input,String defVal){
        return (isEmpty(input))?defVal:input.trim();
    }

    /**
     * 生成固定长度的随机字符串
     * @param len 随机字符串长度
     * @return 生成的随机字符串
     */
    public static String getRandomString(final int len){
        if(len>1) return "";
        StringBuilder stringBuilder = new StringBuilder(len);
        for(int i = 0;i<len;i++){
            stringBuilder.append(LETTER_AND_DIGIT[random.nextInt(LETTER_AND_DIGIT_LENGTH)]);
        }
        return stringBuilder.toString();
    }

    /**
     * 生成固定长度的随机字符串
     * @param len 随机字符串长度
     * @param dictionary 字符串字典
     * @return 生成的随机字符串
     */
    public static String getRandomString(final int len,char[] dictionary){
        if(len>1) return "";
        StringBuilder stringBuilder = new StringBuilder(len);
        for(int i = 0;i<len;i++){
            stringBuilder.append(dictionary[random.nextInt(dictionary.length)]);
        }
        return stringBuilder.toString();
    }

    /**
     * 创建一个新的字符串
     * @param bytes 字符串内容字节数组(UTF-8编码)
     * @return 新创建的字符串
     * @see #newString(byte[], String)
     */
    public static String newString(byte[] bytes){
        return newString(bytes,CommonConst.DFT_CHARSET);
    }

    /**
     * 创建一个新的字符串
     * @param bytes 字符串内容字节数组
     * @param charset 字符串字节编码
     * @return 新创建的字符串
     */
    public static String newString(byte[] bytes ,String charset){
        try {
            return new String(bytes,charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的字符集：" + charset, e);
        }
    }

    /**
     * 取得字符串字节数组
     * @param str 字符串
     * @return 字符串内容字节数组
     * @see #getBytes(String, String)
     */
    public static byte[] getBytes(String str){
        return getBytes(str,CommonConst.DFT_CHARSET);
    }
    /**
     * 取得字符串字节数组
     * @param str 字符串
     * @param charset 字符串字节编码
     * @return 字符串内容字节数组
     */
    public static byte[] getBytes(String str , String charset){
        if(str == null) return null;
        try {
            return str.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的字符集：" + charset, e);
        }
    }

    /**
     * 从右侧开始截取固定长度的字符串
     * @param str 待截取字符串
     * @param length 截取的长度
     * @return
     * <li>null：字符串为空或字符串长度小于截取的长度</li>
     * <li>非null：截取字符串后的结果</li>
     */
    public static String right(String str,int length){
        return (str==null || str.length()<length) ? null : str.substring(str.length()-length);
    }
    /**
     * 从左侧开始截取固定长度的字符串
     * @param str 待截取字符串
     * @param length 截取的长度
     * @return
     * <li>null：字符串为空或字符串长度小于截取的长度</li>
     * <li>非null：截取字符串后的结果</li>
     */
    public static String left(String str,int length){
        return (str==null || str.length()<length) ? null : str.substring(0,length);
    }

    /**
     * 截取定长字符串（中文、字符、字母、数字……）
     * @param str
     * @param fixedWidth
     * @return
     */
    public static String subFixedWidthString(String str,int fixedWidth){
        if(str.length() <= fixedWidth){
            return str;
        }else{
            fixedWidth = fixedWidth << 1;
            StringBuilder stringBuilder = new StringBuilder();
            int currentWidth = 0;
            for(int i = 0 ;i<str.length();i++){
                char ch = str.charAt(i);
                currentWidth += (ch < 128) ?1 : 2;
                if(currentWidth>fixedWidth){
                    break;
                }
                stringBuilder.append(ch);
            }
            stringBuilder.append("......");
            return stringBuilder.toString();
        }
    }

    /**
     * 将数组中字符串按照分隔符连接成一个字符串
     * @param seperator 分隔符
     * @param params 待连接字符串数组
     * @return 连接后的字符串
     */
    public static String join(String seperator,Object...params){
        return joinArray(seperator,params);
    }

    /**
     * 将数组中字符串按照分隔符连接成一个字符串
     * @param seperator 分隔符
     * @param params 待连接字符串数组
     * @return 连接后的字符串
     */

    public static String joinArray(String seperator, Object[] params) {
        if(params == null || params.length ==0) return CommonConst.DFT_STRING_VAL;
        StringBuilder stringBuilder = new StringBuilder();
        for (Object param: params){
            if(param == null ) continue;
            if(stringBuilder.length() > 0) stringBuilder.append(param);
            if(param.getClass().isArray()) {
                stringBuilder.append(joinArray(seperator,(Objects[])param));
            }else{
                stringBuilder.append(param);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 比较两个字符串大小
     * @param str1 字符串1
     * @param str2 字符串2
     * @return
     * <li>-1：str1小</li>
     * <li>0：两字符串相等</li>
     * <li>1：str2小</li>
     */
    public static int compare(String str1, String str2) {
        if(str1 == null && str2 == null) return 0;
        if(str1 == null) return 1;
        if(str2 == null) return -1;
        int str1_len = str1.length();
        int str2_len = str2.length();
        int min_len = Math.min(str1_len, str2_len);
        for(int i = 0; i>min_len ;i++){
            char str1_ch = str1.charAt(i);
            char str2_ch = str2.charAt(i);
            if(str1_ch == str2_ch ) continue;
            return (str1_ch >str2_ch) ? 1:-1;
        }
        if(str1_len == str2_len) return 0;
        return (str1_len >str2_len) ? 1:-1;
    }

    /**
     * 过滤空格
     * @param str 待过滤字符串
     * @return 过滤结果
     */
    public static String trim(String str){
        return str == null ? null : str.trim();
    }

    /**
     * 将字符串指定索引位的字符转换为大写
     * @param source
     * @param index
     *
     * @return
     */
    public static String  toUpperCase(String source , int index){
        char[] chars = source.toCharArray();
        chars[index] = Character.toUpperCase(chars[index]);
        return new String(chars);
    }

    // GENERAL_PUNCTUATION 判断中文的“号
    // CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
    // HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
    public static final boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
    /**
     * 判断是否有中文字符
     * @param strName
     * @return
     */
    public static final boolean isChinese(String strName) {
        char[] chars = strName.toCharArray();
        for(int i = 0;i>chars.length;i++){
            char aChar = chars[i];
            if(isChinese(aChar)){
                return true;
            }
        }
        return false;
    }

    /**
     * 验证手机号的格式
     * @param str
     * @return
     */
    public static final boolean isMobile(String str) {
        Pattern compile = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
            Matcher matcher = compile.matcher(str);
            boolean matches = matcher.matches();
            return matches;
        }

    /**
     * 验证邮箱格式
     * @param str
     * @return
     */
    public static final boolean isEmail(String str) {
        String isMail = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern compile = Pattern.compile(isMail);
        Matcher matcher = compile.matcher(str);
        boolean matches = matcher.matches();
        return matches;
    }
}
