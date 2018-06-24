package org.laidu.learn.spring.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.aop.annotation.MethodMonitor;
import org.laidu.learn.spring.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * home controller
 * <p>
 * Created by tiancai.zang
 * on 2018-06-23 19:07.
 */
@Slf4j
@RestController
@RequestMapping("/")
public class HomeController {

    final
    UserService userService;


    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @MethodMonitor
    public String home(){
        return "hello";
    }


}