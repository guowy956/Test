package com.cn.webService;

import com.cn.swagger2.API.RoleApi;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Author:guowy 【guowy956@163.com】
 * @Description: 打开注释 访问 http://localhost:8080/soap/roles?wsdl
 * @Date: 2017-07-03 17:31
 */

@Configuration
public class CxfConfig {

    //与swagger域名冲突   但是可以使用
//    @Bean
//    public ServletRegistrationBean dispatcherServlet(){
//        return new ServletRegistrationBean(new CXFServlet(),"/soap/*");
//    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public RolesService rolesService() {
        return new RolesServiceImpl();
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), rolesService());
        endpoint.publish("/roles");
        return endpoint;
    }
}
