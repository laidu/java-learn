package org.laidu.learn.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 懒汉模式-非线程安全
 * User: zangtiancai
 * Date: 2017/8/24
 * Time: 下午6:01
 * @author laidu
 */
@Slf4j
public class ThreadSafeLazyLoadSyncSingleton {

    private static volatile ThreadSafeLazyLoadSyncSingleton ourInstance;

    private static AtomicInteger initCount = new AtomicInteger(0);

    public static synchronized ThreadSafeLazyLoadSyncSingleton getInstance() {
        if (ourInstance == null) {
            // 非原子操作， 故需要volatile修饰
            ourInstance = new ThreadSafeLazyLoadSyncSingleton();
        }
        return ourInstance;
    }

    private ThreadSafeLazyLoadSyncSingleton() {
        int count = initCount.incrementAndGet();
        log.info("-*--*--*--*- instance 初始化 第 {} 次-*--*--*--*--", count);
    }

    public void doWork(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("-*--*--*--*- {} doWork -*--*--*--*--",Thread.currentThread().getId());
    }

    public static void main(String[] args) {

        for (int i=0; i<1000; i++){
            new Thread(ThreadSafeLazyLoadSyncSingleton::getInstance).start();
        }

    }
}
