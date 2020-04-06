package edu.niit.ioc.demo2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bean1 {
    @PostConstruct
    public void init() {
        System.out.println("init bean......");
    }
    public void say() {
        System.out.println("say......");
    }
    @PreDestroy
    public void destory() {
        System.out.println("destroy bean......");
    }
}
