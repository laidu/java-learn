package org.laidu.learn.concurrent.cyclic.barrier;


import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * cyclicBarrier worker
 * <p>
 * Created by 臧天才 on 2017-09-21 18:16.
 */
//  : 2017-09-21 18:16  cyclicBarrier worker
public class CyclicBarrierWorker implements Runnable {

    private String id;

    private CyclicBarrier cyclicBarrier;

    private CountDownLatch startDownlatch;

    public CyclicBarrierWorker(String id, CyclicBarrier cyclicBarrier, CountDownLatch startDownlatch) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.startDownlatch = startDownlatch;
    }

    @Override
    public void run() {

        try {
            startDownlatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        arrive();

        try {
            gather();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        work();
    }

    private void arrive() {
        System.out.println(String.format("======== %s : arrived =========", id));
    }

    private void gather() throws BrokenBarrierException, InterruptedException {
        cyclicBarrier.await();
        System.out.println(String.format("======== %s : wait for gather =========", id));
    }

    private void work() {
        System.out.println(String.format("======== %s : work =========", id));
    }


    public static void main(String[] args) {

        int workerCount = 10;

        CountDownLatch startDownLatch = new CountDownLatch(1);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(workerCount);

        ExecutorService executorService = Executors.newFixedThreadPool(workerCount);

        IntStream.range(0, 10).boxed()
                .peek(a -> executorService.submit(new CyclicBarrierWorker("worker_" + a, cyclicBarrier, startDownLatch)))
                .count();

        System.out.println("============start all work============");

        startDownLatch.countDown();

        executorService.shutdown();

        System.out.println("=============all work stopped==============");
    }
}
