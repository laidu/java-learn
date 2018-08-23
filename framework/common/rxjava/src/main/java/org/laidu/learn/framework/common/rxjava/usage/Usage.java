package org.laidu.learn.framework.common.rxjava.usage;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * usage
 * <p>
 * Created by laidu
 * on 2018-08-06 14:52.
 *
 * @author laidu
 */
@Slf4j
public class Usage {


    public static void main(String[] args) throws InterruptedException {
//

        Disposable subscribe = Observable.interval(1, TimeUnit.MICROSECONDS)
                .subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.computation())
                .doOnNext(System.out::println)
                .publish()
                .subscribe(s -> {
                    System.out.println( Thread.activeCount()+" " + s.longValue());
                    Thread.sleep(1000);
                },s->{
                    System.out.println("completed");
                });


        while (!subscribe.isDisposed()){
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}