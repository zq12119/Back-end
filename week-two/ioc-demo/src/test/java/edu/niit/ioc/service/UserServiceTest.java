package edu.niit.ioc.service;

import edu.niit.ioc.service.ipml.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    @Test
    public void testl(){
        UserService userService=new UserServiceImpl();
        userService.findAll();
    }
    @Test
    public void test2(){
        //使用spring的工厂类
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService=(UserService) context.getBean("userService");
        userService.findAll();
    }
}
