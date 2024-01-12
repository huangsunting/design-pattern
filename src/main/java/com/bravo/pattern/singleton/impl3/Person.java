package com.bravo.pattern.singleton.impl3;

public class Person {

    private final String name;

    // 私有构造器，防止外界new
    private Person(String name) {
        this.name = name;
    }

    private static Person INSTANCE = null;

    // 加上synchronized
    public static synchronized Person getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Person("bravo1988");
        }
        return INSTANCE;
    }
}