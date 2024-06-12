package com.bravo.advanced.generics.arrayoptimize.v3;

import java.util.Arrays;

/**
 * 泛型数组，支持任意类型元素。也就是JDK中ArrayList的前身。
 */
public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray<String> arr = new DynamicArray<>(3);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        System.out.println(arr); // [a, b, c]
        arr.add("d");
        System.out.println(arr); // [a, b, c, d, null, null]
    }

    static class DynamicArray<T> {
        private Object[] arr;
        private int size = 0;

        public DynamicArray(int initialCapacity) {
            this.arr = new Object[initialCapacity];
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            return (T) arr[index];
        }

        public void add(T str) {
            ensureCapacity(size + 1);
            arr[size++] = str;
        }

        private void ensureCapacity(int minCapacity) {
            if (minCapacity > arr.length) {
                int newCapacity = arr.length * 2;
                arr = Arrays.copyOf(arr, newCapacity);
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
        }
    }
}