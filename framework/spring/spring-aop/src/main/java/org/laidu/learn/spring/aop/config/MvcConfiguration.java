package org.laidu.learn.spring.aop.config;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.aop.filter.RRFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc config
 * <p>
 * Created by tiancai.zang
 * on 2018-06-23 19:50.
 */
@Slf4j
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    private final RRFilter rrFilter;

    @Autowired
    public MvcConfiguration(RRFilter rrFilter) {
        this.rrFilter = rrFilter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rrFilter);
    }
}