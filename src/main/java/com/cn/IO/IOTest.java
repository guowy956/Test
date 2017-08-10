package com.cn.IO;

import java.io.*;

/**
 * Created by newtouch on 2017/8/3.
 */
public class IOTest {



    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                System.out.println(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }



    public static void main(String[] args) {
        String filePath = "/Users/newtouch/Desktop/笔记/日志/stdout.2017-08-03.log";
        readFileByLines(filePath);
    }
}
