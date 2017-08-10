package com.cn.JDBC;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by newtouch on 2017/8/4.
 */
public class JDBC_MySql_DataTable {

    public String[] column;//列字段
    public String[][] row; //行值
    public int rowCount = 0;//行数
    public int colCoun = 0;//列数

    public JDBC_MySql_DataTable(){
        super();
    }

    public JDBC_MySql_DataTable(String[] column,String[][] row,int rowCount,int colCoun){
        super();
        this.colCoun = colCoun;
        this.rowCount = rowCount;
        this.column = column;
        this.row = row;
    }

    public void setDataTable(ArrayList<HashMap<String, String>> list){
        rowCount = list.size();
        colCoun = list.get(0).size();
        column = new String[colCoun];
        row = new String[colCoun][rowCount];
    }

    public String[] getColumn() {
        return column;
    }

    public void setColumn(String[] column) {
        this.column = column;
    }

    public String[][] getRow() {
        return row;
    }

    public void setRow(String[][] row) {
        this.row = row;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColCoun() {
        return colCoun;
    }

    public void setColCoun(int colCoun) {
        this.colCoun = colCoun;
    }
}
