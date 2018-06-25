package org.laidu.learn.spring.aop.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.laidu.learn.spring.aop.annotation.MethodMonitor;
import org.springframework.stereotype.Component;

/**
 * UserServiceLogLogic
 * <p>
 * Created by laidu
 * on 2018-06-25 11:57.
 *
 * @author laidu
 */
// TODO: 2018-06-25 11:57  UserServiceLogLogic
@Slf4j
@Component
public  class UserServiceLogLogic implements MethodMonitor.LogPrintLogic {

    @Override
    public Object build(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("classname: {}", UserServiceLogLogic.class.getName());
        return joinPoint.proceed();
    }
}