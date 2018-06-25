package org.laidu.learn.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.laidu.learn.spring.aop.annotation.processor.MethodMonitorProcessor;

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
     * 日志打印 逻辑
     *
     */
    Class<? extends LogPrintLogic> logic() default MethodMonitorProcessor.DefaultLogPrintLogic.class;

    String value() default "";

    @FunctionalInterface
    interface LogPrintLogic {
        Object build(ProceedingJoinPoint joinPoint) throws Throwable;
    }

}
