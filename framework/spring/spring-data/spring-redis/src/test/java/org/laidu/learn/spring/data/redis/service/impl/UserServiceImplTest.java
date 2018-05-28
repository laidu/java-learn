package org.laidu.learn.spring.data.redis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.laidu.learn.spring.data.redis.RedisApp;
import org.laidu.learn.spring.data.redis.model.UserInfo;
import org.laidu.learn.spring.data.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@Slf4j
@SpringBootTest
@SpringJUnitConfig
@RunWith(SpringRunner.class)
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private RedisTemplate<String,UserInfo> redisTemplate;

    String cacheKey = "demo";

    @Test
    void serializeTest(){


        UserInfo userInfo = redisTemplate.opsForValue().get(cacheKey);
       
        log.info("user info: {}", userInfo);

    }

    @Test
    void cacheTest(){
        UserInfo userInfo1 = UserInfo.builder()
                .username("demo1")
//                .password("demo_password")
                .userId(UUID.randomUUID().toString())
                .build();
        redisTemplate.opsForValue().set(cacheKey,userInfo1);
    }

    @Test
    void getUserInfo() {

        UserInfo userInfo = userService.getUserInfo("xiaoming");

        log.info("user info: {}", userInfo);
    }

    @Test
    void addUser() {

        UserInfo userInfo = userService.addUser("xiaoming","123123");

        log.info("user info: {}", userInfo);
    }
}