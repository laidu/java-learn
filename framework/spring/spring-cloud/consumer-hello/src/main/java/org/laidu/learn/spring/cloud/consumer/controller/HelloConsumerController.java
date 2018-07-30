package org.laidu.learn.spring.cloud.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.cloud.consumer.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tiancai.zang
 * @date 2018-03-05 14:09.
 */
@Slf4j
@RestController
@RequestMapping("/")
public class HelloConsumerController {


    private final HelloService helloService;

    public HelloConsumerController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping("/hello-consumer")
    public String helloConsumer(){

        return helloService.hello();
    }
}