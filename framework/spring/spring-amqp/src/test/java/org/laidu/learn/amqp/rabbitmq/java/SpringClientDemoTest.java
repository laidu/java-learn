package org.laidu.learn.amqp.rabbitmq.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpringClientDemoTest {
    @Test
    void declareQueue() throws IOException {
        SpringClientDemo clientDemo = new SpringClientDemo();

        clientDemo.declareQueue();
    }

}