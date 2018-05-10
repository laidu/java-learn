package org.laidu.learn.spring.boot.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author laidu
 */
@Slf4j
@SpringBootApplication
public class SpringBootAppApplication {

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(SpringBootAppApplication.class, args);
	}
}
