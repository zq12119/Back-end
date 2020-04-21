package com.spring.redis.redisdemo.server;

import com.spring.redis.redisdemo.model.User;
import com.spring.redis.redisdemo.model.User2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@CacheConfig(cacheNames = "c1")
public class UserService {
    @Cacheable
    public User2 getUserById(Integer id) {
        log.info("getUserById >>> {}", id);
        User2 user = new User2();
        user.setId(id);
        return user;
    }

    // 删除数据库记录的同时，也把缓存中的记录也删除
    @CacheEvict(beforeInvocation = true)
    public void deleteUserById(Integer id) {
        log.info("deleteUserById >>> {}", id);
    }

    @CachePut(key = "#user.id")
    public User2 updateUserById(User2 user) {
        log.info("updateUserById >>> {}", user.getId());
        return user;
    }
}