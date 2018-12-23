package org.laidu.learn.amqp.rabbitmq.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class SpringClientDemoTest {
    @Test
    void declareQueue() throws IOException {
        SpringClientDemo clientDemo = new SpringClientDemo();

        clientDemo.declareQueue();
    }

}