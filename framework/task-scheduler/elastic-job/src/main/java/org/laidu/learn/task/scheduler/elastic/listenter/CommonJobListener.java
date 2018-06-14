
package org.laidu.learn.task.scheduler.elastic.listenter;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 通用 job 监听器
 * <p>
 * Created by tiancai.zang
 * on 2018-05-18 14:26.
 */
@Slf4j
@Component
public class CommonJobListener implements ElasticJobListener {


    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        log.info("准备执行task: {}", shardingContexts.getJobName());
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        log.info("task 执行完成: {}", shardingContexts.getJobName());
    }
}