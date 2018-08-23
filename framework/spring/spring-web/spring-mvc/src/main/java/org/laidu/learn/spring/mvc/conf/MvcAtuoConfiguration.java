package org.laidu.learn.spring.mvc.conf;

import org.laidu.learn.spring.mvc.filter.CommonFilter;
import org.laidu.learn.spring.mvc.properties.MvcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by tiancai.zang
 * on 2018-05-31 10:23.
 *
 * @author tiancai.zang
 */
@Configuration
@ConditionalOnClass(CommonFilter.class)
@EnableConfigurationProperties(MvcProperties.class)
public class MvcAtuoConfiguration implements WebMvcConfigurer {

    private final MvcProperties properties;


    @Autowired
    public MvcAtuoConfiguration(MvcProperties properties) {
        this.properties = properties;
    }


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(MvcProperties.class)
    public CommonFilter commonFilter(){
        return new CommonFilter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonFilter());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new UniversalEnumConverterFactory());
    }

}