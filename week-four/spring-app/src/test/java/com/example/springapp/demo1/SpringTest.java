package com.example.springapp.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringTest {
    @Test
    public void demo1() {
        UserDao userDao = new UserDaoImpl();
        userDao.sava();
        userDao.update();
        userDao.delete();
        userDao.find();

    }
    @Test
    public void demo2(){
        UserDao userDao=new UserDaoImpl();
        UserDao proxy=(UserDao)new MyJdkProxy(userDao).createProxy();
        proxy.sava();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
