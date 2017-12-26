package org.laidu.learn.design.pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * concrete aggergate
 *
 * @author tiancai.zang
 * 2017-12-26 10:43.
 */

public class ConcreteAggregate<E> implements Aggregate<E>{

    private final List<E> items = new ArrayList<>();

    @Override
    public Iterator createIterator() {
        return null;
    }

    @Override
    public void addItem(E e) {
        items.add(e);
    }

    @Override
    public void removeItem(E e) {
        items.remove(e);
    }
}