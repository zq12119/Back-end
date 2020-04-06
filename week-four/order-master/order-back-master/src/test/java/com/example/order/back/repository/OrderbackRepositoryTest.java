package com.example.order.back.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderbackRepositoryTest {
    @Autowired
    private OrderbackRepository orderbackRepository;
    @Test
    void findAll(){
        System.out.println(orderbackRepository.findAll());
    }
}