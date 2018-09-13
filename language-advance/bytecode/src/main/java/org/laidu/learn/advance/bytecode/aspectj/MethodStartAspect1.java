package org.laidu.learn.advance.bytecode.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * MethodStartAspect
 *
 * @author tiancai.zang
 * on 2018-08-28 19:05.
 */
@Aspect
public class MethodStartAspect1 {

    private static ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(logStartTime1)")
    private void logStartTimePointcut(LogStartTime1 logStartTime1) {

    }

    @Before("logStartTimePointcut(logStartTime1)")
    public void setStartTimeInThreadLocal(LogStartTime1 logStartTime1) {
        System.out.println(logStartTime1.value());
        startTime.set(System.currentTimeMillis());
        System.out.println("saved method start time in threadLocal");
    }

    public static Long getStartTime() {
        return startTime.get();
    }

    public static void clearStartTime() {
        startTime.set(null);
    }
}