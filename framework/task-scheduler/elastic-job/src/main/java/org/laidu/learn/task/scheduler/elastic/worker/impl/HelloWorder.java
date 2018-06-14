package org.laidu.learn.task.scheduler.elastic.worker.impl;

import com.dangdang.ddframe.job.api.ShardingContext;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.task.scheduler.elastic.worker.Worker;
import org.springframework.stereotype.Service;

/**
 * hello
 * <p>
 * Created by tiancai.zang
 * on 2018-05-18 11:36.
 */
@Slf4j
@Service
public class HelloWorder implements Worker {


    @Override
    public void doWork(ShardingContext shardingContext) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("hello : {}", shardingContext.getJobName());
    }
}