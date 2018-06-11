package org.laidu.learn.spring.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

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
        log.info("url : {}",  request.getRequestURI());
        return "hello";
    }

    @GetMapping("/sleep")
    public Integer sleep(@RequestParam("sec") int secends ) throws InterruptedException {

        Thread.sleep(secends * 1000);
        return secends;
    }

    @GetMapping("/sleepRandom")
    public Integer sleepRandom(@RequestParam("sec") int secends ) throws InterruptedException {

        Thread.sleep(new Random(100).nextInt(secends) * 1000);
        return secends;
    }


}