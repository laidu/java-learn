package org.laidu.learn.mybatis.controller;

import java.util.List;
import java.util.Optional;

import org.laidu.learn.mybatis.entity.AppUser;
import org.laidu.learn.mybatis.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


/**
 * user info
 * <p>
 * Created by tiancai.zang
 * on 2018-04-22 16:25.
 */
@Slf4j
@RestController
@RequestMapping("/")
@EnableAutoConfiguration
public class UserInfoController {

    private final AppUserMapper userMapper;

    @Autowired
    public UserInfoController(AppUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/query/{id}")
    @Transactional(rollbackFor = Exception.class)
    public AppUser queryById(@PathVariable("id") Long id){

        AppUser user = userMapper.selectByPrimaryKey(id);

        System.out.println(Optional.ofNullable(user).orElse(AppUser.builder().build()).getUsername());

        return user;
    }

    @PostMapping("/add")
    @Deprecated
    @Transactional(rollbackFor = Exception.class)
    public AppUser add(@RequestBody AppUser user){

        userMapper.insert(user);

        return user;
    }

    @PostMapping("/add/v2")
    @Transactional(rollbackFor = Exception.class)
    public AppUser add2(@RequestBody AppUser user){

        userMapper.insert(user);

        return user;
    }


    @GetMapping("/query/{index}/{size}")
    public List<AppUser> queryById(@PathVariable("index") int index, @PathVariable("size") int size){

        return null;
    }

}