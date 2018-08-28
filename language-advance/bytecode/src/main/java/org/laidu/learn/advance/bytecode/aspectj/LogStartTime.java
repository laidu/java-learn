package org.laidu.learn.advance.bytecode.aspectj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LogStartTime
 *
 * @author tiancai.zang
 * on 2018-08-28 19:04.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogStartTime {
    String value() default "";
}