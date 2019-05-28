package org.laidu.learn.spring.core;

import org.laidu.learn.spring.core.bean.Father;
import org.laidu.learn.spring.core.config.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * spring
 *
 * @author zangtiancai.
 * @date 2019-05-27 20:01.
 */
@Slf4j
public class SpringApp {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        Father father = ctx.getBean(Father.class);

        System.out.println(father.getChild().getName());
    }
}
