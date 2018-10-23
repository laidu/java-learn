package org.laidu.learn.design.pattern.observer.flow;

/**
 * 订阅者接口
 *
 * @author tiancai.zang
 * on 2018-10-23 18:56.
 */
public interface Subscriber<T> {

    void onNext(T t);

    void onComplete();

    void onError(Throwable e);
}