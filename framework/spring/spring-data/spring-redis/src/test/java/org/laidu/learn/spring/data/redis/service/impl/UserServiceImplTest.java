package org.laidu.learn.spring.data.redis.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.laidu.learn.spring.data.redis.model.UserInfo;
import org.laidu.learn.spring.data.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

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

    @Autowired
    private StringRedisTemplate redisTemplate1;

    String cacheKey = "demo";


    @Test
    void expireTest(){

        String key = "haha";

        Long aLong = 0L;

        if (redisTemplate1.opsForValue().setIfAbsent(key,"0")) {

            Date expireDate = Date.from(Instant.ofEpochMilli(System.currentTimeMillis())
                    .plus(500, convert(TimeUnit.MILLISECONDS)));
            redisTemplate1.expireAt(key, expireDate);
        }

        if (redisTemplate1.hasKey(key)) {
            aLong = redisTemplate1.opsForValue().increment(key, 1);

            Date expireDate = Date.from(Instant.ofEpochMilli(System.currentTimeMillis())
                    .plus(500, convert(TimeUnit.MILLISECONDS)));
        }

        ThreadUtil.sleep(250);
        Assert.assertTrue(redisTemplate.hasKey(key));
        ThreadUtil.sleep(261);
        Assert.assertFalse(redisTemplate.hasKey(key));


        log.info("result : {}",aLong);

    }

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

    public static ChronoUnit convert(TimeUnit tu) {
        if (tu == null) {
            return null;
        }
        switch (tu) {
            case DAYS:
                return ChronoUnit.DAYS;
            case HOURS:
                return ChronoUnit.HOURS;
            case MINUTES:
                return ChronoUnit.MINUTES;
            case SECONDS:
                return ChronoUnit.SECONDS;
            case MICROSECONDS:
                return ChronoUnit.MICROS;
            case MILLISECONDS:
                return ChronoUnit.MILLIS;
            case NANOSECONDS:
                return ChronoUnit.NANOS;
            default:
                assert false : "there are no other TimeUnit ordinal values";
                return null;
        }
    }

    @Test
    void updateUsername() {

        IntStream.range(0,1000).parallel()
                .forEach( i -> {
                    userService.updateUsername("123","xiaoming"+i);
                });
    }
}