package org.laidu.learn.spring.boot.cache;


import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CacheApp {

    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .main(CacheApp.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);

    }
}
