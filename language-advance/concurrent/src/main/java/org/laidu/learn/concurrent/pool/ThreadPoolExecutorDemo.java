package org.laidu.learn.concurrent.pool;

import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutorDemo
 * <p>
 * Created by tiancai.zang
 * on 2018-11-25 10:44.
 */
@Slf4j
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
                5,
                500L, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(2),
                Thread::new,
                new ThreadPoolExecutor.AbortPolicy());

        executor.submit(()->{

            while (true){
                ThreadUtil.sleep(500);
                System.out.println(String.format("当前线程池大小：%d, 当前work queue大小: %d",executor.getPoolSize(), executor.getQueue().size()));
            }

        });

        while (true){
            ThreadUtil.sleep(600);
            executor.submit(()->{
                ThreadUtil.sleep(RandomUtils.nextInt(8000,10000));
//                System.out.println("执行新任务: "+Thread.currentThread().getName());
            });
        }

//        executor.shutdown();
    }
}