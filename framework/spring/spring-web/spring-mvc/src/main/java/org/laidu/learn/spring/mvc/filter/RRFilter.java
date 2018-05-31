package org.laidu.learn.spring.mvc.filter;

import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.mvc.properties.MvcProperties;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * req rep filter
 * <p>
 * Created by tiancai.zang
 * on 2018-05-30 14:17.
 *
 * @author tiancai.zang
 */
@Slf4j
@Component
public class RRFilter implements Filter {

    @Autowired
    private MvcProperties mvcProperties;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter name: {}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String uuid = request.getParameter(mvcProperties.getLogbackUuid());

        if ("POST".equalsIgnoreCase(((HttpServletRequest)request).getMethod()))
        {
            String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            log.info("request url:{} body: {}",((HttpServletRequest) request).getRequestURL(), test.replaceAll("\n",""));
        }


        if (StringUtil.isEmpty(uuid)){
            uuid = ((HttpServletRequest)request).getSession().getId();
            ((HttpServletResponse)response).addCookie(new Cookie(mvcProperties.getLogbackUuid(),uuid));
        }
        MDC.put("UUID",uuid);

        chain.doFilter(request,response);


        MDC.clear();
    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}