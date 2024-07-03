package com.bravo.advanced.generics.arrayoptimize.v2;

import java.util.Arrays;

/**
 * v2：对数组进行封装，改善数组使用方式，同时支持自动扩容。
 * 缺点是只能支持String元素。
 */
public class DynamicStringArrayTest {

    public static void main(String[] args) {
        DynamicStringArray arr = new DynamicStringArray(3);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        System.out.println(arr); // [a, b, c]
        arr.add("d");
        System.out.println(arr); // [a, b, c, d, null, null]
    }

    static class DynamicStringArray {
        private String[] arr;
        private int size = 0; // 记录当前数组实际长度

        public DynamicStringArray(int initialCapacity) {
            this.arr = new String[initialCapacity]; // 数组容量
        }

        public String get(int index) {
            return arr[index];
        }

        public void add(String str) {
            ensureCapacity(size + 1);
            arr[size++] = str; // 这里先执行arr[size]=str，然后size++
        }

        private void ensureCapacity(int minCapacity) {
            if (minCapacity > arr.length) {
                // 双倍扩容
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