package com.itheima.controllor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //该注解为组合注解，@ResponseBody+@Controller

public class HelloController {

    @GetMapping("/hello")//GetMapping:相当于@RequetstMapping(value="/hello",RequestMethod.Get)
    public String hello(){

        return "hello spring boot";
    }
}
