package org.laidu.learn.design.pattern.observer.flow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Integer 发布者
 *
 * @author tiancai.zang
 * on 2018-10-23 18:59.
 */
@Slf4j
@Data
public class IntegerPublisher implements Publisher<Integer> {

    private final AtomicInteger index;
    private int start = 0;
    private int end = 0;
    private Boolean complete = false;

    private ReentrantLock lock;

    private List<IntegerSubsriber> subsribers;


    public IntegerPublisher(int start, int end, List<IntegerSubsriber> subsribers) {

        this.start = start;
        this.end = end;
        this.index = new AtomicInteger(start);
        this.lock = new ReentrantLock();
        this.subsribers = subsribers;
    }

    @Override
    public Integer next() {

        try {

            this.lock.tryLock(5, TimeUnit.SECONDS);

            if (index.intValue() <= end) {

                Integer result = index.getAndIncrement();

                subsribers.parallelStream().forEach(var -> var.onNext(result));

                return result;
            } else {
                this.complete = true;
                subsribers.parallelStream().forEach(IntegerSubsriber::onComplete);
            }

        } catch (InterruptedException e) {

            subsribers.parallelStream().forEach(var -> var.onError(e));

        } finally {
            if (this.lock.isHeldByCurrentThread()) {
                this.lock.unlock();
            }
        }

        return null;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }
}