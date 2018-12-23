package org.laidu.learn.test.junit5.mock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("TestedService测试")
class TestedServiceTest {

    private TestedService service;

    @BeforeAll
    @DisplayName("BeforeAll")
    static void initAll(){

        log.info("-*--*--*--*--*--*--*--*--*--  --*--*--*--*--*--*--*--*--*-: {}", "BeforeAll");
    }

    @BeforeEach
    @DisplayName("BeforeEach")
    void init() {

        log.info("-*--*--*--*--*--*--*--*--*-- BeforeEach --*--*--*--*--*--*--*--*--*-: {}",
                System.currentTimeMillis());
        service = new TestedService();
    }

    @Test
    @DisplayName("服务打开")
    void open() {

        try {
            service.open("测试");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("服务调用")
    void call() {

        service.call("测试");
    }

}