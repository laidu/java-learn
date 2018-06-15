package org.laidu.learn.spring.aop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by tiancai.zang
 * on 2018-06-15 16:36.
 *
 * @author tiancai.zang
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(String name) {
        log.info("addUser: {}", name);
    }

    @Override
    public void removeUser(String name) {
        log.info("removeUser: {}", name);
    }

    @Override
    public String getUsername(String name) {
        log.info("getUsername: {}", name);
        return name;
    }

    @Override
    public String getUsernameFromSelf(String name) {
        log.info("getUsernameFromSelf: {}", name);
        return getUsername(name);
    }
}