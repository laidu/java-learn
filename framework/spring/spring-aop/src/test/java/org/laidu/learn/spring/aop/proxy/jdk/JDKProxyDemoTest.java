package org.laidu.learn.spring.aop.proxy.jdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.laidu.learn.spring.aop.service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class JDKProxyDemoTest {

    JDKProxyDemo jdkProxyDemo;

    @BeforeEach
    void setUp() {

        jdkProxyDemo = new JDKProxyDemo(new UserServiceImpl());
    }

    @Test
    void getUserService() {

        jdkProxyDemo.getUserService().addUser("xiaoming");
        jdkProxyDemo.getUserService().removeUser("xiaoming");
        jdkProxyDemo.getUserService().getUsername("xiaoming");
        System.out.println();
        jdkProxyDemo.getUserService().getClass();
    }

    /**
     * 自调用方法时只会调用真实的方法，不会关联其它额外的代理增强功能
     */
    @Test
    void getUserService2(){

        jdkProxyDemo.getUserService().getUsernameFromSelf("xiaoming");
    }
}