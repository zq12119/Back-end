package com.itheima.chapter01;

import com.itheima.chapter01.controller.HelloController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//@RunWith(SpringRunner.class)  //测试启动器并加载springBoot测试注解
@SpringBootTest//标记spring Boot单元测试，并加载项目的applicationController上下文环境
class Chapter01ApplicationTests {
    @Autowired//自动装载
private HelloController helloController;
    @Test
    void contextLoads() {
        //方法调用的测试，不是模拟http请求
        String hello=helloController.hello();
        System.out.println(hello);
    }

}
