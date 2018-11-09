package org.laidu.learn.advance.bytecode.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * cglib demo
 *
 * @author tiancai.zang
 * on 2018-11-01 16:24.
 */
public class Demo {

    public static void main(String[] args) {


//        WorkerProxy proxy = new WorkerProxy();

//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(ItWorker.class);
//        enhancer.setCallback(proxy);

        ItWorker worker = (ItWorker) Enhancer.create(ItWorker.class,new Class[]{Worker.class},new WorkerProxy());

        worker.doWork();

    }
}