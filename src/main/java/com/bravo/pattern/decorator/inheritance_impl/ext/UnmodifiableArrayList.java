package com.bravo.pattern.decorator.inheritance_impl.ext;

import com.bravo.pattern.decorator.collection.ArrayList;

public class UnmodifiableArrayList<E> extends ArrayList<E> {

    @Override
    public void add(E e) {
        // 禁止添加
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        // 禁止移除
        throw new UnsupportedOperationException();
    }

}