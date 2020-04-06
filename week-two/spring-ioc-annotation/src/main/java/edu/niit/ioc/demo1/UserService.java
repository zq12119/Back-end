package edu.niit.ioc.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // 指定默认值
    @Value("米饭")
    private String sth;

    @Autowired(required = true)
    private UserDao userDao;

    public String sayHello(String name) {
        return "Hello " + name;
    }
    public void eat() {
        System.out.println("eat: " + sth);
    }
    public void save() {
        System.out.println("UserService中保存用户......");
        userDao.save();
    }
}
