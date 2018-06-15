package org.laidu.learn.webfulx.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.webfulx.service.HelloService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by tiancai.zang
 * on 2018-06-15 15:27.
 *
 * @author tiancai.zang
 */
// TODO: 2018-06-15 15:27  
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello() {
        return "hello";
    }

    @Override
    @Async
    public String sayHelloSlow() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "helloSlow";
    }
}