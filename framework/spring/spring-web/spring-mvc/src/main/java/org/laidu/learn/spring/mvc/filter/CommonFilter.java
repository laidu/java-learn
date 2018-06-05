package org.laidu.learn.spring.mvc.filter;

import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.mvc.properties.MvcProperties;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * common filter
 * <p>
 * Created by tiancai.zang
 * on 2018-05-31 14:32.
 *
 * @author tiancai.zang
 */
@Slf4j
@Component
public class CommonFilter implements HandlerInterceptor {

    @Autowired
    private MvcProperties mvcProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uuid = (String) request.getAttribute(mvcProperties.getLogbackUuid());
        if (StringUtil.isEmpty(uuid)) {
            uuid = UUID.randomUUID().toString();
        }
        MDC.put(mvcProperties.getLogbackUuid(),uuid);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.clear();
    }
}