package com.bravo.pattern.decorator.inheritance_impl.ext;

import com.bravo.pattern.decorator.collection.ArrayList;

public class SynchronizedArrayList<E> extends ArrayList<E> {

    // 对象锁
    private final Object mutex;

    public SynchronizedArrayList() {
        // 如果不指定，则以当前对象作为锁
        this.mutex = this;
    }

    public SynchronizedArrayList(Object mutex) {
        this.mutex = mutex;
    }

    @Override
    public int size() {
        System.out.println("synchronized...");
        // 主体操作还是在ArrayList，这里只是包裹一个同步代码块
        synchronized (mutex) {
            return super.size();
        }
    }

    @Override
    public E get(int index) {
        System.out.println("synchronized...");
        synchronized (mutex) {
            return super.get(index);
        }
    }

    @Override
    public void add(E e) {
        System.out.println("synchronized...");
        synchronized (mutex) {
            super.add(e);
        }
    }

    @Override
    public boolean remove(Object o) {
        System.out.println("synchronized...");
        synchronized (mutex) {
            return super.remove(o);
        }
    }
}