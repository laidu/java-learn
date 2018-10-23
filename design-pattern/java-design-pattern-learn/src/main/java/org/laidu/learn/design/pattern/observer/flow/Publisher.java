package org.laidu.learn.design.pattern.observer.flow;

/**
 * 发布者接口
 * <p>
 * Created by laidu
 * on 2018-10-23 18:53.
 *
 * @author laidu
 */
public interface Publisher<T> {

    T next();

    boolean isComplete();

    /**
     * 开始发布数据
     */
    default void start(){

        while (!this.isComplete()){

            this.next();
        }

    }
}
