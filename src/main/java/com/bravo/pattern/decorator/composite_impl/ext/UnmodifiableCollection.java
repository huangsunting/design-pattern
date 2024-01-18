package com.bravo.pattern.decorator.composite_impl.ext;


import com.bravo.pattern.decorator.collection.Collection;

public class UnmodifiableCollection<E> {

    private final Collection<E> collection;

    public UnmodifiableCollection(Collection<E> collection) {
        this.collection = collection;
    }

    public int size() {
        return collection.size();
    }

    public E get(int index) {
        return collection.get(index);
    }

    public void add(E e) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
}
