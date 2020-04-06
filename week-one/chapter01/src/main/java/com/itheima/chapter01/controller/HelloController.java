package com.itheima.chapter01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")

    public String hello() {

        return "hello spring Boot2yyyyeeee" ;
    }

    //带参数请求
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return "Hello, " + name;
    }
}


