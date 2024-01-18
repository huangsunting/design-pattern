package com.bravo.pattern.decorator.inheritance_impl;

import com.bravo.pattern.decorator.inheritance_impl.ext.SynchronizedArrayList;

public class InheritanceExtendsTest {
    public static void main(String[] args) {
        // SynchronizedArrayList继承ArrayList，对add方法加锁
        SynchronizedArrayList<String> synchronizedArrayList = new SynchronizedArrayList<>();
        synchronizedArrayList.add("bravo1988");
        synchronizedArrayList.add("bravo1999");
        System.out.println(synchronizedArrayList.size());
    }
}