package org.laidu.learn.webfulx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by tiancai.zang
 * on 2018-06-11 23:18.
 */
@Slf4j
@SpringBootApplication
public class WebFluxApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .web(WebApplicationType.REACTIVE)
                .sources(WebFluxApp.class)
                .run(args);
    }
}