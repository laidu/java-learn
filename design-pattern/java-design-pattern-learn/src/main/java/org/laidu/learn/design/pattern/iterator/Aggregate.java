package org.laidu.learn.design.pattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * aggregate container
 *
 * @param <E> the type parameter
 * @author tiancai.zang  2017-12-26 10:20.
 */
public interface Aggregate<E>{
    /**
     * Create iterator iterator.
     *
     * @return the iterator
     */
    Iterator createIterator();

    /**
     * Add item.
     *
     * @param e the e
     */
    void addItem(E e);

    /**
     * Remove item.
     *
     * @param e the e
     */
    void removeItem(E e);
}