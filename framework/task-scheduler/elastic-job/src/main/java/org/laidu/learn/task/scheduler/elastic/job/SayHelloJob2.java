package org.laidu.learn.task.scheduler.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.task.scheduler.elastic.worker.Worker;
import org.laidu.learn.task.scheduler.elastic.worker.impl.HelloWorder;

/**
 * say hello
 * <p>
 * Created by tiancai.zang
 * on 2018-05-18 11:33.
 */
@Slf4j
//@Component("sayHelloJob2")
public class SayHelloJob2 implements SimpleJob {

    private Worker worker = new HelloWorder();

    @Override
    public void execute(ShardingContext shardingContext) {
        worker.doWork(shardingContext);
    }
}