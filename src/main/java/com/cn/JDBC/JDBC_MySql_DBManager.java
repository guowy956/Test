package com.cn.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by newtouch on 2017/8/4.
 */
public class JDBC_MySql_DBManager {

    private PreparedStatement pstment;

    private ResultSet rs;

    private Connection conn;

    public JDBC_MySql_DBManager(){
        conn = JDBC_MySql.getDBConnection();
    }

    /**
       * 执行修改添加操作
       * @param coulmn
       * @param type
       * @param sql
       * @return
       * @throws SQLException
       */
    public  boolean updateOrAdd(String[] coulmn, int[] type, String sql) throws SQLException {
        if(!setPstmtParam(coulmn,type,sql)){
            return false;
        }
        Boolean flag = pstment.executeUpdate()>0 ? true:false;
        closeDB();
        return flag;
    }

    /**
     * 获取查询结果集
     * @param coulmn
     * @param type
     * @param sql
     * @throws SQLException
     */
    public JDBC_MySql_DataTable getResultData(String[] coulmn, int[] type, String sql){

        return null;
    }


    /**
     * 关闭数据库
     * @throws SQLException
     */
    private void closeDB() throws SQLException
    {
        if(rs != null)
        {
            rs.close();
        }
        if(pstment != null)
        {
            pstment.close();
        }
        if(conn != null)
        {
            conn.close();
        }

    }

     /**
       * 参数设置
       * @param coulmn
       * @param type
       * @throws SQLException
       * @throws NumberFormatException
       */
    private boolean setPstmtParam(String[] coulmn, int[] type, String sql) throws SQLException {
        if(sql==null){
            return false;
        }
        pstment = conn.prepareStatement(sql);

        if(coulmn != null && type != null && coulmn.length !=0 && type.length !=0   ){
            for (int i = 0; i < type.length ; i++) {
                switch (type[i]){
                    case Types.INTEGER:
                        pstment.setInt(i+1,Integer.parseInt(coulmn[i]));
                        break;
                    case Types.BOOLEAN:
                        pstment.setBoolean(i+1,Boolean.parseBoolean(coulmn[i]));
                        break;
                    case Types.CHAR:
                        pstment.setString(i+1,coulmn[i]);
                        break;
                    case Types.DOUBLE:
                        pstment.setDouble(i+1,Double.parseDouble(coulmn[i]));
                        break;
                    case Types.FLOAT:
                        pstment.setFloat(i+1,Float.parseFloat(coulmn[i]));
                        break;
                    default:
                        break;
                }
            }
        }
        return true;
    }


    public PreparedStatement getPstment() {
        return pstment;
    }

    public void setPstment(PreparedStatement pstment) {
        this.pstment = pstment;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
