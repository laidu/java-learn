package org.laidu.learn.concurrent.problem;

import jodd.util.ThreadUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * 并发返回最快结果
 *
 * @author tiancai.zang
 * on 2018-10-17 18:37.
 */
@Slf4j
public class ObtainFastRes {


    /**
     * 模拟网络相应
     *
     * @param workerName
     * @return
     */
    public static String doWork(String workerName) {

        int sleep = RandomUtils.nextInt(500, 1000);

        log.info("workname {}, sleep: {}", workerName,sleep);
        ThreadUtil.sleep(sleep);

        return workerName + "_" + sleep;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Worker a = new Worker("a");
        Worker b = new Worker("b");
        Worker c = new Worker("c");

        List<Callable<String>> tasks = Arrays.asList(a, b, c);

        String s = runAndReturnFast(tasks);

        System.out.println(s);

    }



    /**
     * jdk 线程 自带方法, 返回多个线程中最快的结果
     * @param tasks
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @NotNull
    public static String runAndReturnFast(List<Callable<String>> tasks) throws InterruptedException, ExecutionException {
        return Executors.newFixedThreadPool(3).invokeAny(tasks);
    }

    @AllArgsConstructor
    @Data
    static class Worker implements Callable<String> {

        private final String name;

        @Override
        public String call() throws Exception {
            return doWork(this.name);
        }
    }
}