package edu.niit.ioc.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {
    // 使用@Bean定义没有被@component注解的普通java类
    @Bean
    CustomDao customDao() {
        return new CustomDao();
    }
}
