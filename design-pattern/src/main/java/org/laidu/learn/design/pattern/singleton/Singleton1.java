package org.laidu.learn.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 *
 * User: zangtiancai
 * Date: 2017/8/24
 * Time: 下午4:26
 */
@Slf4j
public class Singleton1 {

    private static Singleton1 ourInstance;

    public static Singleton1 getInstance() {

        if (ourInstance == null){
            synchronized (Singleton1.class){
                ourInstance = new Singleton1();
            }
        }
        return ourInstance;
    }

    public Singleton1() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork(){
        IntStream.range(0,100)
//                .parallel()
                .boxed()
                .peek(integer -> log.info("-*--*--*--*- doWork : {}-*--*--*--*--",integer))
                .count();
    }


    public static void main(String[] args) {

        for (int i=0; i<10000; i++){
            new Thread(() ->  Singleton1.getInstance().doWork()).start();
        }

    }
}
