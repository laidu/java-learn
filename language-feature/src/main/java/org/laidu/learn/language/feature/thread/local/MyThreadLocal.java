package org.laidu.learn.language.feature.thread.local;


import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MyThreadLocal
 * <p>
 * Created by 臧天才 on 2017-09-01 15:03.
 */
// : 2017-09-01 15:03  MyThreadLocal
@Slf4j
public class MyThreadLocal extends ThreadLocal<Map>{
    @Override
    protected Map initialValue() {
        log.info("-*--*--*--*- new ConcurrentHashMap() -*--*--*--*--");
        return new ConcurrentHashMap();
    }

    @Override
    public void set(Map value) {
        throw new UnsupportedOperationException();
    }
}
