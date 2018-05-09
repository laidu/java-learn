package org.laidu.learn.spring.boot.app.controller;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.boot.app.dto.DemoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo
 * <p>
 * Created by tiancai.zang
 * on 2018-05-09 22:48.
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {


    @PostMapping("/hello")
    public DemoDTO demo(@RequestBody DemoDTO demoDTO){
        demoDTO.setCreateDate(System.currentTimeMillis());
        return demoDTO;
    }
}