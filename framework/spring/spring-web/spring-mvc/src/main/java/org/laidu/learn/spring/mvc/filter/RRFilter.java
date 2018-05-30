package org.laidu.learn.spring.mvc.filter;

import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter name: {}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String uuid = String.valueOf(request.getAttribute("UUID"));

        if (StringUtil.isEmpty(uuid)){
            uuid = ((HttpServletRequest)request).getSession().getId();
            request.setAttribute("UUID",uuid);
            MDC.put("UUID",uuid);
        }


        log.info("local name: {}", request.getLocalName());
        log.info("local: {}", response.getLocale().getDisplayName());

        chain.doFilter(request,response);

        MDC.clear();
    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}