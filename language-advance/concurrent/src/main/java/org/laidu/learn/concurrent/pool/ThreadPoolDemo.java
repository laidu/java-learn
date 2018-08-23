package org.laidu.learn.concurrent.pool;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * 线程池
 * <p>
 * Created by laidu
 * on 2018-08-03 16:15.
 *
 * @author laidu
 */
// TODO: 2018-08-03 16:15  线程池
public class ThreadPoolDemo {


    public static class Task implements Callable<JSONObject>{

        @Override
        public JSONObject call() throws Exception {
            Thread.sleep(RandomUtils.nextInt(1,10)*100);

            JSONObject result = new JSONObject();

            result.put("123",UUID.randomUUID().toString());
            result.put("12",UUID.randomUUID().toString());
            result.put("1",UUID.randomUUID().toString());
            result.put("133",UUID.randomUUID().toString());
            result.put("143",UUID.randomUUID().toString());
            result.put("153",UUID.randomUUID().toString());

            return result;
        }
    }

    public static void call(List<Task> tasks) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<JSONObject>> futures = executorService.invokeAll(tasks);

        futures.stream().forEach(result -> {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            }
        });

//        executorService.shutdown();

    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 100; i++) {

            call(Arrays.asList(new Task(),
                    new Task(),
                    new Task(),
                    new Task(),
                    new Task(),
                    new Task(),
                    new Task(),
                    new Task(),
                    new Task(),
                    new Task()
            ));
        }
    }

}