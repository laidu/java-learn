package org.laidu.learn.spring.aop.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;


/**
 * 请求/相应 拦截器
 * <p>
 * Created by tiancai.zang
 * on 2018-06-23 19:25.
 */
@Slf4j
@Order(5)
@Component
public class RRFilter extends OncePerRequestFilter{



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        StopWatch stopWatch = new StopWatch();
        ApiMonitorData data = new ApiMonitorData(request.getServletPath(),request.getMethod());
        data.setClientAddr(request.getRemoteAddr());

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

        data.setRequestBody(getBody(wrappedRequest));

        try {
            stopWatch.start();
            filterChain.doFilter(request,response);
            data.setHttpStatus(response.getStatus());
        }catch (Exception ex){
            data.setEx(ex);
            throw ex;

        }finally {
            stopWatch.stop();
            data.setElapsedTime(stopWatch.getTotalTimeMillis());
            log.info("data: {}", data);
        }

    }


    private String getBody(ContentCachingRequestWrapper request) {
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        String payload = null;
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {

                try {
                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                }
                catch (UnsupportedEncodingException ex) {
                    payload = "[unknown]";
                }


            }
        }
        return payload;
    }


    @Data
    public static class ApiMonitorData{


        public ApiMonitorData(String url, String method) {
            this.url = url;
            this.method = method;
            this.requestTime = new Date();
        }

        private String url;
        private String contentPath;

        private String method;

        private long elapsedTime;

        private Date requestTime;

        private String requestBody;

        private String responseBody;

        private int httpStatus;

        private String code;

        private String message;

        private Throwable ex;

        private Map<String,String> others;

        private String clientAddr;

    }

}