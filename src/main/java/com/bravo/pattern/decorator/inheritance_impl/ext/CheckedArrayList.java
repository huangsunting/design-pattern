package com.bravo.pattern.decorator.inheritance_impl.ext;

import com.bravo.pattern.decorator.collection.ArrayList;

public class CheckedArrayList<E> extends ArrayList<E> {

    private final Class<E> type;

    // 构造器指定受检类型
    public CheckedArrayList(Class<E> type) {
        this.type = type;
    }

    @Override
    public void add(E e) {
        // 添加元素前做类型校验，只允许加入指定类型元素（运行时校验）
        super.add(typeCheck(e));
    }

    // --------- private methods ---------

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