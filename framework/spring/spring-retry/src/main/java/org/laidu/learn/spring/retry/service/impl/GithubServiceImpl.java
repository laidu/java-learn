package org.laidu.learn.spring.retry.service.impl;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.laidu.learn.spring.retry.model.GithubUserInfo;
import org.laidu.learn.spring.retry.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by tiancai.zang
 * on 2019-02-20 23:45.
 */
@Slf4j
@Service
public class GithubServiceImpl implements GithubService {


    @Autowired
    private RestTemplate githubRestApi;


    @Autowired
    private RetryTemplate retryTemplate;

    @Value("${github.user.api:https://api.github.com/users/}")
    private String usersUrl;


    @Override
    @Retryable
    public GithubUserInfo queryUserInfo(String user) {


        try {
            return retryTemplate.execute((RetryCallback<GithubUserInfo, Exception>) retryContext ->{
                log.info(" query user {}",user);
                GithubUserInfo body = githubRestApi.getForEntity(usersUrl.concat(user), GithubUserInfo.class)
                        .getBody();
                return body;
            });
        } catch (Exception e) {
            log.error(" query user error: {}",user);
        }
        return new GithubUserInfo();
    }

    @Bean(name = "githubRestApi")
    private RestTemplate githubRestApi(){
        return new RestTemplateBuilder()
                .setReadTimeout(Duration.of(800, ChronoUnit.valueOf("Millis")))
                .build();
    }
}