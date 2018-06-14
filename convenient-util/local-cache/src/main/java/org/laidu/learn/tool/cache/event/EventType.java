package org.laidu.learn.tool.cache.event;

/**
 * event type
 *
 * @author tiancai.zang
 * 2018-02-03 12:55.
 */
// : 2018-02-03 12:55  event type
public enum EventType {

    /**
     * An event type indicating that the cache entry was created.
     */
    CREATED,

    /**
     * An event type indicating that the cache entry was updated. i.e. a previous
     * mapping existed
     */
    UPDATED,


    /**
     * An event type indicating that the cache entry was removed.
     */
    REMOVED,


    /**
     * An event type indicating that the cache entry has expired.
     */
    EXPIRED

}
