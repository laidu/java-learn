package org.laidu.learn.spring.data.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * redis
 * <p>
 * Created by tiancai.zang
 * on 2018-05-22 09:55.
 * @author laidu
 */
@Slf4j
@SpringBootApplication
public class RedisApp {

    public static void main(String[] args) {
        SpringApplication.run(RedisApp.class,args);
    }
}