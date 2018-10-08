package org.laidu.learn.language.feature.thread.local;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 线程A
 * <p>
 * Created by 臧天才 on 2017-09-01 14:11.
 */
// : 2017-09-01 14:11  线程A

@Slf4j
public class ThreadA implements Runnable {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    public static int get() {
        return threadId.get();
    }

    @Override
    public void run() {
        log.info("-*--*--*--*- threadId : {}-*--*--*--*--",get());
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        IntStream.range(0,100)
                .boxed()
                .forEach(i -> executorService.submit(new ThreadA()));

        executorService.shutdown();
    }
}