package org.laidu.learn.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法执行 monitor
 * <p>
 * Created by laidu
 * on 2018-06-22 16:07.
 *
 * @author laidu
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodMonitor {

    /**
     * 日志 前缀
     * @return prefix。
     */
    String prefix() default "";

    @FunctionalInterface
    interface LogPrintLogic{
        Object build(ProceedingJoinPoint joinPoint) throws Throwable;
    }

}
