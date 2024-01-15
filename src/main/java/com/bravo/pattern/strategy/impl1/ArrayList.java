package com.bravo.pattern.strategy.impl1;

import java.util.Arrays;

/**
 * 方式1：ArrayList只能存储实现了Comparable接口的元素（元素自身具备比较能力）
 */
public class ArrayList<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Object[] elementData;
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
        if (size >= 10) {
            throw new RuntimeException("演示专用，最多存10个");
        }
        elementData[size++] = element;
    }

    /********** 排序相关逻辑 ************/
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (this.get(j).compareTo(this.get(j + 1)) > 0) {
                    swap(elementData, j, j + 1);
                }
            }
        }
    }

    private void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}