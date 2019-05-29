package org.laidu.learn.spring.core;

import org.laidu.learn.spring.core.bean.Father;
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

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.setBeanNameGenerator((definition, registry) -> "hehe_"+definition.getBeanClassName());

        ctx.scan("org.laidu.learn.spring.core.bean");
        ctx.refresh();

        Father father = ctx.getBean(Father.class);

        System.out.println(father.getChild().getName());
    }
}
