package org.laidu.learn.spring.aop.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 请求/相应 拦截器
 * <p>
 * Created by tiancai.zang
 * on 2018-06-23 19:25.
 */
@Slf4j
@Order(5)
@Component
public class RRFilter implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("request url: {}", request.getRequestURL());
        log.info("reponse status: {}", response.getStatus());
    }
}