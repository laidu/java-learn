package org.laidu.learn.spring.retry.controller;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.retry.model.GithubUserInfo;
import org.laidu.learn.spring.retry.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Autowired
    private GithubService githubService;

    @GetMapping("/user/{user}")
    public GithubUserInfo queryUserinfo(@PathVariable(name = "user") String user){

        return githubService.queryUserInfo(user);
    }
}