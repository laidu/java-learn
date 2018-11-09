package org.laidu.learn.advance.bytecode.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancai.zang
 * on 2018-11-01 16:26.
 */
@Slf4j
public class ItWorker implements Worker {

    @Override
    public void doWork() {
        System.out.println("coding...");

        getName();

        getName1();
//        hello();
    }

    /**
     * cglib 通过 继承方式 实现动态代理 因此无法代理被final, private , static修饰的无法被子类继承的方法
     * @return
     */
//    protected final void doWork1() {
//        System.out.println("coding...");
//    }

//    public static void hello(){
//        System.out.println("hello");
//    }

    @Override
    public String getName() {
        return "码农";
    }

    public String getName1() {
        return "码农";
    }
}