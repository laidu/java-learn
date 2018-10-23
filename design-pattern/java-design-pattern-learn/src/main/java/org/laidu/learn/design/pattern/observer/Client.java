package org.laidu.learn.design.pattern.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 客户端代码
 *
 * @author tiancai.zang
 * on 2018-10-23 17:46.
 */
@Slf4j
public class Client {

    public static void main(String[] args) {

        // 创建 观察者
        List<Observer<Worker>> bosses = Arrays.asList(new Boss("wang"),
                new Boss("li")
        );


        // 创建
        Worker xiaoming = new Worker( "xiaoming",bosses);
        Worker xiaoli = new Worker( "xiaoli",bosses);

        xiaoming.fun();

        xiaoli.fun();

        xiaoming.doWork();

        xiaoli.doWork();

        xiaoli.sleep();

    }
}