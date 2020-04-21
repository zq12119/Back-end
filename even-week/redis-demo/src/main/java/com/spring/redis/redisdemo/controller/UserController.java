package com.spring.redis.redisdemo.controller;

import com.spring.redis.redisdemo.server.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    // 定义一个名为 helloCache的缓存，key为参数，value是返回的String值
    @RequestMapping("/hello")
    @Cacheable(value = "helloCache")
    public String hello(String name) {
        log.info("没有走缓存");
        return "hello " + name;
    }

    @GetMapping("/condition")
    @Cacheable(value = "condition", condition = "#name.length() <= 4")
    public String condition(String name) {
        log.info("没有走缓存！");
        return "hello " + name;
    }
}