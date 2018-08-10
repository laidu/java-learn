package org.laidu.learn.spring.boot.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 单点登录
 *
 * @author tiancai.zang
 * on 2018-08-10 19:00.
 */
// TODO: 2018-08-10 19:00  单点登录
@Slf4j
@RestController
@RequestMapping("/")
public class SSOController {

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}