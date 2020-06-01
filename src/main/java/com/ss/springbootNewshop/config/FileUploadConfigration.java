package com.ss.springbootNewshop.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.MultipartConfigElement;

/**
 * @ClassName: FileUploadConfigration
 * @User: 邵帅
 * @Date: 2020/2/1223:19
 * Version 1.0
 * Description: 文件上传配置
 **/
@Component
public class FileUploadConfigration {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("10MB"); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("10MB");
        // Sets the directory location where files will be stored.
        factory.setLocation("D:\\ideaIU\\workplace\\project\\springboot_newshop\\src\\main\\resources\\static\\Image");
        return factory.createMultipartConfig();
    }

}
