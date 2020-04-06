package edu.niit.ioc.demo4;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Data
@Component
public class MyBeanMap {
    @Resource(name = "map")
    private Map<String, Integer> intMap;
}
