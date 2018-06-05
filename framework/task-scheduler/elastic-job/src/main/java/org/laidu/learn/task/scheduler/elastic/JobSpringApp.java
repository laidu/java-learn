package org.laidu.learn.task.scheduler.elastic;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by tiancai.zang
 * on 2018-05-18 15:05.
 */
@Slf4j
@MapperScan("org.laidu.learn.task.scheduler.elastic.mapper")
@SpringBootApplication
public class JobSpringApp {

    public static void main(String[] args) {

        SpringApplication.run(JobSpringApp.class);

    }
}