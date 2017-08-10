package com.cn.JDBC;

import java.sql.Driver;
import java.sql.SQLException;

/**
 * Created by newtouch on 2017/8/4.
 */
public class JDBC_Oracle {


    public static String Commonced(){

        try {
            //加载oracle驱动类，并且实例化
            Driver driver = (Driver) Class.forName("").newInstance();
            //判定指定的URL oracle驱动能否接受(符合oracle协议规则)
            Boolean flag =  driver.acceptsURL("");
            boolean standardFlag1 = driver.acceptsURL("jdbc:oracle:thin:@//<host>:<port>/ServiceName");
            boolean standardFlag2 = driver.acceptsURL("jdbc:oracle:thin:@<host>:<port>:<SID>");
            System.out.println("协议测试："+flag+"\t"+standardFlag1+"\t"+standardFlag2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Commonced();
    }
}