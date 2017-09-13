package com.cn.IO;


import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by newtouch on 2017/8/3.
 */
public class IOTest2 {


//    public static void main(String[] args) throws IOException {
//        String path = "/Users/newtouch/Desktop/笔记/日志/stdout.2017-08-03.log";
//        System.out.println(Files.readLines(new File(path), Charsets.UTF_8));
//    }


    public static void main(String[] args) throws IOException {
        String path = "/Users/newtouch/Desktop/笔记/日志/stdout.2017-08-03.log";
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

}
