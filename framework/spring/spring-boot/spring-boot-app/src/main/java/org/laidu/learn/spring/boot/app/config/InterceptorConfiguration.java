package org.laidu.learn.spring.boot.app.config;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志拦截器
 *
 * @author zangtiancai.
 * @date 2019/12/11 下午9:59.
 */
@Slf4j
//@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor());
    }

    static class LoggingInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            String sessionId = UUID.randomUUID().toString();
            String spanId = sessionId;
            MDC.put("X-B3-TraceId", sessionId);
            MDC.put("X-B3-SpanId", spanId);
            return super.preHandle(request, response, handler);
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            super.afterCompletion(request, response, handler, ex);

            try {
                MDC.clear();
            } catch (Exception e) {
                log.error("mdc clear 失败", e);
            }
        }
    }
}
