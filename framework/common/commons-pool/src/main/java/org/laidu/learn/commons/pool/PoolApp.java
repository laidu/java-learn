package org.laidu.learn.commons.pool;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.laidu.learn.commons.pool.openproxy.ProxyInfo;
import org.laidu.learn.commons.pool.openproxy.ProxyPooledFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * pool demo
 * <p>
 * Created by tiancai.zang
 * on 2020-07-14 23:25.
 */
@Slf4j
public class PoolApp {

    public static void main(String[] args) throws Exception {
        ProxyPooledFactory factory = new ProxyPooledFactory();
        GenericObjectPoolConfig<ProxyInfo> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxIdle(200);
        poolConfig.setMaxTotal(1000);
        poolConfig.setMinIdle(150);
        poolConfig.setMaxWaitMillis(50);
        poolConfig.setTestOnBorrow(true);

        poolConfig.setTestWhileIdle(true);
        poolConfig.setTestOnCreate(false);
        poolConfig.setMaxWaitMillis(100);
        poolConfig.setTimeBetweenEvictionRunsMillis(10);

        ObjectPool<ProxyInfo> pool = new GenericObjectPool<>(factory);

        while (true) {
            ProxyInfo proxyInfo1 = pool.borrowObject();
            ProxyInfo proxyInfo = pool.borrowObject();
//            Thread.sleep(100);
            pool.returnObject(proxyInfo);
            System.out.println(pool.getNumActive());
            System.out.println(pool.getNumIdle());
        }


    }
}