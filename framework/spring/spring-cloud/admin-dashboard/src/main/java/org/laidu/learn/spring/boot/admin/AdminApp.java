package org.laidu.learn.spring.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring boot admin
 *
 * @author tiancai.zang
 * on 2018-08-23 17:19.
 */
@Slf4j
@Configuration
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableAdminServer
public class AdminApp {

    @Configuration
    public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll()
                    .and().csrf().disable();
        }
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(AdminApp.class)
                .bannerMode(Banner.Mode.OFF)
                .registerShutdownHook(true)
                .logStartupInfo(false)
                .run(args);

    }
}