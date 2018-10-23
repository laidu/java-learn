package org.laidu.learn.design.pattern.observer;

/**
 * 被观察者接口
 *
 * @see java.util.Observable
 * @author tiancai.zang
 * on 2018-10-23 16:05.
 */
public interface Observable {

    void doWork();

    void fun();

    void sleep();


    void noticeAll();
}