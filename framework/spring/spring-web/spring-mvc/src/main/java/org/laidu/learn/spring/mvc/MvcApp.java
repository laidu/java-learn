package org.laidu.learn.spring.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import xyz.xpcoder.commons.common.monitor.annoation.EnableMonitor;

/**
 * spring mvc app
 * <p>
 * Created by tiancai.zang
 * on 2018-05-30 11:29.
 */
@Slf4j
@EnableMonitor
@SpringBootApplication
public class MvcApp {

    public static void main(String[] args) {

        new SpringApplicationBuilder(MvcApp.class)
                .logStartupInfo(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}