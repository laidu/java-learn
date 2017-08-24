package org.laidu.learn.design.pattern.singleton;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 单例模式 -- 使用 静态变量实现
 * User: zangtiancai
 * Date: 2017/8/24
 * Time: 下午3:58
 */
@Slf4j
public class Singleton {

    private static Singleton ourInstance = new Singleton();

    private Class_A class_a;

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        log.info("-*--*--*--*- Singleton init start -*--*--*--*--");
        this.class_a = new Class_A("class_a");
        log.info("-*--*--*--*- Singleton init  completed-*--*--*--*--");
    }

    public void doWork(){
        log.info("-*--*--*--*- doWork : {}-*--*--*--*--");
//        IntStream.range(0,100)
////                .parallel()
//                .boxed()
//                .peek(integer -> log.info("-*--*--*--*- doWork : {}-*--*--*--*--",integer))
//                .count();
    }

    private class Class_A {
        @Getter@Setter
        private String value;

        public Class_A(String value) {

//            log.info("-*--*--*--*- Class_A init start -*--*--*--*--");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            this.value = value;
//
//            log.info("-*--*--*--*- Class_A init  completed-*--*--*--*--");

        }
    }

    public static void main(String[] args) {

        for (int i=0; i<1000; i++){
            new Thread(() ->  Singleton.getInstance().doWork()).start();
        }
    }
}
