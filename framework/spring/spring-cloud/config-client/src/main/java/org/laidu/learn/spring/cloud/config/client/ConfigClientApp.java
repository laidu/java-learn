package org.laidu.learn.spring.cloud.config.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 配置中心 客户端
 * <p>
 * Created by tiancai.zang
 * on 2018-07-30 22:25.
 */
@Slf4j
@SpringBootApplication
public class ConfigClientApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClientApp.class)
                .logStartupInfo(false)
                .web(WebApplicationType.SERVLET)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}