package org.laidu.learn.design.pattern.observer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 具体的被观察者
 *
 * @author tiancai.zang
 * on 2018-10-23 17:22.
 */
@Slf4j
@Data
public class Worker implements Observable{

    private final List<Observer<Worker>> observers;

    private String name;

    private WorkerState state = WorkerState.WORK;

    public Worker( String name,List<Observer<Worker>> observers) {
        this.observers = observers;
        this.name = name;
    }

    @Override
    public void doWork() {
       change(WorkerState.WORK);
    }

    @Override
    public void fun() {
        change(WorkerState.FUN);
    }

    @Override
    public void sleep() {
        change(WorkerState.SLEEP);
    }

    /**
     * 状态切换
     * @param state
     */
    public void change(WorkerState state){
        this.state = state;
        this.noticeAll();
        System.out.println(this.state);
    }

    @Override
    public void noticeAll() {
        observers.forEach(var -> var.doSomething(this));
    }
}