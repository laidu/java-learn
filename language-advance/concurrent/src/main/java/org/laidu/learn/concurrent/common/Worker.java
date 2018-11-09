package org.laidu.learn.concurrent.common;

import jodd.util.ThreadUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.UUID;

/**
 * demo 线程
 *
 * @author tiancai.zang
 * on 2018-10-19 17:25.
 */
@Slf4j
@AllArgsConstructor
@Data
public class Worker implements Runnable{

    private String name;

    @Override
    public void run() {
        doWork();
    }

    protected String doWork() {

        int sleep = RandomUtils.nextInt(500, 1000);
        ThreadUtil.sleep(sleep);
        log.info("sleep time: {}", sleep);

        return UUID.randomUUID().toString();
    }
}