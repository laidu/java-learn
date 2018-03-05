package org.laidu.learn.tool.cache.entry;

import javax.cache.Cache;

/**
 * cache entry
 *
 * @author tiancai.zang
 * 2018-02-03 12:15.
 */
// : 2018-02-03 12:15  cache entry
public interface Entry<K, V> {

    /**
     * Returns the key corresponding to this entry.
     *
     * @return the key corresponding to this entry
     */
    K getKey();

    /**
     * Returns the value stored in the cache when this entry was created.
     *
     * @return the value corresponding to this entry
     */
    V getValue();

    /**
     * Provides a standard way to access the underlying concrete cache entry
     * implementation in order to provide access to further, proprietary features.
     * <p>
     * If the provider's implementation does not support the specified class,
     * the {@link IllegalArgumentException} is thrown.
     *
     * @param <T>   the type of the underlying {@link Cache.Entry} implementation
     * @param clazz the proprietary class or interface of the underlying
     *              concrete cache. It is this type that is returned.
     * @return an instance of the underlying concrete cache
     * @throws IllegalArgumentException if the caching provider doesn't support
     *                                  the specified class.
     */
    <T> T unwrap(Class<T> clazz);
}