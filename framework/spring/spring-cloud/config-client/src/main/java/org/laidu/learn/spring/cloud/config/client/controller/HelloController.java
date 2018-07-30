package org.laidu.learn.spring.cloud.config.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello
 * <p>
 * Created by tiancai.zang
 * on 2018-07-30 22:30.
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping("/")
public class HelloController {

    @Value("${config.version:0.0.1}")
    String version;

    @GetMapping("version")
    public String getVersion(){
        return version;
    }

}