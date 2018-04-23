package org.laidu.learn.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.mybatis.mapper.AppUserMapper;
import org.laidu.learn.mybatis.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * user info
 * <p>
 * Created by tiancai.zang
 * on 2018-04-22 16:25.
 */
@Slf4j
@RestController
@RequestMapping("/")
public class UserInfoController {

    private final AppUserMapper userMapper;

    @Autowired
    public UserInfoController(AppUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/query/{id}")
    public AppUser queryById(@PathVariable("id") Long id){

        AppUser user = userMapper.selectByPrimaryKey(id);

        return user;
    }

}