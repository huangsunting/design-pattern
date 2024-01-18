package com.bravo.pattern.decorator.composite_impl.ext;


import com.bravo.pattern.decorator.collection.Collection;

public class CheckedCollection<E> {

    private final Collection<E> collection;
    private final Class<E> type;

    public CheckedCollection(Collection<E> collection, Class<E> type) {
        this.collection = collection;
        this.type = type;
    }

    public int size() {
        return collection.size();
    }

    public E get(int index) {
        return collection.get(index);
    }

    public void add(E e) {
        collection.add(typeCheck(e));
    }

    public boolean remove(Object o) {
        return collection.remove(o);
    }

    @SuppressWarnings("unchecked")
    private E typeCheck(Object o) {
        System.out.println("typeCheck...");
        if (o != null && !type.isInstance(o))
            throw new ClassCastException(badElementMsg(o));
        return (E) o;
    }

    private String badElementMsg(Object o) {
        return "Attempt to insert " + o.getClass() +
                " element into collection with element type " + type;
    }

}
