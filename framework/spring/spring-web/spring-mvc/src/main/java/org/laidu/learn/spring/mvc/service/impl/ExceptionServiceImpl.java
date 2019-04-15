package org.laidu.learn.spring.mvc.service.impl;

import org.laidu.learn.spring.mvc.service.ExceptionService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zangtiancai
 * @date 2019-03-21 21:06.
 */
@Slf4j
@Service
public class ExceptionServiceImpl implements ExceptionService {
    @Override
    public String exception() {

        String var = null;

        log.info("{}",var.length());

        return null;
    }

    @Override
    public String nullException() {
        return null;
    }
}
