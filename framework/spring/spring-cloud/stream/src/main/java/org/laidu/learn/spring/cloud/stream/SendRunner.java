package org.laidu.learn.spring.cloud.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

public class SendRunner implements CommandLineRunner {

    @Autowired
    @Qualifier("output")
    MessageChannel output;

    @Override
    public void run(String... args) throws Exception {
        // 字符串类型发送MQ
        System.out.println("字符串信息发送");
        output.send(MessageBuilder.withPayload("大家好").build());
    }
}
