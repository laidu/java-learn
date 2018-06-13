package org.laidu.learn.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * aop app
 * <p>
 * Created by tiancai.zang
 * on 2018-06-13 16:29.
 *
 * @author tiancai.zang
 */
@Slf4j
@SpringBootApplication
public class AopApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AopApp.class)
                .run(args);
    }
}