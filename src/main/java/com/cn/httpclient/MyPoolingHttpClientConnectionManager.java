package com.cn.httpclient;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Pooling connection manager(连接池管理)
 *
 * @author guowy
 * @create 2017-07-04 9:27
 **/

@Configuration
public class MyPoolingHttpClientConnectionManager {

    /**
     * 连接池最大连接数
     */
    @Value("${httpclient.config.connMaxTotal}")
    private int connMaxTotal = 20;

    @Value("${httpclient.config.maxPerRoute}")
    private  int maxPerRoute = 20;

    /**
     * 连接存活时间，单位为s
     */
    @Value("${httpclient.config.timeToLive}")
    private  int timeToLive= 60;

    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(){
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(60, TimeUnit.SECONDS);
        // 最大连接数
        poolingHttpClientConnectionManager.setMaxTotal(this.connMaxTotal);
        // 路由基数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(this.maxPerRoute);
        return poolingHttpClientConnectionManager;
    }

//      PoolingHttpClientConnectionManager   类的构造函数
//    public PoolingHttpClientConnectionManager(final long timeToLive, final TimeUnit tunit) {
//        this(getDefaultRegistry(), null, null ,null, timeToLive, tunit);
//    }
//
//    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
//        return RegistryBuilder.<ConnectionSocketFactory>create()
//                .register("http", PlainConnectionSocketFactory.getSocketFactory())
//                .register("https", SSLConnectionSocketFactory.getSocketFactory())
//                .build();
//    }

}
