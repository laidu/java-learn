package org.laidu.learn.spring.retry.conf;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * retry config
 *
 * @author zangtiancai
 * @date 2019-02-21 11:26.
 */
@Slf4j
@Configuration
public class RetryConfig {

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate template = new RetryTemplate();

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        template.setRetryPolicy(retryPolicy);

        return template;
    }

    @Bean(name = "githubRestApi")
    public RestTemplate githubRestApi(){
        return new RestTemplateBuilder()
                .setReadTimeout(Duration.of(800, ChronoUnit.MICROS))
                .build();
    }
}
