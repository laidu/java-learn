package org.laidu.commom.util.annotation;

/**
 * open singleton mode
 * <p>
 * Created by tiancai.zang on 2017-12-01 17-42.
 */
public @interface Singleton {
    /**
     * singleton implement style
     * @return
     */
    String style() default "";
}