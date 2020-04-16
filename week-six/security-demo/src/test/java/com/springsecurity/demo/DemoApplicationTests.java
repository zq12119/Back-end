package com.springsecurity.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        for(int i=0;i<10;i++){
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            System.out.println(encoder.encode("111"));
        }
    }

}
