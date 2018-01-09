package org.laidu.learn.amqp.rabbitmq.official.hello.world;


import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Recv
 * <p>
 * Created by 臧天才 on 2017-09-13 13:53.
 */

// TODO : 2017-09-13 13:53  Recv
@Slf4j
public class Recv {

    private final static String QUEUE_NAME = "hello";

    private static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.useNio();
        factory.setHost("dev");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5673);
        factory.setVirtualHost("/hello");
        return factory.newConnection();
    }

    public static void main(String[] argv) throws Exception {

        Connection connection = getConnection();
        connection.addBlockedListener(new BlockedListener() {
            @Override
            public void handleBlocked(String reason) throws IOException {
                System.out.println("recv blocked reason: "+reason);
            }

            @Override
            public void handleUnblocked() throws IOException {
                System.out.println("recv unblocked");
            }
        });

        for (int i = 0; i < 10; i++){

            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME+i, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            channel.basicConsume(QUEUE_NAME+i, true, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            });
        }
    }
}
