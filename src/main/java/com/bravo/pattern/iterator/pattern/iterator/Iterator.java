package com.bravo.pattern.iterator.pattern.iterator;

public interface Iterator<E> {

    // 还有没有下一个？
    boolean hasNext();

    // 给我！
    E next();

}