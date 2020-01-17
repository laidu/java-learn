package org.laidu.learn.concurrent.daemon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomUtils;

import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 守护线程
 *
 * @author tiancai.zang
 * on 2018-10-26 15:52.
 */
@Slf4j
public class DaemonDemo {


    public static String doWork(){
        int random = RandomUtils.nextInt(1000, 2000);

        for (int i = 0; i < random; i++) {
            if (i % 500 == 0) {
                ThreadUtil.sleep(i);
                System.out.println(Thread.currentThread().getName());
            }
        }

        return Thread.currentThread().getId()+"";
    }

    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            log.info("main thread state : {}", main.getState());
        }
        log.info("main 线程结束");

    }

    private static void threadState() {
        log.info("创建线程t1");
        Thread t1 = new Thread(() -> {

            for (long i = 0; i < 300L; i++) {
            }

            ThreadUtil.sleep(1);
        }, "t1");

        new Thread(() -> {
            for (;t1.getState() != Thread.State.TERMINATED;) {
                log.info("t1 线程state: {}", t1.getState());
            }
            log.info("t1 线程state: {}", t1.getState());
        }, "t2").start();

        t1.setDaemon(true);
        t1.start();
    }

    private static void deamonPool() {
        int coreSize = 5;
        int maxSize = 10;

        ExecutorService daemonService = new ThreadPoolExecutor(coreSize, maxSize, 0L, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<>(1)
                , r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            System.out.println("创建新的线程 : "+ thread.getName());
            return thread;

        }, new ThreadPoolExecutor.AbortPolicy());


        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            tasks.add(DaemonDemo::doWork);
        }

        tasks.forEach(daemonService::submit);
    }
}