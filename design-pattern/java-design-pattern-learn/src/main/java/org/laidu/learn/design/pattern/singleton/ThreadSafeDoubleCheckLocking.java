package org.laidu.learn.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用双重校验锁
 * User: zangtiancai
 * Date: 2017/8/25
 * Time: 上午10:15
 */
@Slf4j
public class ThreadSafeDoubleCheckLocking {

    private static volatile ThreadSafeDoubleCheckLocking ourInstance;

    private static AtomicInteger initCount = new AtomicInteger(0);

    public static ThreadSafeDoubleCheckLocking getInstance() {

        if (ourInstance == null){                       //  第一次 null值 校验
            synchronized (ThreadSafeDoubleCheckLocking.class){
                if (ourInstance == null) {              //  第二次 null值 校验
                    ourInstance = new ThreadSafeDoubleCheckLocking();
                }
            }
        }
        return ourInstance;
    }

    private ThreadSafeDoubleCheckLocking() {
        int count = initCount.incrementAndGet();
        log.info("-*--*--*--*- instance 初始化 第 {} 次-*--*--*--*--", count);
    }

    public static void main(String[] args) {

        for (int i=0; i<1000; i++){
            new Thread(ThreadSafeDoubleCheckLocking::getInstance).start();
        }

    }
}
