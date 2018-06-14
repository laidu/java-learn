package org.laidu.learn.spring.boot.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author laidu
 */
@Slf4j
@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder()
				.sources(SpringBootAppApplication.class)
//				.web(WebApplicationType.NONE)
				.registerShutdownHook(true)
				.logStartupInfo(true)
				.run(args);
	}
}
