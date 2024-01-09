package com.bravo.advanced.generic.arrayoptimize.v1;

import java.util.Arrays;

/**
 * v1：封装一个好用的addElement方法，改善数组的使用方式
 */
public class AddElementTest {
    public static void main(String[] args) {
        String[] arr = new String[3];
        addElement(arr, "a");
        addElement(arr, "b");
        addElement(arr, "c");
        addElement(arr, "d");
        System.out.println(Arrays.toString(arr)); // [a, b, c]
    }

    public static void addElement(String[] array, String newElement) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = newElement;
                break;
            }
        }
    }
}