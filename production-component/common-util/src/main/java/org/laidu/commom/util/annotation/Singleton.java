package org.laidu.commom.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * open singleton mode
 * <p>
 * Created by tiancai.zang on 2017-12-01 17-42.
 */

@Target(ElementType.TYPE)
@Documented
public @interface Singleton {
    /**
     * singleton implement style
     * @return
     */
    String style() default "";
}