package com.jsp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class Welcome {
    @GetMapping("/hello")
    public String hello(Model model,String name){
        model.addAttribute("name",name);
        return "hello";
    }
    @GetMapping("/welcom")
    public String welcom(Map<String,Object> model, String name){
        model.put("name",name);
        model.put("time", LocalDate.now());
        return "welcom";
    }
    @RequestMapping("/other")
    public ModelAndView welcom(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("welcom");
        mv.addObject("time",LocalDate.now());
        return mv;
    }
    /**
     * @param name传递的参数
     * @return 返回json字符串
     */
    @RequestMapping("/other2")
    @ResponseBody
    public String welcom(@RequestParam(value="name",required=false) String name){
        return name.isEmpty() ? "没传值":"收到的值为：" + name;
    }

}
