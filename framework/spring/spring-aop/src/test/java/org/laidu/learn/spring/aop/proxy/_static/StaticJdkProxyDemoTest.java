package org.laidu.learn.spring.aop.proxy._static;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.laidu.learn.spring.aop.service.impl.UserServiceImpl;

class StaticJdkProxyDemoTest {

    private StaticJdkProxyDemo staticJdkProxyDemo;

    @BeforeEach
    void setUp() {
        staticJdkProxyDemo = new StaticJdkProxyDemo(new UserServiceImpl());
    }

    @Test
    void addUser() {
        staticJdkProxyDemo.addUser("xiaoming");
    }

    @Test
    void removeUser() {
        staticJdkProxyDemo.getUsernameFromSelf("xiaoming");
    }

    @Test
    void getUsername() {
    }
}