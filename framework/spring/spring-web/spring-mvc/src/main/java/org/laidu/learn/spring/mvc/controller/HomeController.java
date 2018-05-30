package org.laidu.learn.spring.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * home
 * <p>
 * Created by tiancai.zang
 * on 2018-05-30 13:53.
 *
 * @author tiancai.zang
 */
@Slf4j
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) throws InterruptedException {

        Thread.sleep(500);
        return "hello" + request.getRequestURI();
    }
}