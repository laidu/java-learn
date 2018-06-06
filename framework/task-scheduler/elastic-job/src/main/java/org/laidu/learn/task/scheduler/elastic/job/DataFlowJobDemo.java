package org.laidu.learn.task.scheduler.elastic.job;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.task.scheduler.elastic.mapper.UserMapper;
import org.laidu.learn.task.scheduler.elastic.model.User;
import org.laidu.learn.task.scheduler.elastic.worker.Worker;
import org.laidu.learn.task.scheduler.elastic.worker.impl.HelloWorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * say hello
 * <p>
 * Created by tiancai.zang
 * on 2018-05-18 11:33.
 */
@Slf4j
@Component
public class DataFlowJobDemo implements DataflowJob {

    @Autowired
    private UserMapper userMapper;

    /**
     * 多进程 需要 分布式锁（redission）
     */
    private static final AtomicInteger INDEX = new AtomicInteger(0);

    private static final int PAGE_SIZE = 500;

    private Worker worker = new HelloWorder();

    @Override
    public List fetchData(ShardingContext shardingContext) {

        List<User> users = userMapper.selectUserList(new Pagination(INDEX.getAndIncrement(), PAGE_SIZE));

        if (users == null || users.isEmpty()) {
            INDEX.set(0);
        }

        int total = shardingContext.getShardingTotalCount();
        int current = shardingContext.getShardingItem()-1;

        return users != null ? users.stream().filter(user -> user.getId() % total == current).collect(Collectors.toList()) : null;
    }

    @Override
    public void processData(ShardingContext shardingContext, List data) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data.parallelStream().forEach(System.out::println);
    }
}