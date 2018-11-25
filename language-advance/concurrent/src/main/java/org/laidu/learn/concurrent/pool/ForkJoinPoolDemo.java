package org.laidu.learn.concurrent.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * FJPool 示例
 * 1+2+3+....+100 求和
 * <p>
 * Created by tiancai.zang
 * on 2018-11-25 10:45.
 */
@Slf4j
public class ForkJoinPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool fjPoll = new ForkJoinPool();

        Future<Integer> task = fjPoll.submit(new MyFjTask(1, 10000));

        Integer integer = task.get();
        System.out.println(integer);


    }

    public static class MyFjTask extends RecursiveTask<Integer> {

        private int begin;
        private int end;
        private final static int THRESHOLD = 2;

        public MyFjTask(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }


        @Override
        protected Integer compute() {

            int sum = 0;
            if (end - begin < THRESHOLD) {
                for(int i = begin; i <= end; i++) {
                    sum += i;
                }
            }else {

                int mid = (end+begin) >>> 1;

                MyFjTask leftTask = new MyFjTask(begin, mid);
                MyFjTask rightTask = new MyFjTask(mid+1, end);

                invokeAll(leftTask,rightTask);

                sum =  leftTask.join() + rightTask.join();
            }

            return sum;
        }
    }
}