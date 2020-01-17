package org.laidu.learn.spring.boot.app.service.impl;

import java.util.UUID;

import org.laidu.learn.spring.boot.app.service.ThreadLocalService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zangtiancai.
 * @date 2019/12/23 下午9:30.
 */
@Slf4j
@Service
public class ThreadLocalServiceImpl implements ThreadLocalService {

    private static final ThreadLocal<String> BODY_CACHED = new ThreadLocal<>();

    @Override
    public String sayHello(String reqBody) {
        String body = reqBody;
        for (int i = 0; i < 100; i++) {
            body += body+UUID.randomUUID().toString();
        }
        BODY_CACHED.set(reqBody+UUID.randomUUID().toString()+body);
        return "hello";
    }
}
