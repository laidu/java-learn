package org.laidu.learn.spring.aop.proxy._static;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.aop.service.UserService;

/**
 * jdk 代理静态实现 只能代理实现了的接口方法
 * static proxy
 * <p>
 * Created by tiancai.zang
 * on 2018-06-15 16:38.
 *
 * @author tiancai.zang
 */
@Slf4j
@AllArgsConstructor
public class StaticJdkProxyDemo implements UserService {

    private UserService userService;

    @Override
    public void addUser(String name) {
        log.warn("before add user");
        userService.addUser(name);
        log.warn("after add user");
    }

    @Override
    public void removeUser(String name) {
        log.warn("before remove user");
        userService.removeUser(name);
        log.warn("after remove user");
    }

    @Override
    public String getUsername(String name) {
        log.warn("before get username");
        String username =  userService.getUsername(name);
        log.warn("after get username");

        return username;
    }

    @Override
    public String getUsernameFromSelf(String name) {

        log.warn("before get username from self");
        String username =  userService.getUsernameFromSelf(name);
        log.warn("after get username");
        return username;
    }
}