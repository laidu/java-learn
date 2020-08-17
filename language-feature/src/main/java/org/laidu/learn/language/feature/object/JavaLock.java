package org.laidu.learn.language.feature.object;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * java lock demo
 * <p>
 * Created by tiancai.zang
 * on 2020-08-17 22:50.
 */
@Slf4j
public class JavaLock {


    public static void main(String[] args) throws InterruptedException {


        JavaLock javaLock = new JavaLock();
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));

        executorService.submit(javaLock::work);


        executorService.submit(() -> {
            log.info("notifyAll");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("notifyAll");

            synchronized (javaLock) {
                javaLock.notifyAll();
            }
        });

        log.info("over");
        executorService.shutdown();

    }

    public synchronized void work() {

        log.info("start do work");
        try {
            // java 中只能通过sync实现monitor锁
            this.wait();
        } catch (InterruptedException e) {
            log.error("wait error");
        }

        log.info("end do work");

    }
}