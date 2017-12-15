package org.laidu.learn.amqp.rabbitmq.official.rpc;


import lombok.extern.slf4j.Slf4j;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * rabbitmq 官方示例 RPCClient
 * <p>
 * Created by 臧天才 on 2017-09-13 11:02.
 */
@Slf4j
//  : 2017-09-13 11:02  rabbitmq 官方示例 RPCClient
public class RPCClient {

    private Connection connection;
    private Channel channel;
    private String requestQueueName = "rpc_queue";
    private String replyQueueName;

    public RPCClient() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("dev");
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setPort(5672);
        factory.setVirtualHost("/rpc");

        connection = factory.newConnection();
        channel = connection.createChannel();

        replyQueueName = channel.queueDeclare().getQueue();
    }

    public String call(String message) throws IOException, InterruptedException {
        String corrId = UUID.randomUUID().toString();

        AMQP.BasicProperties props = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

        final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);

        channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (properties.getCorrelationId().equals(corrId)) {
                    response.offer(new String(body, "UTF-8"));
                }
            }
        });

        return response.take();
    }

    public void close() throws IOException {
        connection.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        RPCClient fibonacciRpc = new RPCClient();

        ExecutorService service  = Executors.newFixedThreadPool(10);
        service.submit(()->{

            System.out.println(" [x] Requesting fib(30)");
            String response = null;
            try {
                response = fibonacciRpc.call("30");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" [.] Got '" + response + "'");
        });


        fibonacciRpc.close();
    }

}
