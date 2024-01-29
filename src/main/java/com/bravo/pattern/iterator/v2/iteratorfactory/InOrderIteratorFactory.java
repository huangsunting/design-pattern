package com.bravo.pattern.iterator.v2.iteratorfactory;

import com.bravo.pattern.iterator.v2.container.Node;
import com.bravo.pattern.iterator.v2.iterator.Iterator;
import com.bravo.pattern.iterator.v2.iterator.InOrderIterator;

public class InOrderIteratorFactory<E extends Comparable<E>> implements IteratorFactory<E> {

    @Override
    public Iterator<E> createIterator(Node<E> root) {
        return new InOrderIterator<E>(root);
    }

}
