package org.laidu.learn.spring.boot.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author laidu
 */
@Slf4j
@SpringBootApplication
public class SpringBootAppApplication {


	@Configuration
	public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().permitAll()
					.and().csrf().disable();
		}
	}

	public static void main(String[] args) {

		new SpringApplicationBuilder()
				.sources(SpringBootAppApplication.class)
				.registerShutdownHook(true)
				.logStartupInfo(true)
				.run(args);
	}
}
