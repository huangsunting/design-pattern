package com.bravo.pattern.singleton.impl4;

public class Person {

    private final String name;

    private Person(String name) {
        this.name = name;
    }

    private static Person INSTANCE = null;

    // 去掉方法上的synchronized
    public static Person getInstance() {
        if (INSTANCE == null) { // 第一重检查
            // 把锁加在这
            synchronized (Person.class) {
                if (INSTANCE == null) { // 第二重检查
                    INSTANCE = new Person("bravo1988");
                }
            }
        }
        return INSTANCE;
    }
}