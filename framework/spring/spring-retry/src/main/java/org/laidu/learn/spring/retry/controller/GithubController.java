package org.laidu.learn.spring.retry.controller;

import org.laidu.learn.spring.retry.model.GithubUserInfo;
import org.laidu.learn.spring.retry.service.GithubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * github api
 * <p>
 * Created by tiancai.zang
 * on 2019-02-20 23:50.
 */
@Slf4j
@RestController
@RequestMapping("/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/user/{user}")
    public GithubUserInfo queryUserinfo(@PathVariable(name = "user") String user){

        return githubService.queryUserInfo(user);
    }
}