package org.laidu.learn.spring.aop.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.laidu.learn.spring.aop.service.impl.UserServiceImpl;

@Slf4j
class CglibProxyDemoTest {

    private CglibProxyDemo cglibProxyDemo;

    @BeforeEach
    void setUp() {
        cglibProxyDemo = new CglibProxyDemo(new UserServiceImpl());
    }

    @Test
    void getUserService() {
        cglibProxyDemo.getUserService().getUsernameFromSelf("xiaoming");
    }

    @Test
    void getUserService1() {

        cglibProxyDemo.getUserService().getUsername("xiaoming");
    }
}