package org.laidu.learn.concurrent.latch;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * runner
 * <p>
 *
 * @author 臧天才
 * @date 2017-09-21 17:33
 */
public class LatchWorker implements Runnable {

    private String id;

    private CountDownLatch startDownLatch;

    private CountDownLatch stopDownLatch;

    public LatchWorker(String id, CountDownLatch startDownLatch, CountDownLatch stopDownLatch) {
        this.id = id;
        this.startDownLatch = startDownLatch;
        this.stopDownLatch = stopDownLatch;
    }

    @Override
    public void run() {

        try {

            preWork();

            startDownLatch.await();

            start();

            work();
            Thread.sleep(1000);

            stop();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void preWork() {

        System.out.println(String.format("======== %s : preWork=========",id));
    }

    private void start(){

        System.out.println(String.format("======== %s : start=========",id));
    }

    private void work(){
        System.out.println(String.format("======== %s : working=========",id));
        stopDownLatch.countDown();
    }

    private void stop(){

        System.out.println(String.format("======== %s : stop=========",id));
    }

    public static void main(String[] args) throws InterruptedException {

        int workerCount = 10;

        CountDownLatch startCountLatch = new CountDownLatch(1);
        CountDownLatch stopCountLatch = new CountDownLatch(workerCount);

        List<LatchWorker> latchWorkerList = new ArrayList<>(workerCount);

        ExecutorService executorService = Executors.newFixedThreadPool(workerCount);

        IntStream.range(0,10).boxed()
                .peek(a -> executorService.submit(new LatchWorker("worker_"+a,startCountLatch,stopCountLatch)))
                .count();
        System.out.println("============start all work============");

        startCountLatch.countDown();

        stopCountLatch.await();

        executorService.shutdown();

        System.out.println("=============all work stopped==============");

    }

}
