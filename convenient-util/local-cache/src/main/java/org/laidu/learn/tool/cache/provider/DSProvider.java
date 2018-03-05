package org.laidu.learn.tool.cache.provider;

import org.laidu.learn.tool.cache.entry.Entry;

import java.util.List;

/**
 * data source provider
 *
 * @author tiancai.zang  2018-02-03 12:18.
 */
// TODO: 2018-02-03 12:18  data source provider
public interface DSProvider {

    /**
     * Gets entry.
     *
     * @return the entry
     */
    Entry getEntry();

    /**
     * Gets entry list.
     *
     * @return the entry list
     */
    List<Entry> getEntryList();
}