package org.laidu.learn.spring.boot.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author laidu
 */
@Slf4j
@SpringBootApplication
public class SpringBootAppApplication {


	public static void main(String[] args) {


		SpringApplication.run(SpringBootAppApplication.class,args);

		new SpringApplicationBuilder()
				.sources(SpringBootAppApplication.class)
				.registerShutdownHook(true)
				.logStartupInfo(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}
}
