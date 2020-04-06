package edu.niit.ioc.demo2;
/**
 * @author:zhgqan
 * @data:2020-3-16
 * @description:Bean3实例工厂
 */
public class Bean3Factory {
    public Bean3 createBean3() {
        System.out.println("Bean3Factory的方法已执行。。。");
        return new Bean3();
    }
}
