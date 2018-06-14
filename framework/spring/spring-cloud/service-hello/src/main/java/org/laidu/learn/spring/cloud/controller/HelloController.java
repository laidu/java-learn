package org.laidu.learn.spring.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * hello controller
 *
 * @author tiancai.zang
 * @date 2018-03-05 13:50.
 */
@Slf4j
@RestController
@RequestMapping("/")
public class HelloController {

    private final ServiceInstance serviceInstance;

    @Autowired
    public HelloController(ServiceInstance instance) {
        this.serviceInstance = instance;
    }

    @GetMapping("/hello")
    public String index(){
        log.info("service host: {} , service id : {}", serviceInstance.getHost(),serviceInstance.getServiceId());
        return "hello";
    }
}