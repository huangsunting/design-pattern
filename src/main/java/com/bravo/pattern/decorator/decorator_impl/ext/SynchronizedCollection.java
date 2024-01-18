package com.bravo.pattern.decorator.decorator_impl.ext;

import com.bravo.pattern.decorator.collection.Collection;

public class SynchronizedCollection<E> implements Collection<E> {

    private final Collection<E> collection;
    private final Object mutex;

    public SynchronizedCollection(Collection<E> collection) {
        this.collection = collection;
        this.mutex = this;
    }

    public SynchronizedCollection(Collection<E> collection, Object mutex) {
        this.collection = collection;
        this.mutex = mutex;
    }

    @Override
    public int size() {
        System.out.println("synchronized...");
        synchronized (mutex) {
            return collection.size();
        }
    }

    @Override
    public E get(int index) {
        System.out.println("synchronized...");
        synchronized (mutex) {
            return collection.get(index);
        }
    }

    @Override
    public void add(E e) {
        System.out.println("synchronized...");
        synchronized (mutex) {
            collection.add(e);
        }
    }

    @Override
    public boolean remove(Object o) {
        System.out.println("synchronized...");
        synchronized (mutex) {
            return collection.remove(o);
        }
    }
}
