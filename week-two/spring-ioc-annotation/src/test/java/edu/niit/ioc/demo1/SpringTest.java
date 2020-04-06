package edu.niit.ioc.demo1;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpringTest {
    @Autowired
    private UserService service;

    @Test
    public void test1() {
        String str = service.sayHello("张三");
        log.info(str);
    }
    @Test
    public void testEat(){
        service.eat();
    }

    @Test
    public void testSave() {
        service.save();
    }
}
