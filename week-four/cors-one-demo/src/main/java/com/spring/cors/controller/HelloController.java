package com.spring.cors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/doget")
    public String doGet(){
        return "get 请求";
    }
    @PutMapping("/doput")
    public String doPut(){
        return "put 请求";
    }
}
