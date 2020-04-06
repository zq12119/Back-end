package edu.niit.ioc.demo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FooService {
    // 属性注入
    @Autowired
    private FooFormatter fooFormatter;
    // 构造方法注入
    public FooService(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
    // setter方法注入
    public void setFooFormatter(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
    public void format() {
        fooFormatter.format();
        log.info("format()调用结果：{}", fooFormatter.format());
    }
}
