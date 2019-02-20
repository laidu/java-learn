package org.laidu.learn.spring.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.retry.annotation.EnableRetry;

/**
 * retry app
 * <p>
 * Created by tiancai.zang
 * on 2019-02-20 23:26.
 */
@Slf4j
@SpringBootApplication
@EnableRetry
public class RetryApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RetryApp.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);
    }
}