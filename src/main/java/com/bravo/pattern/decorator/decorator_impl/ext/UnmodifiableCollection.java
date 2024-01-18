package com.bravo.pattern.decorator.decorator_impl.ext;


import com.bravo.pattern.decorator.collection.Collection;

public class UnmodifiableCollection<E> implements Collection<E> {

    private final Collection<E> collection;

    public UnmodifiableCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public E get(int index) {
        return collection.get(index);
    }

    @Override
    public void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
}
