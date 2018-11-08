package org.laidu.learn.concurrent.problem;

import jodd.util.ThreadUtil;
import lombok.AllArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * java 实现死锁的方式
 *
 *
 "Thread-0" #13 prio=5 os_prio=0 cpu=7.61ms elapsed=256.39s tid=0x00007fbfac566800 nid=0x789f waiting for monitor entry  [0x00007fbf4fbf8000]
 java.lang.Thread.State: BLOCKED (on object monitor)
 at org.laidu.learn.concurrent.problem.DeadLockDemo$DeadLockWorker.run(DeadLockDemo.java:32)
 - waiting to lock <0x00000007168d05d8> (a java.lang.Object)
 - locked <0x00000007168d05c8> (a java.lang.Object)
 at java.lang.Thread.run(java.base@11.0.1/Thread.java:834)

 Locked ownable synchronizers:
 - None

 "Thread-1" #14 prio=5 os_prio=0 cpu=5.64ms elapsed=256.39s tid=0x00007fbfac568000 nid=0x78a0 waiting for monitor entry  [0x00007fbf4faf7000]
 java.lang.Thread.State: BLOCKED (on object monitor)
 at org.laidu.learn.concurrent.problem.DeadLockDemo$DeadLockWorker.run(DeadLockDemo.java:32)
 - waiting to lock <0x00000007168d05c8> (a java.lang.Object)
 - locked <0x00000007168d05d8> (a java.lang.Object)
 at java.lang.Thread.run(java.base@11.0.1/Thread.java:834)

 Locked ownable synchronizers:
 - None

 * @author tiancai.zang
 * on 2018-11-08 14:52.
 */
public class DeadLockDemo {

    public static void main(String[] args) {

//        deadLockWithSynchronized();

        deadLockWithReentrantLock();
    }

    public static void deadLockWithReentrantLock() {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new DeadLoclWorker2(lock)).start();
        new Thread(new DeadLoclWorker2(lock)).start();
    }

    @AllArgsConstructor
    static class DeadLoclWorker2 implements Runnable{
        private ReentrantLock lock;
        @Override
        public void run() {
            // ReentrantLock 底层实现？，第一个线程已经结束，但是并未放弃lock，导致虽然线程已经结束但是对象的锁定状态依然保留。
            lock.lock();
            ThreadUtil.sleep(300);
            System.out.println(Thread.currentThread().getName() + "已获取 lock 锁");
        }
    }

    /**
     * 通过 synchronized 实现 java 死锁
     */
    public static void deadLockWithSynchronized() {
        Object a = new Object();
        Object b = new Object();

        new Thread(new DeadLockWorker(a,b)).start();
        new Thread(new DeadLockWorker(b,a)).start();
    }

    @AllArgsConstructor
    static class DeadLockWorker implements Runnable{
        private Object a,b;
        @Override
        public void run() {
            synchronized (a){
                System.out.println("已获取对象b锁");
                ThreadUtil.sleep(300);
                synchronized (b){
                    System.out.println("已获取对象a锁");
                }
            }
        }
    }




}