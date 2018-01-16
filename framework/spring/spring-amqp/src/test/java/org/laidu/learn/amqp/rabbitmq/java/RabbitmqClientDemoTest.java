package org.laidu.learn.amqp.rabbitmq.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class RabbitmqClientDemoTest {
    @Test
    void connectionFactory() {
    }

    @Test
    void connection() {
    }

    @Test
    void declareQueue() throws IOException {

        new RabbitmqClientDemo().declareQueue();
    }

}