package org.laidu.learn.framework.common.rxjava.hello;

import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;


/**
 * demo
 * <p>
 * Created by laidu
 * on 2018-08-01 11:56.
 *
 * @author laidu
 */
@Slf4j
public class Demo {


    public static void main(String[] args) {

        Flowable.just("Hello world").
                subscribe(System.out::println)
                .dispose();

    }
}