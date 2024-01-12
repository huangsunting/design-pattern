package com.bravo.pattern.singleton.impl2;

public class Person {

    private final String name;

    // 私有构造器，防止外界new
    private Person(String name) {
        this.name = name;
    }

    // 类加载时不初始化对象（所谓“懒”）
    private static Person INSTANCE = null;

    // 第一次调用时才初始化，后续调用由于instance已经创建，会直接返回
    public static Person getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Person("bravo1988");
        }
        return INSTANCE;
    }
}