package org.laidu.learn.amqp;

import org.laidu.learn.amqp.rabbitmq.json.JsonApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * org.laidu.learn.amqp.Application
 * <p>
 * Created by tiancai.zang on 2017-11-28 16:35.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(JsonApp.class, args);
        ctx.getBean(JsonApp.class).runDemo();
        ctx.close();
    }

}