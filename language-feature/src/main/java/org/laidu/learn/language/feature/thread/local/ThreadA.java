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

    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    @Override
    public void run() {
        log.info("-*--*--*--*- threadId : {}-*--*--*--*--",get());
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int ignored : IntStream.range(0,100).toArray()){
            executorService.submit(new ThreadA());
        }
    }
}