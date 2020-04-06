package com.jcdk.demo3.repository;

import com.jcdk.demo3.pojo.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageRepositoryTest {
    @Autowired
    private MeaasgeRepository meaasgeRepository;

    @Test
    @Order(1)
    public void testInsert(){
        Message message= Message.builder().msgText("niit").msgSummary("学校").build();
        int num=meaasgeRepository.insert(message);
        log.info("插入的条数:{}",num);
    }

    @Test
    @Order(2)
    public void testFindAll(){
        meaasgeRepository.findAll().forEach(
                message -> log.info("查询的数据:{}",message.toString())
        );
    }
}
