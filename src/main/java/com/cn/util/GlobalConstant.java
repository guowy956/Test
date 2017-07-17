package com.cn.util;

/**
 * 枚举集体
 *
 * @author guowy
 * @create 2017-05-23 11:13
 **/

public final class GlobalConstant {
    public static final String hasModulePrivilege = "hasModulePrivilege";
    public static final String allPrivilege = "ALL";
    public static final String superPrivilege = "Super";
    public static final int superId = 5;
    public static final String dfyg = "www";
    public static final String isModule = "isModule";
    public static final String uri = "uri";
    public static final String menu = "menu";
    public static final int rootlevel = 0;//所有节点的根节点
    public static final int rootMenuLevel = 1;//根节点跟系统或公司对应，比如银谷在线、银谷普惠等
    public static final int menuLevel2 = 2;//功能管理模块比如：文章管理、图片管理
    public static final int menuLevel3 = 3;//功能的分类比如：录入、列表
    public static final int menuLevel4 = 4;//4（包含）以下是功能节点
    public static final int menuLevel5 = 5;//更细的功能比如：上传

    public static final int pageSize = 15;
    public static final int currentPage = 1;

    public static final String exceptionMsg = "出错了，请联系管理员";
}
