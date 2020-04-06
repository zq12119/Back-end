package edu.niit.ioc.service.ipml;

import edu.niit.ioc.service.UserService;

public class UserServiceImpl implements UserService {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void findAll() {
        System.out.println("findAll()被执行"+userName);
    }
}
