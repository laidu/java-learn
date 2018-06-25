package org.laidu.learn.task.scheduler.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.task.scheduler.elastic.worker.Worker;
import org.laidu.learn.task.scheduler.elastic.worker.impl.HelloWorder;
import org.springframework.stereotype.Component;

/**
 * say hello
 * <p>
 * Created by tiancai.zang
 * on 2018-05-18 11:33.
 */
@Slf4j
@Component("sayHelloJob")
public class SayHelloJob implements SimpleJob {

    private Worker worker = new HelloWorder();

    @Override
    public void execute(ShardingContext shardingContext) {

        log.info("shardingContext: {}", shardingContext);

        log.info("job param : {}", shardingContext.getJobParameter());

        switch (shardingContext.getShardingItem()) {
            case 0:
                worker.doWork(shardingContext);
                break;
            case 1:
                log.info("do work {}", shardingContext.getShardingItem());
                break;
            case 2:
                log.info("do work {}", shardingContext.getShardingItem());
                break;
            default:
                log.info("分片溢出");

        }

    }
}