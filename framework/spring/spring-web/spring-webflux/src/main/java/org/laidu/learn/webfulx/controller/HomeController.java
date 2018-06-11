package org.laidu.learn.webfulx.controller;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.webfulx.model.HelloModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

/**
 * home controller
 * <p>
 * Created by tiancai.zang
 * on 2018-06-11 23:20.
 * @author laidu
 */
@Slf4j
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public String idnex(){
        return "hello";
    }

    @GetMapping("hello")
    public HelloModel hello(@RequestParam("user") String username){
        return HelloModel.builder()
                .message("hello")
                .currentDate(LocalDate.now())
                .username(username)
                .build();
    }
}