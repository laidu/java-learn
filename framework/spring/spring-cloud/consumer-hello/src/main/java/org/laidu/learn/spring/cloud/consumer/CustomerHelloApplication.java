package org.laidu.learn.spring.cloud.consumer;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author laidu
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class CustomerHelloApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {

		new SpringApplicationBuilder(CustomerHelloApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.logStartupInfo(false)
				.run(args);
	}
}
