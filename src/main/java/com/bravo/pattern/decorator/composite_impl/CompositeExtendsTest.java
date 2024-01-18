package com.bravo.pattern.decorator.composite_impl;


import com.bravo.pattern.decorator.collection.ArrayList;
import com.bravo.pattern.decorator.composite_impl.ext.SynchronizedCollection;

public class CompositeExtendsTest {
    public static void main(String[] args) {
        // 组合一个ArrayList对象，对add方法加锁
        ArrayList<String> list = new ArrayList<>();
        SynchronizedCollection<String> wrapperCollection = new SynchronizedCollection<>(list);
        wrapperCollection.add("bravo1988");
        wrapperCollection.add("bravo1999");
        System.out.println(wrapperCollection.size());
    }
}