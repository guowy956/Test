package com.cn.httpclient;

import com.sun.tracing.ProbeName;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：连接保持策略
 *
 * @author guowy
 * @create 2017-07-04 10:05
 **/

@Configuration
public class MyconnectionKeepAliveStrategy {

    @Value("${httpclient.config.keepAliveTime}")
    private int keepAliveTime = 30;

    @Bean("connectionKeepAliveStrategy")
    public ConnectionKeepAliveStrategy connectionKeepAliveStrategy(){
        return new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                HeaderElementIterator it = new BasicHeaderElementIterator(httpResponse.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()){
                    HeaderElement headerElement = it.nextElement();
                    String name = headerElement.getName();
                    String value = headerElement.getValue();
                    if(value!=null && name.equalsIgnoreCase("timeout")){
                        try {
                            return Long.parseLong(value) * 1000;
                        } catch (NumberFormatException ignore) {
                        }
                    }
                }
                return 30 * 1000;
            }
        };
    }
}
