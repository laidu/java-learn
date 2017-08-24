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
public class ThreadSafeLazyLoadSyncSingleton {

    private static ThreadSafeLazyLoadSyncSingleton ourInstance;

    public static synchronized ThreadSafeLazyLoadSyncSingleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new ThreadSafeLazyLoadSyncSingleton();
        }
        return ourInstance;
    }

    private ThreadSafeLazyLoadSyncSingleton() {
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
            new Thread(ThreadSafeLazyLoadSyncSingleton.getInstance()::doWork).start();
        }

    }
}
