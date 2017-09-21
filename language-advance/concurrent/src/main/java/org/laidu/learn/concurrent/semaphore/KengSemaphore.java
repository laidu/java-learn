package org.laidu.learn.concurrent.semaphore;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * keng semaohore
 * <p>
 * Created by 臧天才 on 2017-09-21 18:43.
 */

// TODO : 2017-09-21 18:43  keng semaohore
public class KengSemaphore {

    public static void main(String[] args) {

        int threadNum = 10;
        Semaphore semaphore = new Semaphore(1);

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);

        IntStream.range(0, 10).boxed()
                .peek(a -> executorService.submit(() -> {
                    try {

                        System.out.println(String.format("=============thread id : %s waiting acquire ===============", Thread.currentThread().getId()));
                        semaphore.acquire();
                        System.out.println(String.format("=============thread id : %s got acquire ===============", Thread.currentThread().getId()));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
//                        semaphore.release();
                        System.out.println(String.format("=============thread id : %s released acquire ===============", Thread.currentThread().getId()));
                    }
                }))
                .count();

        executorService.shutdown();
    }
}
