package org.laidu.learn.amqp.rabbitmq.official.rpc;


import lombok.extern.slf4j.Slf4j;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * rabbitmq 官方 示例
 * <p>
 * Created by 臧天才 on 2017-09-13 10:55.
 */
@Slf4j
//  : 2017-09-13 10:55  rabbitmq 官方 示例
public class RPCServer {

    private static final String RPC_QUEUE_NAME = "rpc_queue";

    public static void main(String[] argv) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("dev");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5672);
        factory.setVirtualHost("/rpc");

        Connection connection = null;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);

            channel.basicQos(1);

            System.out.println(" [x] Awaiting RPC requests");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                            .Builder()
                            .correlationId(properties.getCorrelationId())
                            .build();

                    String response = "";

                    try {

                        response += fib(Integer.parseInt(new String(body)));

                    } catch (RuntimeException e) {
                        System.out.println(" [.] " + e.toString());
                    } finally {
                        channel.basicPublish("", properties.getReplyTo(), replyProps, response.getBytes("UTF-8"));

                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                }
            };

            channel.basicConsume(RPC_QUEUE_NAME, false, consumer);

        } catch (Exception e) {

        }
    }

    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

}
