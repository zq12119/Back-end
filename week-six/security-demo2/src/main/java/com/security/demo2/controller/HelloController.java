package com.security.demo2.controller;

import com.security.demo2.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class HelloController {
   @GetMapping("/hello")
    public String hello(){
       return "hello security";
   }
   @GetMapping("/data/hello")
    public String data(){
       return "hello data";
   }
    @GetMapping("/admin/hello")
    public String admin(){
        return "hello admin";
    }
    @GetMapping("/user/hello")
    public String user(){
        return "hello user";
    }
}
