package org.laidu.learn.concurrent.semaphore;


import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * keng semaohore
 * <p>
 * Created by 臧天才 on 2017-09-21 18:43.
 */

public class KengSemaphore {

    public static void main(String[] args) {

        int threadNum = 10;
        Semaphore semaphore = new Semaphore(1);

        ExecutorService executorService = new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        IntStream.range(0, 10)
                .forEach(a -> executorService.submit(() -> {
                    try {

                        System.out.println(String.format("=============thread id : %s waiting acquire ===============", Thread.currentThread().getId()));
                        semaphore.acquire();
                        System.out.println(String.format("=============thread id : %s got acquire ===============", Thread.currentThread().getId()));
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                        System.out.println(String.format("=============thread id : %s released acquire ===============", Thread.currentThread().getId()));
                    }
                }));


//        executorService.shutdownNow();
    }
}
