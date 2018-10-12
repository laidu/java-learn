package org.laidu.learn.spring.cloud.service.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务网关
 * <p>
 * Created by tiancai.zang
 * on 2018-07-31 22:35.
 */
@Slf4j
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApp {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ApiGatewayApp.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}