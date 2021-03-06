package org.laidu.learn.spring.boot.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.boot.app.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tiancai.zang
 * on 2018-11-02 19:50.
 */
@Slf4j
@Service("demoServiceB")
public class DemoServiceBImpl implements DemoService {

    @Resource(name = "demoServiceA")
    private DemoService demoService;

    @Override
    public void work() {
        demoService.work();
    }
}