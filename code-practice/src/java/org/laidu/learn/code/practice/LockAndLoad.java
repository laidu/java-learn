package org.laidu.learn.code.practice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 子弹上膛问题
 *
 * 有一把枪做多装弹20, 一个线程装弹一个线程发射子弹.
 * @author tiancai.zang
 * on 2018-11-12 11:42.
 */
@Slf4j
public class LockAndLoad {



    public static void main(String[] args) {

        Gun gun = new Gun();
        gun.load(new Bullet());

        new Thread(() -> {
            while (true){
                gun.emit();
            }
        }).start();

        new Thread(()->{

            while (true){
                gun.load(new Bullet());
            }

        }).start();

    }


    /**
     * 枪
     */
    static class Gun{

        private BlockingQueue<Bullet> charger = new ArrayBlockingQueue<>(20);

        public void emit() {
            try {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                charger.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("发射子弹, 当前子弹剩余: {}", charger.size());
        }

        public void load(Bullet bullet){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            charger.offer(bullet);
            log.info("填充子弹, 当前子弹剩余: {}", charger.size());
        }
    }

    /**
     * 子弹
     */
    static class Bullet{

    }
}