package com.spring.redis.redisdemo;

import com.spring.redis.redisdemo.model.User;
import com.spring.redis.redisdemo.model.User2;
import com.spring.redis.redisdemo.server.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetUser() {
        User2 user1 = userService.getUserById(1);
        User2 user2 = userService.getUserById(1);
        log.info(user1.toString());
        log.info(user2.toString());
    }

    @Test
    public void testUpdateUser() {
        User2 user1 = userService.getUserById(1);
        User2 user = new User2();
        user.setId(1);
        user.setUsername("niit");
        user.setAddress("xianlin");
        userService.updateUserById(user);
        User2 user2 = userService.getUserById(1);

        log.info(user1.toString());
        log.info(user2.toString());
    }

    @Test
    public void testDeleteUser() {
        User2 user1 = userService.getUserById(1);
        userService.deleteUserById(1);
        User2 user2 = userService.getUserById(1);

        log.info(user1.toString());
        log.info(user2.toString());
    }
}