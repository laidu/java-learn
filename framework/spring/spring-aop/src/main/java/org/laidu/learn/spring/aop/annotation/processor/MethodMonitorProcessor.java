package org.laidu.learn.spring.aop.annotation.processor;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.laidu.learn.spring.aop.annotation.MethodMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.Serializable;

/**
 * 注解processor
 * <p>
 * Created by laidu
 * on 2018-06-22 16:11.
 *
 * @author laidu
 */
@Slf4j
@Aspect
@Component
public class MethodMonitorProcessor {


    @Autowired
    private MethodMonitor.LogPrintLogic logPrintLogic;

    @Pointcut("@annotation(org.laidu.learn.spring.aop.annotation.MethodMonitor)")
    private void pointcut() {
    }

    @Around("pointcut() && @annotation(monitor)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, MethodMonitor monitor) throws Throwable {
        return logPrintLogic.build(joinPoint);
    }


    @Bean
    public DefaultLogPrintLogic logPrintLogic() {
        return new DefaultLogPrintLogic();
    }

    @Slf4j
    public static class DefaultLogPrintLogic implements MethodMonitor.LogPrintLogic {

        @Override
        public Object build(ProceedingJoinPoint joinPoint) throws Throwable {

            StopWatch watch = new StopWatch();
            Object proceed = null;
            MonitorBaseData data = new MonitorBaseData();

            watch.start();

            try {
                proceed = joinPoint.proceed();
                data.setSuccess(true);
                data.setElapsedTime(watch.getTotalTimeMillis());
                data.setMethodSignature(joinPoint.getSignature().toLongString());

            } catch (Exception ex) {

                throw ex;
            } finally {
                watch.stop();
                log.warn("{} with args {} executed in {} ms", joinPoint.getSignature(), joinPoint.getArgs(), watch.getTotalTimeMillis());
            }

            return proceed;
        }
    }

    @Data
    public static class MonitorBaseData implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 方法执行时间
         */
        private long elapsedTime;

        /**
         * message
         */
        private String message;

        /**
         * 方法签名
         */
        private String methodSignature;

        /**
         * 方法 key
         */
        private String methodKey;

        /**
         * 是否成功
         * 1 成功、0 失败
         */
        private int success = 0;

        /**
         * 异常类型
         */
        private String exceptionClass;

        public void setSuccess(boolean success) {
            this.success = success ? 1 : 0;
        }

    }
}