package org.laidu.learn.tool.cache.strategy;

import org.laidu.learn.tool.cache.entry.Entry;
import org.laidu.learn.tool.cache.provider.DSProvider;

/**
 * ehcache cache strategy
 *
 * @author tiancai.zang
 * 2018-02-03 12:44.
 */
// TODO: 2018-02-03 12:44  ehcache cache strategy
public class EhcacheStrategy implements CacheStrategy {

    private DSProvider provider;

    @Override
    public void cache(String key, Entry o) {

    }

    @Override
    public Entry get(String key) {
        return null;
    }

    @Override
    public void update(String key, Entry o) {

    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void getAndPut(String key, Entry o) {

    }

    @Override
    public void getAndRemove(String key, Entry o) {

    }
}