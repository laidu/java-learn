package org.laidu.learn.spring.stopwatch;


import lombok.extern.slf4j.Slf4j;

/**
 * 模拟耗时服务调用
 * <p>
 * Created by 臧天才 on 2017-08-17 20:15.
 */
@Slf4j
public class MockServiceClient {

    public void open(){

        log.debug("-*--*--*--*--*--*--*--*--*-- 打开 --*--*--*--*--*--*--*--*--*-");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void call(){
        log.debug("-*--*--*--*--*--*--*--*--*-- 方法调用 --*--*--*--*--*--*--*--*--*-");
    }
}
