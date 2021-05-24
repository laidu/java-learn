package org.laidu.learn.spring.cloud.hystrix;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import lombok.extern.slf4j.Slf4j;

/**
 * hystrix-dashboard
 * <p>
 * Created by tiancai.zang
 * on 2018-07-23 21:57.
 */
@Slf4j
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashApp {

    public static void main(String[] args) {


        new SpringApplicationBuilder(HystrixDashApp.class)
                .logStartupInfo(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}