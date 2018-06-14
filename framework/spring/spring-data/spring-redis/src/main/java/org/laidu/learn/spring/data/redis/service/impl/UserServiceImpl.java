package org.laidu.learn.spring.data.redis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.data.redis.model.UserInfo;
import org.laidu.learn.spring.data.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by tiancai.zang
 * on 2018-05-23 14:32.
 * @author laidu
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final RedisTemplate<String,UserInfo> redisTemplate;

    @Autowired
    public UserServiceImpl(RedisTemplate<String, UserInfo> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    @Cacheable("getUserInfo")
    public UserInfo getUserInfo(String key) {

        UserInfo userInfo = redisTemplate.opsForValue().get(key);

        if (userInfo == null) {
            log.info("cache null : {}", key);
            userInfo = addUser("demo","demo");
        }

        return userInfo;
    }

    @Override
    @Cacheable("userinfo")
    public UserInfo addUser(String username, String password) {
        return UserInfo.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
//                .password(password)
                .build();
    }
}