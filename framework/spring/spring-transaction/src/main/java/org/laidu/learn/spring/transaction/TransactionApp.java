package org.laidu.learn.spring.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * spring transaction app
 * <p>
 * Created by tiancai.zang
 * on 2018-06-13 12:09.
 *
 * @author tiancai.zang
 */
@Slf4j
@SpringBootApplication
public class TransactionApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TransactionApp.class)
                .run(args);
    }
}