package com.itheima.chapter02;

import com.itheima.chapter02.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter02ApplicationTests {

    @Autowired
    private Person person;

    @Test
    void contextLoads() {

        System.out.println(person);
    }

}
