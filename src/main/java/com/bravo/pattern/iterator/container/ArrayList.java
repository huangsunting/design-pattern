package com.bravo.pattern.iterator.container;

import com.bravo.pattern.iterator.iterator.Iterable;
import com.bravo.pattern.iterator.iterator.Iterator;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * 底层是数组
 */
public class ArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elementData[index];
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            // 先找到待移除元素的位置i
            if (obj.equals(elementData[i])) {
                int numMoved = size - i - 1;
                if (numMoved > 0) {
                    // 对于数组[begin...i...end]，把[i+1, end]的元素都往前移动一位
                    System.arraycopy(elementData, i + 1, elementData, i, numMoved);
                }
                // 上面移动完毕后，把数组末尾清空（因为元素都往前挪了）
                elementData[--size] = null;
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            // 扩容：新容量为旧容量的1.5倍
            int newCapacity = elementData.length + (elementData.length >> 1);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(cursor++);
        }
    }
}