package org.laidu.learn.design.pattern.iterator;

/**
 * concrete iterator
 *
 * @author tiancai.zang
 * 2017-12-26 10:51.
 */
public class ConcreteIterator<E> implements Iterator<E> {

    private int index = 0;

    private Aggregate<E> aggregate;

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public E next() {
        return null;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public E currentItem() {
        return null;
    }
}