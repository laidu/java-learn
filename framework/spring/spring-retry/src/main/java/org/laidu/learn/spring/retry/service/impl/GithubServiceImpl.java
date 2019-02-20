package org.laidu.learn.spring.retry.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.retry.model.GithubUserInfo;
import org.laidu.learn.spring.retry.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tiancai.zang
 * on 2019-02-20 23:45.
 */
@Slf4j
@Service
public class GithubServiceImpl implements GithubService {


    @Autowired
    private RestTemplate githubRestApi;

    @Value("${github.user.api:https://api.github.com/users/}")
    private String usersUrl;


    @Override
    @Retryable
    public GithubUserInfo queryUserInfo(String user) {
        log.info(" query user {}",user);
        return githubRestApi.getForEntity(usersUrl.concat(user),GithubUserInfo.class)
                .getBody();
    }

    @Bean(name = "githubRestApi")
    private RestTemplate githubRestApi(){
        return new RestTemplateBuilder()
                .setReadTimeout(500)
                .build();
    }
}