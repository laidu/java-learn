package org.laidu.learn.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * org.laidu.learn.amqp.Application
 * <p>
 * Created by tiancai.zang on 2017-11-28 16:35.
 */
@MapperScan("org.laidu.learn.mybatis.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}