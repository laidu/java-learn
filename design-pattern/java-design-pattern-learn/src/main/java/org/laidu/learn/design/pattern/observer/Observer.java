package org.laidu.learn.design.pattern.observer;

/**
 * 观察者接口
 *
 * @author tiancai.zang
 * on 2018-10-23 16:17.
 */
public interface Observer<T> {

    /**
     * work 方法
     * @return
     */
    void doSomething(T t);

}