package com.itheima.chapter01;

import com.itheima.chapter01.controller.MySpringBootController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//导入Spring测试框架，JUNIT 5
@SpringBootTest

public class MySpringBootControllerTest {
    @Autowired
    private MySpringBootController controller;
    private MockMvc mockMvc; //发送http 请求的模拟对象，桩对象

    @BeforeEach
    public void setUp(){

        mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testHello()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
//                地址要与controller里面地址一致
        .get("/api/hello")
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                .string("Hello,Spring Boot!"));
    }



}
