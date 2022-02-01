package org.laidu.learn.swagger.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author laidu
 */
@SpringBootApplication
public class SwaggerApplication {
	public static void main(String[] args) {

		new SpringApplicationBuilder(SwaggerApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.logStartupInfo(false)
				.run(args);
	}
}
