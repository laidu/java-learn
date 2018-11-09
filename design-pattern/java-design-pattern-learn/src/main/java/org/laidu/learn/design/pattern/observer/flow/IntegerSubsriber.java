package org.laidu.learn.design.pattern.observer.flow;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Integer 订阅
 *
 * @author tiancai.zang
 * on 2018-10-23 19:16.
 */
@Slf4j
@AllArgsConstructor
public class IntegerSubsriber implements Subscriber<Integer> {

    private String name;

    @Override
    public void onNext(Integer next) {
        System.out.println(next);
    }

    @Override
    public void onComplete() {
        System.out.println("completed");
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("数据异常");
    }

}