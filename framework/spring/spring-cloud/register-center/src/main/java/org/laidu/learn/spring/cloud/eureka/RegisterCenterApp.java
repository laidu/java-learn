package org.laidu.learn.spring.cloud.eureka;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author laidu
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterCenterApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RegisterCenterApp.class)
				.bannerMode(Banner.Mode.OFF)
				.logStartupInfo(false)
				.run(args);
	}
}
