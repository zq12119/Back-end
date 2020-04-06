package com.spring.cors.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class CorsWebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")//配置容许跨域
        .allowedOrigins("http://localhost:8081")//配置如需访问
    //配置容许请求header的访问
        .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(30*1000);
    }

}
