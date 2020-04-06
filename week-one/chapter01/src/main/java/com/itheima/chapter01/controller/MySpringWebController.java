package com.itheima.chapter01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description :标准的spring mvc控制器
 */
@Controller
@RequestMapping("/springWeb")//代表应用
@ResponseBody
public class MySpringWebController {
    @RequestMapping("/hello")
    public String hello(){
        return "<h2>Hello,Spring Boot!!!Web</h2>";
    }
}
