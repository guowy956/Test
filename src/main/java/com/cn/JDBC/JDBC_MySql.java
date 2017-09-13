package com.cn.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by newtouch on 2017/8/4.
 */
public class JDBC_MySql {

    public  static Connection getDBConnection(){
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        获取数据库的连接
        try {
            Connection connection = DriverManager.getConnection("dbc:mysql://localhost:3306/shop_app?" +
                            "useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull",
                    "root","");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
