package org.laidu.learn.amqp.rabbitmq.java;

import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.impl.AMQImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpIOException;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

import java.io.IOException;

/**
 * spring amqp java call
 *
 * @author tiancai.zang
 * 2018-01-11 17:45.
 */
@Slf4j
public class SpringClientDemo implements ClientDemo {

    public CachingConnectionFactory cachingConnectionFactory(){
        com.rabbitmq.client.ConnectionFactory connectionFactory = new com.rabbitmq.client.ConnectionFactory();
        connectionFactory.setHost("dev");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/learn");
        return new CachingConnectionFactory(connectionFactory);
    }

    public RabbitAdmin rabbitAdmin(){

        RabbitAdmin admin = new RabbitAdmin(cachingConnectionFactory());

        return admin;
    }


    @Override
    public void declareQueue() throws IOException {

        RabbitAdmin rabbitAdmin = rabbitAdmin();

        try {
            rabbitAdmin.declareQueue(new Queue("demo2",false,false,false));
        }catch (Exception e){
            try {
                if (406 == ((AMQImpl.Channel.Close) ((ShutdownSignalException)e.getCause().getCause()).getReason()).getReplyCode()) {
                    rabbitAdmin.deleteQueue("demo2");
                    declareQueue();
                }
            }catch (Exception e1){
            }
            log.error("e 's value : {}", e);
        }


    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new SpringClientDemo().declareQueue();
    }
}