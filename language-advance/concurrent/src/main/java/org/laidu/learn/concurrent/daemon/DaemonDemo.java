package org.laidu.learn.concurrent.daemon;

import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

        int coreSize = 5;
        int maxSize = 10;

        ExecutorService daemonService = new ThreadPoolExecutor(coreSize,maxSize,0L, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<>(1)
                ,r -> {
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

//        List<Future<String>> futures = daemonService.invokeAll(tasks);
//
//        futures.forEach( future -> {
//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });

//        ThreadUtil.sleep(2500);
//        daemonService.invokeAll(tasks);
//
//        ThreadUtil.sleep(2500);
//        daemonService.invokeAll(tasks);

    }
}