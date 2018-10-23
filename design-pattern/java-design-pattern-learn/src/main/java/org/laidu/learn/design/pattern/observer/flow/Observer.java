package org.laidu.learn.design.pattern.observer.flow;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 观察者客户端
 *
 * @author tiancai.zang
 * on 2018-10-23 19:27.
 */
@Slf4j
public class Observer {

    public static void main(String[] args) {


        List<IntegerSubsriber> subsribers = Arrays.asList(
                new IntegerSubsriber("subsriber 1"),
                new IntegerSubsriber("subsriber 2"),
                new IntegerSubsriber("subsriber 3"),
                new IntegerSubsriber("subsriber 4")
                );


        new IntegerPublisher(0, 100, subsribers)
                .start();


    }
}