package org.laidu.learn.spring.stopwatch;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * 方法耗时统计
 *
 * 工具类使用：
 * 1、使用带参构造器创建 StopWatch 实例，参数为 stopwatch id
 * 2、在需要统计的方法调用前，调用 stopWatch.start() 方法，开始计时
 * 3、在方法调用结束后使用 stopWatch.stop() 方法，结束计时
 * 4、使用 springWatch.prettyPrint() 打印统计报表
 *
 * 其中需要注意的问题：
 *
 * 1、 start() -- stop() 必须对应
 * <p>
 * Created by 臧天才 on 2017-08-17 20:23.
 */
@Slf4j
public class TimeConsumingStatistics {

    public static void main(String[] args) {

        // todo 实现自定义注解 统计方法调用计时 --- 多线程的情况？
        StopWatch stopWacth = new StopWatch("MockServiceClient");

        MockServiceClient client = new MockServiceClient();

        stopWacth.start("open");
        client.open();
        stopWacth.stop();

        stopWacth.start("call");
        client.call();
        stopWacth.stop();

        log.info("-*--*--*--*--*--*--*--*--*--  --*--*--*--*--*--*--*--*--*-: \n{}",stopWacth.prettyPrint());

    }
}
