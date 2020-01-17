package org.laidu.learn.spring.boot.app.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * 模拟耗时任务
 *
 * @author zangtiancai.
 * @date 2019/12/11 下午3:02.
 */
public interface LongTaskService {

    String doTask(Long sleepTime);

    Future<String> doTaskOneAsync();

    Future<String> doTaskTwoAsync();

    Future<String> doTaskThreeAsync();

    CompletableFuture<String> doTaskCpl();

    <T> CompletableFuture<T> doTaskAsyncCpl(Supplier<T> supplier);

    <T> CompletableFuture<T> doTaskAsyncPoolCpl(Supplier<T> supplier);

}
