package org.laidu.learn.concurrent.problem;

import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * java 创建线程的方式
 *
 *
 * @author tiancai.zang
 * on 2018-10-19 15:05.
 */
@Slf4j
public class CreateThread {


    /**
     * 通过 继承 Thread 实现
     */
    static class WorkerByExtend extends Thread{
        @Override
        public void run() {
            doWork();
        }
    }

    /**
     * 通过 实现 Runnable  接口实现 无返回值
     */
    static class WorkerByImpl implements Runnable{

        @Override
        public void run() {
            doWork();
        }
    }

    /**
     * 通过 实现 Callable 接口实现有返回值
     */
    static class WorkerByReturn implements Callable<String> {

        @Override
        public String call() throws Exception {
            return doWork();
        }
    }

    static String doWork(){


        log.info("current active thread count is : {}", Thread.activeCount());
        int sleep = RandomUtils.nextInt(1500, 3000);

        ThreadUtil.sleep(sleep);

        log.info("sleep time: {}", sleep);

        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) throws Exception {

        log.info("start");

//        new WorkerByExtend().start();
//
//        new Thread(new WorkerByImpl()).start();

        FutureTask<String> futureTask = new FutureTask<>(new WorkerByReturn());

        new Thread(futureTask).start();

        log.info("future task result: {}", futureTask.get());

    }

}