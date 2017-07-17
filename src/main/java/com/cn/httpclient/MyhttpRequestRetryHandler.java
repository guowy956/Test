package com.cn.httpclient;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

/**
 * HttpClient的重试处理机制
 *
 * @author guowy
 * @create 2017-07-03 17:39
 **/
@Configuration
public class MyhttpRequestRetryHandler {

    // 此处建议采用@ConfigurationProperties(prefix="httpclient.config")方式，方便复用
    @Value("${httpclient.config.retryTime}")
    private int retryTime;

    @Bean
    public HttpRequestRetryHandler httpRequestRetryHandler(){
        final int retryTime = this.retryTime;
        return new HttpRequestRetryHandler() {
            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                //如果重试次数超过了retryTime,则不再重试请求
                if(executionCount >= retryTime){
                    return false;
                }
                // 服务端断掉客户端的连接异常
                if(exception instanceof NoHttpResponseException){
                    return true;
                }
                // time out 超时重试
                if(exception instanceof InterruptedIOException){
                    return true;
                }
                //Unknown host(未知主机)
                if(exception instanceof UnknownHostException){
                    return false;
                }
                //Connection refused 连接被拒绝
                if(exception instanceof ConnectTimeoutException){
                    return false;
                }
                //SSL handshake exception
                if(exception instanceof SSLException){
                    return false;
                }
                HttpClientContext adapt = HttpClientContext.adapt(context);
                HttpRequest request = adapt.getRequest();
                if(!(request instanceof HttpEntityEnclosingRequest)){
                    return  true;
                }
                return false;
            }
        };
    }
}
