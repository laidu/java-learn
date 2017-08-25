package org.laidu.learn.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉模式-非线程安全
 * User: zangtiancai
 * Date: 2017/8/24
 * Time: 下午6:01
 */
@Slf4j
public class ThreadUnSafeLazyLoadSingleton {

    private static volatile ThreadUnSafeLazyLoadSingleton ourInstance;

    private static AtomicInteger initCount = new AtomicInteger(0);

    public static ThreadUnSafeLazyLoadSingleton getInstance() {

        if (ourInstance == null) {
            ourInstance = new ThreadUnSafeLazyLoadSingleton();
        }
        return ourInstance;
    }

    private ThreadUnSafeLazyLoadSingleton() {
        int count = initCount.incrementAndGet(); // initCount.incrementAndGet() ; System.out.println(initCount); 为两步操作
        log.info("-*--*--*--*- instance 初始化 第 {} 次-*--*--*--*--", count);
    }


    public static void main(String[] args) {

        for (int i=0; i<1000; i++){
            new Thread(ThreadUnSafeLazyLoadSingleton::getInstance).start();
        }

    }
}
