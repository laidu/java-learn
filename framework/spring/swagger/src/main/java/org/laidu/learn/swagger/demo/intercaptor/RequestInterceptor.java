package org.laidu.learn.swagger.demo.intercaptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * RequestInterceptor
 * <p>
 * Created by tiancai.zang on 2017-12-13 18:36.
 */
@Slf4j
@Component
// : 2017/12/13 18/36 RequestInterceptor
public class RequestInterceptor extends HandlerInterceptorAdapter {

    /**
     * This is not a good practice to use sysout. Always integrate any logger
     * with your application. We will discuss about integrating logger with
     * spring boot application in some later article
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        
        log.info("In preHandle we are Intercepting the Request");
        String requestURI = request.getRequestURI();
        Integer personId = ServletRequestUtils.getIntParameter(request, "personId", 0);
        log.info("RequestURI::" + requestURI +
                " || Search for Person with personId ::" + personId);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView model)
            throws Exception {
        log.info("In postHandle request processing "
                + "completed by @RestController");

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String body = IOUtils.toString(reader);

        System.out.println(body);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object object, Exception arg3)
            throws Exception {
        log.info("In afterCompletion Request Completed");

    }

}