package edu.niit.ioc.demo5;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
public class CollectionBean {
    // 数组类型
    private String[] arrs;
    // List集合类型
    private List<String> list;
    // Set集合类型
    private Set<String> set;
    // map集合类型
    private Map<String, String> map;
    // 属性类型
    private Properties properties;
}