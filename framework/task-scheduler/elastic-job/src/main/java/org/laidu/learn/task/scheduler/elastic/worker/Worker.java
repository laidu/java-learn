package org.laidu.learn.task.scheduler.elastic.worker;

import com.dangdang.ddframe.job.api.ShardingContext;

/**
 * work interface
 * <p>
 * Created by tiancai.zang
 * on 2018-05-18 11:31.
 */
public interface Worker  {

    void doWork(ShardingContext shardingContext);
}
