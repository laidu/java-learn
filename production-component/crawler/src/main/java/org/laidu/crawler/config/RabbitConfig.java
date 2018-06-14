package org.laidu.crawler.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq queue config
 *
 * @author tiancai.zang 2018-01-09 14:51.
 */
@Data
@Configuration
@NoArgsConstructor
public class RabbitConfig {

    /**
     *  exchange name
     */
    @Value(value = "${rabbitmq.exchangeName:crawler}")
    private String exchangeName;
    /**
     *  route key
     */
    @Value(value = "${rabbitmq.routeKey:crawler}")
    private String routeKey;
    /**
     *  queue name
     */
    @Value(value = "${rabbitmq.queueName:crawler}")
    private String queueName;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchangeName,false,false,null);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){

        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.declareExchange(exchange());
        rabbitAdmin.declareQueue(queue());
        rabbitAdmin.declareBinding(binding(queue(),exchange()));
        return rabbitAdmin;
    }

}