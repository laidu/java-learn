package org.laidu.learn.spring.boot.app.service.impl;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import org.laidu.learn.spring.boot.app.config.ThreadPoolConfig;
import org.laidu.learn.spring.boot.app.service.LongTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zangtiancai.
 * @date 2019/12/11 下午3:02.
 */
@Slf4j
@Service
public class LongTaskServiceImpl implements LongTaskService {

    private static Random random = new Random();

    @Autowired
    private Executor commonFixPool;

    @Override
    public String doTask(Long sleepTime) {
        log.info("开始做任务");
        long start = System.currentTimeMillis();
        long ms = sleepTime != null ? sleepTime : random.nextInt(10000);
        ThreadUtil.sleep(ms);
        long end = System.currentTimeMillis();
        log.info("完成任务，耗时：" + (end - start) + "毫秒");
        return "task";
    }

    @Override
    @Async(ThreadPoolConfig.COMMON_FIX_POOL)
    public Future<String> doTaskOneAsync() {

        log.info("开始做任务1");
        long start = System.currentTimeMillis();
        ThreadUtil.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务1，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("task1");
    }

    @Override
    @Async(ThreadPoolConfig.COMMON_FIX_POOL)
    public Future<String> doTaskTwoAsync() {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        ThreadUtil.sleep(3000);
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("task2");
    }

    @Override
    @Async(ThreadPoolConfig.COMMON_FIX_POOL)
    public Future<String> doTaskThreeAsync() {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        ThreadUtil.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("task3");
    }

    @Override
    public CompletableFuture<String> doTaskCpl() {
        return CompletableFuture.supplyAsync(() -> this.doTask(null));
    }


    @Override
    public <T> CompletableFuture<T> doTaskAsyncCpl(Supplier<T> supplier) {
        log.info("异步任务开始 in caller ");
        CompletableFuture<T> supplyAsync =
                CompletableFuture.supplyAsync(supplier, commonFixPool);
        log.info("异步任务开始 in caller");
        return supplyAsync;
    }


    @Override
    @Async(ThreadPoolConfig.COMMON_FIX_POOL)
    public <T> CompletableFuture<T> doTaskAsyncPoolCpl(Supplier<T> supplier) {
        log.info("异步任务开始 in commonFixPool ");
        CompletableFuture<T> supplyAsync = CompletableFuture.completedFuture(supplier.get());
        log.info("异步任务开始 in commonFixPool");
        return supplyAsync;
    }
}
