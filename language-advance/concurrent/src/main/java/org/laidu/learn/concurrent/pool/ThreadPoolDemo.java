package org.laidu.learn.concurrent.pool;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;

import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 线程池
 * <p>
 * Created by laidu
 * on 2018-08-03 16:15.
 *
 * @author laidu
 */
@Slf4j
public class ThreadPoolDemo {


    public static ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(4), Thread::new, new ThreadPoolExecutor.CallerRunsPolicy());

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Thread::new,
                new ThreadPoolExecutor.AbortPolicy());
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            log.info("poolSize: {}, queue: {}", executorService.getPoolSize(), executorService.getQueue().size());
        }, 0,1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 30; i++) {
            ThreadUtil.sleep(1000);
            log.info("add task");
            executorService.submit(new Task());
        }
    }

    public static class Task implements Callable<JSONObject>{

        @Override
        public JSONObject call() throws Exception {

            JSONObject result = new JSONObject();

            result.put("123",UUID.randomUUID().toString());
            result.put("12",UUID.randomUUID().toString());
            result.put("1",UUID.randomUUID().toString());
            result.put("133",UUID.randomUUID().toString());
            result.put("143",UUID.randomUUID().toString());
            result.put("153",UUID.randomUUID().toString());
            ThreadUtil.sleep(10000);
            return result;
        }
    }


}