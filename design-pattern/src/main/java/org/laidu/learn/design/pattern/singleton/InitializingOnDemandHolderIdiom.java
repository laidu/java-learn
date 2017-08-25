package org.laidu.learn.design.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用静态内部类实现单例
 * User: zangtiancai
 * Date: 2017/8/25
 * Time: 上午10:35
 */
@Slf4j
public class InitializingOnDemandHolderIdiom {

    private static AtomicInteger initCount = new AtomicInteger(0);

    public static InitializingOnDemandHolderIdiom getInstance() {
        return HelperHolder.INSTANCE;
    }

    private InitializingOnDemandHolderIdiom() {
        int count = initCount.incrementAndGet();
        log.info("-*--*--*--*- instance 初始化 第 {} 次-*--*--*--*--", count);
    }

    public static class HelperHolder{
        private static  final InitializingOnDemandHolderIdiom INSTANCE = new InitializingOnDemandHolderIdiom();
    }

    public static void main(String[] args) {

        for (int i=0; i<1000; i++){
            new Thread(InitializingOnDemandHolderIdiom::getInstance).start();
        }

    }
}
