package org.laidu.learn.spring.cloud.service.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务网关
 * <p>
 * Created by tiancai.zang
 * on 2018-07-31 22:35.
 */
@Slf4j
@EnableZuulProxy
@SpringBootApplication
public class ServiceApiApp {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ServiceApiApp.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);
    }
}