package com.cn.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swagger配置
 *
 * @author guowy
 * @create 2017-05-26 19:01
 **/
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-09T02:12:09.726Z")
@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger2-初次运用")
                .description("swagger2-初次运用-接口。")
                .license("北京新致君阳信息技术可以有限公司")
                .licenseUrl("www.baidu.com")
                .termsOfServiceUrl("")
                .version("1.0.1")
                .contact("")
                .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                    .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                .apis(RequestHandlerSelectors.basePackage("com.cn.swagger2.API"))
//                    .apis(RequestHandlerSelectors.basePackage("com.yingu.operation.swagger.foreign"))
//                    .apis(RequestHandlerSelectors.basePackage("com.yingu.operation.swagger.test"))
                .build()
                .directModelSubstitute(java.sql.Date.class, java.sql.Date.class)
                .directModelSubstitute(java.util.Date.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}