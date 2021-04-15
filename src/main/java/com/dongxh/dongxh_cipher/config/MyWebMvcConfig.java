package com.dongxh.dongxh_cipher.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    //CORS(Cross-Origin Resource Sharing,跨域资源共享技术标准)支持
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//请求路径 eg：/book/**
                .allowedOrigins("*")//标识支持的域 eg：http://localhost:8080
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")//标识允许的请求方法 默认：GET,POST,HEAD
                .maxAge(3600);//探测请求有效期 探测请求不是每次发送，可配置有效期
//                .allowCredentials(true);
    }
}

