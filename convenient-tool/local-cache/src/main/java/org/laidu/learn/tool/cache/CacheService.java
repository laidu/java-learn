package org.laidu.learn.tool.cache;

import lombok.AllArgsConstructor;
import org.laidu.learn.tool.cache.entry.Entry;
import org.laidu.learn.tool.cache.event.CacheEntryListener;
import org.laidu.learn.tool.cache.policy.SyncPolicy;
import org.laidu.learn.tool.cache.provider.DSProvider;
import org.laidu.learn.tool.cache.strategy.CacheStrategy;

import java.util.List;

/**
 * cache service
 *
 * @author tiancai.zang
 * 2018-02-03 12:09.
 */
// : 2018-02-03 12:09  cache service
@AllArgsConstructor
public class CacheService implements Cache{

    private DSProvider provider;
    private CacheStrategy localCacheStore;
    private List<CacheEntryListener> cacheEntryListener;
    private List<SyncPolicy> syncPolicy;

    @Override
    public void cache(String key, Entry o) {
        localCacheStore.cache(key,o);
    }

    @Override
    public Entry get(String key) {
        return localCacheStore.get(key);
    }

    @Override
    public void update(String key, Entry o) {
        localCacheStore.update(key,o);
    }

    @Override
    public void remove(String key) {
        localCacheStore.remove(key);
    }

    @Override
    public void getAndPut(String key, Entry o) {
        localCacheStore.getAndPut(key,o);
    }

    @Override
    public void getAndRemove(String key, Entry o) {
        localCacheStore.getAndRemove(key,o);
    }
}