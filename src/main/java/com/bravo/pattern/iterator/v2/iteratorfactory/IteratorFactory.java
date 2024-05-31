package com.bravo.pattern.iterator.v2.iteratorfactory;


import com.bravo.pattern.iterator.v2.container.Node;
import com.bravo.pattern.iterator.v2.iterator.Iterator;

/**
 * 迭代器工厂方法，用于创建迭代器。这里仅仅作为分离容器与迭代器的一种手段，不用太关心细节。
 */
public interface IteratorFactory<E> {
    Iterator<E> createIterator(Node<E> root);
}