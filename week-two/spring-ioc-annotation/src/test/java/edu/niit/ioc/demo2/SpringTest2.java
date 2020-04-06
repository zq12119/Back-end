package edu.niit.ioc.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        bean1.say();
        context.close();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Bean2 bean1 = (Bean2) context.getBean("bean2");
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        System.out.println(bean1 == bean2);
    }

}
