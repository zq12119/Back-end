package com.jcdk.demo3.filter;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import lombok.extern.slf4j.Slf4j;
import java.util.Properties;

@Slf4j
public class ConnLogFilter extends FilterEventAdapter {
    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("connectBefore,info:{}",info.toString());
    }

    @Override
    public void connection_connectAfter(com.alibaba.druid.proxy.jdbc.ConnectionProxy connection) {
        log.info("connectAfter,connection:{}",connection.toString());

    }
}
