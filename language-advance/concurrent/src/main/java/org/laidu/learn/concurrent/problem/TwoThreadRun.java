package org.laidu.learn.concurrent.problem;

import jodd.util.ThreadUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * 创建两个线程ThreadA ThreadB,使其循环依次打印 ABABAB...
 *
 * @author tiancai.zang
 * on 2018-10-16 14:14.
 */
@Slf4j
public class TwoThreadRun {

    public static void main(String[] args) throws InterruptedException {

        int threadSize = 3;

        CyclicBarrier barrier = new CyclicBarrier(threadSize, () -> System.out.println(""));

        AtomicInteger atomicInteger = new AtomicInteger(0);

//        Printer printerA = new Printer("A", atomicInteger, integer -> integer % threadSize == 0);
//        Printer printerB = new Printer("B", atomicInteger, integer -> integer % threadSize == 1);
//        Printer printerC = new Printer("C", atomicInteger, integer -> integer % threadSize == 2);


        Semaphore semA = new Semaphore(1);
        Semaphore semB = new Semaphore(1);
        Semaphore semC = new Semaphore(1);

//        semA.acquire();  //从 A 开始输出
        semB.acquire();
        semC.acquire();

        Printer1 printerA = new Printer1("A", semA, semB,barrier);
        Printer1 printerB = new Printer1("B", semB, semC,barrier);
        Printer1 printerC = new Printer1("C", semC, semA,barrier);

        Thread threadA = new Thread(printerA);
        Thread threadB = new Thread(printerB);
        Thread threadC = new Thread(printerC);

        ExecutorService executorService = new ThreadPoolExecutor(threadSize, threadSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), (ThreadFactory) Thread::new);

        executorService.submit(threadA);
        executorService.submit(threadB);
        executorService.submit(threadC);


    }

    /**
     * 使用 AtomicInteger 或者 ReentrantLock+Integer
     */
    @AllArgsConstructor
    public static class Printer implements Runnable {

        private final String note;

        private final AtomicInteger atomicInteger;

        private Predicate<Integer> predicate;

        @Override
        public void run() {

            while (true) {

                if (predicate.test(atomicInteger.get())) {
                    System.out.print(note + "\t");
                    atomicInteger.getAndIncrement();
                    ThreadUtil.sleep(500);
                } else {
                    atomicInteger.set(atomicInteger.intValue() % 3);
                }
            }
        }
    }

    /**
     * 使用 Semaphore
     */
    @AllArgsConstructor
    public static class Printer1 implements Runnable {

        private final String note;

        private final Semaphore self;

        private final Semaphore next;

        private CyclicBarrier barrier;

        @Override
        public void run() {

            while (true) {

                try {

                    barrier.await();

                    ThreadUtil.sleep(500);
                    self.acquire();

                    System.out.print(note + "\t");

                    next.release();

                } catch (Exception e) {

                }
            }

        }
    }
}