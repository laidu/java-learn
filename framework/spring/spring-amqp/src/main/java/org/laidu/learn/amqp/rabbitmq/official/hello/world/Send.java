package org.laidu.learn.amqp.rabbitmq.official.hello.world;


import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/**
 * send
 * <p>
 * Created by 臧天才 on 2017-09-13 13:38.
 */

// TODO : 2017-09-13 13:38  send
@Slf4j
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("dev");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5673);
        factory.setVirtualHost("/hello");


        for (int i = 0; i < 10; i++) {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME + i, false, false, false, null);
            channel.exchangeDeclare("hello", BuiltinExchangeType.DIRECT,false,true,new HashMap<>());
            channel.queueBind(QUEUE_NAME+i,"hello",QUEUE_NAME+i);

            String message = "heieh";

            ExecutorService executorService = Executors.newFixedThreadPool(20);
            executorService.submit(() -> {

                try {
//                Channel channel1 = connection.createChannel();
                    while (true) {
                    log.info("message 's value : {}", message);
                        channel.basicPublish("hell1o",QUEUE_NAME+1, null, message.getBytes());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
//        while (true) {
//            channel.basicPublish(QUEUE_NAME + "_exchange", "", null, message.getBytes());
//        }

//        System.out.println(" [x] Sent '" + message + "'");
//
//        channel.close();
//        connection.close();


    }
}
