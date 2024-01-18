package com.bravo.pattern.decorator.decorator_impl;

import com.bravo.pattern.decorator.collection.ArrayList;
import com.bravo.pattern.decorator.collection.List;
import com.bravo.pattern.decorator.decorator_impl.ext.CheckedCollection;
import com.bravo.pattern.decorator.decorator_impl.ext.SynchronizedCollection;
import com.bravo.pattern.decorator.decorator_impl.ext.UnmodifiableCollection;

public class DecoratorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bravo1988");

        System.out.println("=======叠加同步能力========");

        SynchronizedCollection<String> synchronizedList = new SynchronizedCollection<>(list);
        synchronizedList.add("bravo1999");

        System.out.println("=======叠加类型校验能力========");

        CheckedCollection<String> checkedList = new CheckedCollection<>(synchronizedList, String.class);
        checkedList.add("bravo2010");

        System.out.println("=======叠加不可变能力========");
        // 因为后面叠加的能力在最外层被调用，所以这里直接抛异常了
        UnmodifiableCollection<String> unmodifiableList = new UnmodifiableCollection<>(checkedList);
        unmodifiableList.add("bravo2021");
    }
}