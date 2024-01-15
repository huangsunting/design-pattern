package com.bravo.pattern.singleton.impl5;

public class Person {

    private final String name;

    private Person(String name) {
        this.name = name;
    }

    // 加上volatile：禁止指令重排，保证多线程的内存可见
    private static volatile Person INSTANCE = null;

    public static Person getInstance() {
        if (INSTANCE == null) {
            synchronized (Person.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Person("bravo1988");
                }
            }
        }
        return INSTANCE;
    }
}