package org.laidu.learn.spring.mvc.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.mvc.service.HelloService;
import org.springframework.stereotype.Service;
import xyz.xpcoder.commons.common.monitor.annoation.MethodMonitor;

/**
 * hello service
 * <p>
 * Created by laidu
 * on 2018-07-16 15:15.
 *
 * @author laidu
 */
// TODO: 2018-07-16 15:15  hello service
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @MethodMonitor
    public String sayHello() {
        return "hello";
    }
}