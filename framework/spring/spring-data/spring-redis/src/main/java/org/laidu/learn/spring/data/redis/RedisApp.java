package org.laidu.learn.spring.data.redis;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

import lombok.extern.slf4j.Slf4j;

/**
 * redis
 * <p>
 * Created by tiancai.zang
 * on 2018-05-22 09:55.
 * @author laidu
 */
@Slf4j
@EnableCaching
@SpringBootApplication
public class RedisApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RedisApp.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);
    }
}