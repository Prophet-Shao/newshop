package com.ss.springbootNewshop.config;

/**
 * @ClassName: SwaggerConfig
 * @User: 邵帅
 * @Date: 2020/3/521:59
 * Version 1.0
 * Description: TODO
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                // 扫描controller包
                .apis(RequestHandlerSelectors.basePackage("com.ss.springbootNewshop.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }


    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基于Swagger构建的新零售接口数据Rest API文档")
                .description("更多请咨询开发者邵帅")
                .contact(new Contact("邵帅", "http://localhost:8080/newshop/login", "810105176@qq.com.com"))
                .termsOfServiceUrl("http://www.eknown.com")
                .license("Springboot NewShop LICENSE")
                .licenseUrl("localhost:8080/newshop/login")
                .version("1.0")
                .build();
    }
}

