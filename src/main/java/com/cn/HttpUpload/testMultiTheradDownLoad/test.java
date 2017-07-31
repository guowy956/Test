package com.cn.HttpUpload.testMultiTheradDownLoad;

import com.cn.HttpUpload.MultiTheradDownLoad;

/**
 * Created by newtouch on 2017/7/31.
 */
public class test {

    public static void main(String[] args) {
        String filepath = "http://127.0.0.1:8080/file/loadfile.mkv";
        MultiTheradDownLoad load = new MultiTheradDownLoad(filepath ,4);
        load.downloadPart();
    }
}
