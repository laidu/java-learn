package org.laidu.learn.amqp.rabbitmq.java;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.impl.AMQImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * client usage demo
 *
 * @author tiancai.zang
 * 2018-01-11 16:24.
 */
@Slf4j(topic = "rabbitmqClientDemo")
public class RabbitmqClientDemo implements ClientDemo {

    public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("dev");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("/learn");
        return connectionFactory;
    }

    public Connection connection(ConnectionFactory connectionFactory){
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
        } catch (Exception e) {
            log.error("connection create error", e);
        }
        return connection;
    }

    /**
     * 当重复声明同一名称队列时：
     * 1、参数相同，"不作为"
     * 2、参数不同，错误码406
     * @throws IOException
     */
    @Override
    public void declareQueue() throws IOException {
        Connection connection = connection(connectionFactory());
        Channel channel = connection.createChannel();
        try {
            channel.queueDeclare("demo1",true,false,false,null);
        }catch (IOException e){
            if ("406".equals(((AMQImpl.Channel.Close) (((ShutdownSignalException)e.getCause())).getReason()).getReplyCode())){
                channel = connection.createChannel();
                channel.queueDelete("demo1");
                channel.queueDeclare("demo1",false,false,false,null);
            }
        }
    }

}