package edu.niit.ioc.demo1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//@Data
//@Component
//@PropertySource({"classpath:applicationContext.xml"})
public class ValueDemo {
//    @Value("${user.fullName}")
//    private String userName;
//
//    @Value("${user.address}")
//    private String address;
//
//    // 数组的注入
//    @Value("${user.preferences}")
//    private List<String> preferences;
//
//    // Map的注入
//    @Value("#{${products.count}}")
//    private Map<String, Integer> productsCount;
//
//    // Map的特定key的值注入
//    @Value("#{${products.count}.P1}")
//    private Integer p1Count;
//
//    // 读取系统变量
//    @Value("${java.home}")
//    private String javaHome;
//
//    // 指派默认值
//    @Value("${user.stocks:30}")
//    private int stockCount;
//
//    // 方法上注入
//    @Value("${user.name}")
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    // 参数注入
//    public void setUserDetails(@Value("${user.fullName") String userName,
//                               @Value("${user.address") String address) {
//        this.userName = userName;
//        this.address = address;
//    }
}
