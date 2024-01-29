package com.bravo.pattern.iterator.v2.iterator;

public interface Iterator<E> {
    boolean hasNext();

    E next();
}