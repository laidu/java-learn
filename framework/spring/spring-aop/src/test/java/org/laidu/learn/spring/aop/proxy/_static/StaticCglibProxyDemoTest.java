package org.laidu.learn.spring.aop.proxy._static;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaticCglibProxyDemoTest {

    StaticCglibProxyDemo cglibProxyDemo;

    @BeforeEach
    void setUp() {
        cglibProxyDemo = new StaticCglibProxyDemo();
    }

    @Test
    void addUser() {
        cglibProxyDemo.addUser("xiaoming");
    }

    @Test
    void removeUser() {
    }

    @Test
    void getUsername() {
    }
}