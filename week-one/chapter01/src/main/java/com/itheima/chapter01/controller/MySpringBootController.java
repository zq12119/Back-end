package com.itheima.chapter01.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @description:标准的spring boot restcontroller
 */
@RestController
@RequestMapping("/api")
@ResponseBody
public class MySpringBootController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello,Spring Boot!Boot";
    }
}
