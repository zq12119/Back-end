package edu.niit.ioc.demo1;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void save() {
        System.out.println("UserDao中保存用户......");
    }
}
