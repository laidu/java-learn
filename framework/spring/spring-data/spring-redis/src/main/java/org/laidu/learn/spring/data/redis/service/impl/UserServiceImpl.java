package org.laidu.learn.spring.data.redis.service.impl;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.laidu.learn.spring.data.redis.model.UserInfo;
import org.laidu.learn.spring.data.redis.service.UserService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

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
    private Redisson redission;

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

    @Override
    public UserInfo updateUsername(String id, String username) {


        boolean res = false;

        UserInfo info = null;

        RLock lock = redission.getLock("lock_"+id);

        try {

            lock.lock(10, TimeUnit.SECONDS);

            System.out.println("got lock");

        }catch (Exception e){
            log.warn("获取redis锁失败！ {}",id);
        } finally {
            try{
                lock.unlock();
            }finally {
                System.out.println("unlock");
            }
        }


        return info;
    }
}