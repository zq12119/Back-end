package edu.niit.ioc.demo4;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class MyBeanList {
    @Autowired
    private List<String> strList;
}
