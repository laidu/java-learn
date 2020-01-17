package org.laidu.learn.spring.boot.app.config;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志拦截器
 *
 * @author zangtiancai.
 * @date 2019/12/11 下午9:33.
 */
@Slf4j
@Order(1)
@Component
public class LoggingFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化日志filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       try {
           String sessionId = UUID.randomUUID().toString();
           String spanId = sessionId;
           MDC.put("X-B3-TraceId", sessionId);
           MDC.put("X-B3-SpanId", spanId);
       } catch (Exception e) {
           log.error("设置 mdc error in filter", e);
       }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            try {
                MDC.clear();
            } catch (Exception e) {
                log.error("mdc clear 失败", e);
            }
        }

    }

    @Override
    public void destroy() {
        log.info("销毁日志filter");
    }
}
