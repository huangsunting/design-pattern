package com.bravo.pattern.singleton.impl2;

import lombok.Getter;

@Getter
public class Person {

    private final String name;

    private Person(String name) {
        this.name = name;
    }

    // 类加载时不初始化对象
    private static Person INSTANCE = null;

    // 第一次调用时才初始化（所谓“懒”）
    public static Person getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Person("bravo1988");
        }
        return INSTANCE;
    }
}