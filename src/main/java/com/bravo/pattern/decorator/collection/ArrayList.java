package com.bravo.pattern.decorator.collection;

public class ArrayList<E> implements List<E> {
    private int size;

    public ArrayList() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void add(E element) {
        System.out.println("增加了一个元素：" + element);
        size++;
    }

    @Override
    public boolean remove(Object obj) {
        System.out.println("移除了元素：" + obj);
        size--;
        return true;
    }
}
