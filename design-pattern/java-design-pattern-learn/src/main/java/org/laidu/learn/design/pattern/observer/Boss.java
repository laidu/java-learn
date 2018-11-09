package org.laidu.learn.design.pattern.observer;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 具体的观察者
 *
 * @author tiancai.zang
 * on 2018-10-23 17:22.
 */
@Slf4j
@Data
@RequiredArgsConstructor
public class Boss implements Observer<Worker> {

    private String name;

    private int work = 0;
    private int fun = 0;
    private int sleep = 0;

    public Boss(String name) {
        this.name = name;
    }

    @Override
    public void doSomething(Worker worker) {

        WorkerState state = worker.getState();
        switch (state) {

            case WORK:
                work++;
                break;
            case FUN:
                fun++;
                break;
            case SLEEP:
                sleep++;
                break;

            default:
                break;
        }

        System.out.println(String.format("report to boos %s ->  work num is %d , fun num is %d , sleep num is %d", name, work, fun, sleep));

    }
}