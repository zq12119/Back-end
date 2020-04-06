package com.jsp.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvc implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp("/WEB-INF/jsp",".jsp");
    }
}
