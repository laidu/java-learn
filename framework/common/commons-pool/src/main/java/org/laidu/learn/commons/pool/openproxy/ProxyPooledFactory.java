package org.laidu.learn.commons.pool.openproxy;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by tiancai.zang
 * on 2020-07-14 23:36.
 */
@Slf4j
public class ProxyPooledFactory extends BasePooledObjectFactory<ProxyInfo> {

    @Override
    public void destroyObject(PooledObject<ProxyInfo> p) throws Exception {
        log.info("destroyObject");
        super.destroyObject(p);
    }

    @Override
    public boolean validateObject(PooledObject<ProxyInfo> p) {
        log.info("validateObject");
        return super.validateObject(p);
    }

    @Override
    public void passivateObject(PooledObject<ProxyInfo> p) throws Exception {
        log.info("passivateObject");
        super.passivateObject(p);
    }

    @Override
    public ProxyInfo create() throws Exception {
        log.info("create");
        return ProxyInfo.builder().build();
    }

    @Override
    public PooledObject<ProxyInfo> wrap(ProxyInfo proxyInfo) {
        log.info("wrap");
        return new DefaultPooledObject<>(proxyInfo);
    }
}