package com.bravo.pattern.iterator.v3.iterator;

public interface Iterator<E> {
    boolean hasNext();

    E next();
}