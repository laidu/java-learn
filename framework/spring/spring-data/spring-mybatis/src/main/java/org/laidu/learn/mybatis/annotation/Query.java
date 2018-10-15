package org.laidu.learn.mybatis.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 查询sql
 * <p>
 * Created by laidu
 * on 2018-10-08 18:57.
 *
 * @author laidu
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {

    /**
     * @return 执行的sql语句
     */
    @AliasFor("value")
    String sql() default "";

    @AliasFor("sql")
    String value();

}
