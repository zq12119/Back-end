package com.spring.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CorsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CorsApplication.class, args);
    }

//    全局跨域
    @Bean
    public WebMvcConfigurer configurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8081")//配置如需访问
                        //配置容许请求header的访问
                        .allowedHeaders("*")
//                        //配置容许访问该跨域资源服务器的请求
                        .allowedMethods("*")
                        .maxAge(30*1000);
            }
        };
    }
}
