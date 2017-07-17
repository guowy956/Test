package com.cn.httpclient;

import org.apache.http.client.config.RequestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用来设置请求的各种配置
 *
 * @author guowy
 * @create 2017-07-04 10:37
 **/

@Configuration
public class MyRequestConfig {

    @Value("${httpclient.config.connectTimeout}")
    private int connectTimeout = 2000;

    @Value("${httpclient.config.connectRequestTimeout}")
    private int connectRequestTimeout = 2000;

    @Value("${httpclient.config.socketTimeout}")
    private int socketTimeout = 2000;

    @Bean
    public RequestConfig config(){
        return RequestConfig.custom()
                .setConnectionRequestTimeout(this.connectRequestTimeout)
                .setConnectTimeout(this.connectTimeout)
                .setSocketTimeout(this.socketTimeout)
                .build();
    }
}
