package org.laidu.learn.concurrent.synchronizer;


import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.concurrent.common.Worker;

import java.util.concurrent.*;

/**
 * cyclicBarrier worker
 * <p>
 *
 * @author 臧天才
 * @date 2017-09-21 18:16
 */
@Slf4j
public class CyclicBarrierDemo {


    /**
     * 通知 完成
     */
    static void completeNotify() {
        log.info("已完成所有任务");
    }

    public static void main(String[] args) throws InterruptedException {

        int workerCount = 10;


        CyclicBarrier cyclicBarrier = new CyclicBarrier(workerCount, CyclicBarrierDemo::completeNotify);

        ExecutorService executorService = new ThreadPoolExecutor(5, workerCount * 6,
                5L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(workerCount),
                r -> {

                    ThreadUtil.sleep(500);
                    log.info("为 {} 创建新的线程", r.hashCode());

                    return new Thread(r);
                });

        for (int i = 0; i < workerCount * 5; i++) {

            executorService.submit(new Worker("no." + i){

                @Override
                public void run() {
                    doWork();
                    try {

                        log.info("waiting count: {}", cyclicBarrier.getNumberWaiting());
                        cyclicBarrier.await(500,TimeUnit.MILLISECONDS);

                    }catch (BrokenBarrierException | TimeoutException e){
                        log.warn(" 超时 ");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        executorService.shutdown();

    }
}
