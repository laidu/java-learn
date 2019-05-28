package org.laidu.learn.spring.core.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * java 配置
 *
 * @author zangtiancai.
 * @date 2019-05-28 21:13.
 */
@ComponentScan(basePackages = {
        "org.laidu.learn.spring.core.bean"
})
public class JavaConfig {

//    @Bean
//    public Father father(){
//        return new Father("father");
//    }
//
//    @Bean
//    public Child child(){
//        return new Child("child");
//    }
}
