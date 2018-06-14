package org.laidu.learn.spring.boot.app.controller;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.boot.app.dto.DemoDTO;
import org.springframework.web.bind.annotation.*;

/**
 * demo
 * <p>
 * Created by tiancai.zang
 * on 2018-05-09 22:48.
 */
@Slf4j
@Timed
@RestController
@RequestMapping("/")
public class DemoController {


    @PostMapping("/demo")
    public DemoDTO demo(@RequestBody DemoDTO demoDTO){
        demoDTO.setCreateDate(System.currentTimeMillis());
        return demoDTO;
    }

    @GetMapping("/hello")
    @Timed(extraTags = { "region", "us-east-1" })
    @Timed(value = "all.people", longTask = true)
    public String demo(){
        return "hello";
    }
}