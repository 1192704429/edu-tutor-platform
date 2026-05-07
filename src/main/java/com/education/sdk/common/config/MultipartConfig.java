package com.education.sdk.common.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @description: 文件上传的配置类
 * @author: wuming
 * @create: 2025-02-28 10:20:21
 */
@Configuration
public class MultipartConfig  {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //允许上传的文件最大值
        factory.setMaxFileSize(DataSize.parse("300MB"));
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("800MB"));
        return factory.createMultipartConfig();
    }

}
