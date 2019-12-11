package org.laidu.learn.spring.boot.app.controller;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.laidu.learn.spring.boot.app.service.LongTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 耗时api
 *
 * @author zangtiancai.
 * @date 2019/12/11 下午3:06.
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class LongTaskController {

    private final LongTaskService taskService;

    @Autowired
    public LongTaskController(LongTaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/doTask")
    public String doTask() {
        return taskService.doTask(null);
    }

    @GetMapping("/doTaskFur")
    public String doTaskFur() {

        long startTime = System.currentTimeMillis();
        long startTime0 = System.currentTimeMillis();

        log.info("开始执行任务1, pre expire: {}", System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        Future<String> result1 = taskService.doTaskOneAsync();
        log.info("开始执行任务2, pre expire: {}", System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        Future<String>  result2 = taskService.doTaskTwoAsync();
        log.info("开始执行任务3, pre expire: {}", System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        Future<String>  result3 = taskService.doTaskThreeAsync();

        // 等待线程结束

        String result = null;

        try {
            result = String.join(", ", Arrays.asList(
//                    result1.get(8, TimeUnit.SECONDS),
                    result2.get(4, TimeUnit.SECONDS),
                    result3.get(),
                    String.valueOf(System.currentTimeMillis() - startTime0)));
            log.info("任务执行完成, pre expire: {}", System.currentTimeMillis() - startTime0);
        } catch (Exception e) {
            log.error("获取");
        }

        return result;
    }

    @GetMapping("/doTaskAsyncCpl")
    public String doTaskAsyncCpl() {

        long startTime = System.currentTimeMillis();

        CompletableFuture<String> future = taskService.doTaskAsyncCpl(() -> {

            log.info("异步任务开始 in supplier ");
            ThreadUtil.sleep(3000L);
            log.info("异步任务完成 in supplier ");

            return "result";
        });

        CompletableFuture<String> future2 = taskService.doTaskAsyncCpl(() -> {

            log.info("异步任务2开始 in supplier ");
            ThreadUtil.sleep(4000L);
            log.info("异步任务2完成 in supplier ");

            return "result";
        });

        String result = null;

        // 等待线程结束
        try {

            future.thenCombine(future2, (var1, var2) -> {
                log.info("聚合结果");
                return var1 + var2;
            });

            result = String.join(", ", Arrays.asList(
                    future.get(),
                    String.valueOf(System.currentTimeMillis() - startTime)));
            log.info("任务执行完成, pre expire: {}", System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            log.error("获取");
        }

        return result;
    }

    @GetMapping("/doTaskAsyncPoolCpl")
    public String doTaskAsyncPoolCpl() {

        long startTime = System.currentTimeMillis();

        // 等待线程结束
        CompletableFuture<String> future = taskService.doTaskAsyncPoolCpl(() -> {

            log.info("异步任务开始 in supplier ");
            ThreadUtil.sleep(3000L);
            log.info("异步任务完成 in supplier ");

            return "result";
        });

        String result = null;

        try {
            result = String.join(", ", Arrays.asList(
                    future.get(),
                    String.valueOf(System.currentTimeMillis() - startTime)));
            log.info("任务执行完成, pre expire: {}", System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            log.error("获取");
        }

        return result;
    }

    @GetMapping("/doTaskCFur")
    public String doTaskCFur() {

        long startTime = System.currentTimeMillis();

        // 等待线程结束
        CompletableFuture<String> future
                = taskService.doTaskCpl();

        String result = null;

        try {
            result = String.join(", ", Arrays.asList(
                    future.get(),
                    String.valueOf(System.currentTimeMillis() - startTime)));
            log.info("任务执行完成, pre expire: {}", System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            log.error("获取");
        }

        return result;
    }
}
