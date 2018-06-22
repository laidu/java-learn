package org.laidu.learn.spring.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 * <p>
 * Created by laidu
 * on 2018-06-22 15:11.
 *
 * @author laidu
 */
@Slf4j
@Aspect
@Component
public class LogAop {

    @Pointcut("execution(public * org.laidu.learn.spring.aop.service..*(..))")
    public void serviceLog(){}

    @Before("serviceLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        log.info("class name: {} method : {} args:{}",joinPoint.getTarget().getClass().getName(), joinPoint.getSignature(),joinPoint.getArgs());

    }


    @AfterReturning(returning = "ret", pointcut = "serviceLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("result : " + ret);
    }

}