package com.bravo.pattern.iterator.v2.iteratorfactory;


import com.bravo.pattern.iterator.v2.container.Node;
import com.bravo.pattern.iterator.v2.iterator.Iterator;

public interface IteratorFactory<E> {
    Iterator<E> createIterator(Node<E> root);
}