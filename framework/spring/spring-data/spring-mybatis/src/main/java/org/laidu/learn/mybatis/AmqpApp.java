package org.laidu.learn.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * org.laidu.learn.amqp.Application
 * <p>
 * Created by tiancai.zang on 2017-11-28 16:35.
 */
@MapperScan("org.laidu.learn.mybatis.mapper")
@SpringBootApplication
public class AmqpApp {

    public static void main(String[] args){
        SpringApplication.run(AmqpApp.class);
    }

}