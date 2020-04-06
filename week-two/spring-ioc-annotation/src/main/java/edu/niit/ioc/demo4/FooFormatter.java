package edu.niit.ioc.demo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("fooFormatter")
public class FooFormatter {
    public String format() {
        return "foo";
    }
}
