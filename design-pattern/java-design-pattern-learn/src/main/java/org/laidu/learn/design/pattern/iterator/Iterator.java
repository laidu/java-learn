package org.laidu.learn.design.pattern.iterator;

/**
 * abstract Iterator
 *
 * @author tiancai.zang
 * 2017-12-26 10:32.
 */
public interface Iterator<E> {

    /**
     * jump to first item
     */
    void first();

    /**
     * get current iterm and jump to next
     * @return current item
     */
    E next();

    /**
     * container is over
     * @return container is over or not
     */
    boolean isDone();

    /**
     * get current item
     * @return current item
     */
    E currentItem();
}