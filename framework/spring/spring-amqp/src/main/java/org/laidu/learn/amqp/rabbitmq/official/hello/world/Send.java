package org.laidu.learn.amqp.rabbitmq.official.hello.world;


import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
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


    private static ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.useNio();
        factory.setHost("dev");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5673);
        factory.setVirtualHost("/hello");
        return factory;
    }

    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = getConnection();
        connection.addBlockedListener(new BlockedListener() {
            @Override
            public void handleBlocked(String reason) throws IOException {
                System.out.println("blocked reason: "+reason);
            }

            @Override
            public void handleUnblocked() throws IOException {
                System.out.println("Unblocked");
//                connection.close();
            }
        });


        for (int i = 0; i < 10; i++) {

            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME + i, false, false, false, null);
            channel.exchangeDeclare("hello", BuiltinExchangeType.DIRECT,false,true,new HashMap<>());
            channel.queueBind(QUEUE_NAME+i,"hello",QUEUE_NAME+i);
            String message = "hello "+new Date();

            Integer index = new Integer(i);

            ExecutorService executorService = new ForkJoinPool(1);
            executorService.submit(()->{
                while (true){
                    channel.basicPublish("hello",QUEUE_NAME+ index, null, message.getBytes());
                }
            });


//            channel.close();
//            connection.close();

        }


    }

    private static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = getConnectionFactory();
        return connectionFactory.newConnection();
    }

}
