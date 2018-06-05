package org.laidu.learn.spring.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring mvc app
 * <p>
 * Created by tiancai.zang
 * on 2018-05-30 11:29.
 */
@Slf4j
@SpringBootApplication
public class MvcApp {

    public static void main(String[] args) {

        SpringApplication.run(MvcApp.class,args);
    }
}