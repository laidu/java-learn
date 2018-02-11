package org.laidu.learn.tool.cache;

import org.laidu.learn.tool.cache.entry.Entry;

/**
 * cache interface
 *
 * @param <T> the type parameter
 * @author tiancai.zang  2018-02-03 11:28.
 */
// TODO: 2018-02-03 11:28  cache interface
public interface Cache<T extends Entry> {

    /**
     * cache data with String key
     *
     * @param key String
     * @param o   entry
     */
    void cache(String key, T o);

    /**
     * get entry by key
     *
     * @param key String
     * @return entry t
     */
    T get(String key);

    /**
     * update entry with key and new entry
     *
     * @param key string
     * @param o   entry
     */
    void update(String key, T o);

    /**
     * Remove.
     *
     * @param key the key
     */
    void remove(String key);

    /**
     * Gets and put.
     *
     * @param key the key
     * @param o   the o
     */
    void getAndPut(String key, T o);

    /**
     * Gets and remove.
     *
     * @param key the key
     * @param o   the o
     */
    void getAndRemove(String key, T o);
}