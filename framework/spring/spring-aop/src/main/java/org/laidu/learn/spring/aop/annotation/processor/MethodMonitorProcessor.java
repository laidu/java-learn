package org.laidu.learn.spring.aop.annotation.processor;

import com.alibaba.fastjson.JSON;
import jodd.exception.ExceptionUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.laidu.learn.spring.aop.annotation.MethodMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.Serializable;
import java.util.Optional;

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
    private ApplicationContext context;

    @Pointcut("@annotation(org.laidu.learn.spring.aop.annotation.MethodMonitor)")
    private void pointcut() {
    }

    @Around("pointcut() && @annotation(monitor)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, MethodMonitor monitor) throws Throwable {

        MethodMonitor.LogPrintLogic logPrintLogic;
        try {
            logPrintLogic = context.getBean(monitor.logic());
        }catch (Exception ex){
            log.error("未找到日志打印逻辑： {}， 将使用默认逻辑打印日志！", monitor.logic());
            logPrintLogic = context.getBean(DefaultLogPrintLogic.class);
        }
        return logPrintLogic.build(joinPoint);
    }

    public class DefaultLogPrintLogic implements MethodMonitor.LogPrintLogic {

        @Override
        public Object build(ProceedingJoinPoint joinPoint) throws Throwable {

            StopWatch watch = new StopWatch();
            Object proceed = null;
            MethodMonitorProcessor.MonitorBaseData data = new MethodMonitorProcessor.MonitorBaseData();

            CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();


            StringBuilder argsString = new StringBuilder();

            for (int i = 0; i < codeSignature.getParameterNames().length; i++) {

                Object arg = joinPoint.getArgs()[i];
                argsString
                        .append(codeSignature.getParameterNames()[i])
                        .append(" : ")
                        .append(arg.getClass().isPrimitive() ? String.valueOf(arg) : JSON.toJSONString(arg))
                        .append("; ");
            }

            data.setArgs(argsString.toString());

            watch.start();

            try {
                proceed = joinPoint.proceed();

                Optional.ofNullable(proceed)
                        .ifPresent(proceed1 -> data.setResult(proceed1.getClass().isPrimitive() ? String.valueOf(proceed1) : JSON.toJSONString(proceed1)));

                data.setSuccess(true);
                data.setElapsedTime(watch.getTotalTimeMillis());
                data.setMethodSignature(joinPoint.getSignature().toLongString());

            } catch (Exception ex) {
                data.setExceptionClass(ex.getClass().getTypeName());
                data.setExceptionStackTrace(ExceptionUtil.exceptionStackTraceToString(ex));
                throw ex;
            } finally {
                watch.stop();
                log.warn("{} with args {} executed in {} ms", joinPoint.getSignature(), joinPoint.getArgs(), watch.getTotalTimeMillis());
                
                log.info("data: {}", data);
            }

            return proceed;
        }
    }


    @Bean
    public DefaultLogPrintLogic logPrintLogic() {
        return new DefaultLogPrintLogic();
    }

    @Data
    public static class MonitorBaseData implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 方法执行时间
         */
        private long elapsedTime;

        /**
         * 方法签名
         */
        private String methodSignature;

        /**
         * 方法 key
         */
        private String methodKey;

        /**
         * 方法参数
         */
        private String args;

        /**
         * 执行结果
         */
        private String result;

        /**
         * 是否成功
         * 1 成功、0 失败
         */
        private int success = 0;

        /**
         * 异常类型
         */
        private String exceptionClass;

        /**
         * exceptionStackTrace
         */
        private String exceptionStackTrace;


        public void setSuccess(boolean success) {
            this.success = success ? 1 : 0;
        }

    }
}