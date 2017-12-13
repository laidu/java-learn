package org.laidu.learn.swagger.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.swagger.demo.intercaptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web config
 * <p>
 * Created by tiancai.zang on 2017-12-13 18:39.
 */
@Slf4j
@Configuration
// : 2017/12/13 18/39 web config
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RequestInterceptor requestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor);
    }
}