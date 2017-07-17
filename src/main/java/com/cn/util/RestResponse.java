package com.cn.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cn.util.GlobalConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * rest请求响应
 *
 * @author guowy
 * @create 2017-05-23 11:09
 **/

public class RestResponse {

    public int code;

    public String msg;

    public Map<String,Object> result;

    public RestResponse(int code){
        result = new HashMap<>();
        this.code = code;
    }
    public RestResponse(int code, String msg){
        result = new HashMap<>();
        this.code  = code;
        this.msg = msg;
    }

    public static RestResponse success(){
        return new RestResponse(0);
    }
    public static RestResponse validFile(){
        return new RestResponse(400);
    }
    public static RestResponse exception(){
        return new RestResponse(500, GlobalConstant.exceptionMsg);
    }
    public static RestResponse exception(String msg){
        return new RestResponse(500,msg);
    }
    public RestResponse add(String key, Object value){
        this.result.put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public String build(){
        this.result.put("code",this.code);
        if(msg!=null  && msg.isEmpty()){
            this.result.put("msg",this.msg);
        }
        return JSON.toJSONString(this.result, SerializerFeature.WriteDateUseDateFormat);
    }
}
