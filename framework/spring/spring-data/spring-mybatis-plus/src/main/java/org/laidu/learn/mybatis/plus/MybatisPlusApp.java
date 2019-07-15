package org.laidu.learn.mybatis.plus;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * mybatis plus app
 *
 * @author zangtiancai.
 * @date 2019-07-12 10:42.
 */
@Slf4j
@SpringBootApplication
public class MybatisPlusApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MybatisPlusApp.class)
                .bannerMode(Banner.Mode.OFF)
                .build()
                .run(args);
    }
}
