package edu.niit.ioc.demo2;

public class Bean2Factory {
    public static Bean2 createBean2() {
        System.out.println("Bean2Factory的方法已执行。。。");
        return new Bean2();
    }
}
