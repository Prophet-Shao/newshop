package com.ss.springbootNewshop.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @ClassName: MyShopWebMvcConfigurer
 * @User: 邵帅
 * @Date: 2019/12/1323:27
 * Version 1.0
 * Description: 配置拦截器  配置静态资源加载
 **/
/*@EnableWebMvc */
/*extends WebMvcConfigurationSupport 二者只能选一个*/
@Configuration
public class MyShopWebMvcConfigurer extends WebMvcConfigurationSupport {



    /**
     * 添加类型转换器和格式化器
     * @param registry
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class,new DateFormatter());
    }

    /**
     * 跨域支持
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

    /**
     * 设置返回数据消息字符集格式为UTF-8
     * @return
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        // fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);

        // 配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        // 时间格式化 不然返回时间戳
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

        // 过滤返回结果  参看下面注释
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,  // 输出值为 null 的字段
                SerializerFeature.WriteNullStringAsEmpty, // null 输出为"",而非null
                SerializerFeature.WriteNullListAsEmpty    // List 为 []
        );
        /**
         * fastJson配置类fastJsonConfig 调用setSerializerFeatures方法配置过滤选择
         * DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
         * WriteNullBooleanAsFalse：Boolean字段为null,输出为false,而非null
         * WriteNullStringAsEmpty ：字符类型为null,输出为"",而非null
         * WriteNullListAsEmpty  ：List字段为null,输出为[],而非null
         * WriteMapNullValue      ：是否输出值为null的字段,默认为false。
         */
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }


    //TODO
    //登录拦截

    /**
     * 默认解析器
     * 默认中文
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.CHINESE);
        return sessionLocaleResolver;
    }

    /**
     * 默认拦截器 其中lang表示切换语言的参数名
     * @return
     */
    @Bean
    public WebMvcConfigurer localeInterceptor(){
        return  new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
                localeInterceptor.setParamName("lang");
                registry.addInterceptor(localeInterceptor);
            }
        };
    }
    /**
     * 配置静态资源加载路径 没有会报 no mapping for ***的错误
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/META-INF/resources/templates/");

        super.addResourceHandlers(registry);
}
}
