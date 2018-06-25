package org.laidu.learn.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.annotation.*;

/**
 * 方法执行 monitor
 * <p>
 * Created by laidu
 * on 2018-06-22 16:07.
 *
 * @author laidu
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodMonitor {

    /**
     * 日志 前缀
     * @return prefix。
     */
    String prefix() default "";

    interface LogPrintLogic{
        Object build(ProceedingJoinPoint joinPoint) throws Throwable;
    }

}
