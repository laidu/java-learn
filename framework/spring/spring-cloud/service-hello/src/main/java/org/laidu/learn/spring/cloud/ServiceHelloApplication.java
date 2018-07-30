package org.laidu.learn.spring.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author laidu
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceHelloApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceHelloApplication.class)
				.logStartupInfo(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}
}
