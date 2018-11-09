package org.laidu.learn.concurrent.problem;

import jodd.util.ThreadUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 并发返回最快结果
 *
 * @author tiancai.zang
 * on 2018-10-17 18:37.
 */
@Slf4j
public class ObtainFastRes {


    /**
     * 模拟网络延迟
     *
     * @param workerName
     * @return
     */
    public static String doWork(String workerName) {

        int sleep = RandomUtils.nextInt(1500, 2000);

        log.info("workname {}, sleep: {}", workerName,sleep);
        ThreadUtil.sleep(sleep);

        return workerName + "_" + sleep;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Work a = new Work("a");
        Work b = new Work("b");
        Work c = new Work("c");

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

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(tasks.size(), tasks.size(),
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), Thread::new, new ThreadPoolExecutor.AbortPolicy());

        // 执行顺序 1>3>2
        try {
            /*
              step 1 : 
             */
            String resultFast = poolExecutor.invokeAny(tasks);
            
            /*
              step 2 : 
             */
            return resultFast;
        }finally {

            /*
              step 3 :
             */
            poolExecutor.shutdown();
        }

    }

    @Data
    @AllArgsConstructor
    static class Work implements Callable<String> {

        private final String name;

        @Override
        public String call() throws Exception {
            return doWork(this.name);
        }
    }

}