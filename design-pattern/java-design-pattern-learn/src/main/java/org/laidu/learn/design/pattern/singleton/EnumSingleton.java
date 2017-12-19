package org.laidu.learn.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 使用枚举实现单例
 * User: zangtiancai
 * Date: 2017/8/25
 * Time: 上午10:54
 */
@Slf4j
public enum  EnumSingleton {

    INSTANCE;

    public void doWork(){
        log.info("-*--*--*--*- doWork -*--*--*--*--");
    }

    public static void main(String[] args) {

        for (int i=0; i<1000; i++){
            new Thread(EnumSingleton.INSTANCE::doWork).start();
        }
    }
}
