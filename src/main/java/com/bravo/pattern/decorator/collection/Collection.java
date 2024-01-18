package com.bravo.pattern.decorator.collection;

public interface Collection<E> {

    int size();

    E get(int index);

    void add(E e);

    boolean remove(Object o);
}