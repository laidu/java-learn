package org.laidu.learn.spring.boot.app;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

import lombok.extern.slf4j.Slf4j;

/**
 * @author laidu
 */
@Slf4j
@EnableCaching
@SpringBootApplication
public class SpringBootAppApplication {


	public static void main(String[] args) {


		new SpringApplicationBuilder()
				.sources(SpringBootAppApplication.class)
				.registerShutdownHook(true)
				.logStartupInfo(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}
}
