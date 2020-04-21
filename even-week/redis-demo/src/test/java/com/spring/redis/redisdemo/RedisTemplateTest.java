package com.spring.redis.redisdemo;

import com.spring.redis.redisdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
@Slf4j
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;
//    测试String
    @Test
    public void testString(){
        ValueOperations<String,String> ops=redisTemplate.opsForValue();
        ops.set("username","niit");
        Assertions.assertEquals("niit",ops.get("username"));
    }
    // 测试对象
    @Test
    public void testObj() {
        User user = new User("niit@126.com", "smile", 20);
        ValueOperations<String, User> ops = redisTemplate.opsForValue();
        ops.set("com.niit", user);
        User savedUser = ops.get("com.niit");
        log.info("user: {}", savedUser != null ? savedUser.toString() : "没有此用户");
    }
}
