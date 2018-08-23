package org.laidu.learn.spring.cloud.config.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置服务
 * <p>
 * Created by tiancai.zang
 * on 2018-07-30 21:30.
 */
@Slf4j
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerApp {


    public static void main(String[] args) {

        new SpringApplicationBuilder(ConfigServerApp.class)
                .logStartupInfo(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}