package org.laidu.learn.spring.mvc;

import org.laidu.learn.spring.mvc.conf.StorageProperties;
import org.laidu.learn.spring.mvc.service.StorageService;
import org.laidu.learn.swagger.demo.config.SwaggerConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import lombok.extern.slf4j.Slf4j;

/**
 * spring mvc app
 * <p>
 * Created by tiancai.zang
 * on 2018-05-30 11:29.
 */
@Slf4j
@Import(SwaggerConfig.class)
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MvcApp {

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(MvcApp.class)
                .logStartupInfo(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}