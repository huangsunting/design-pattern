package com.bravo.pattern.singleton.impl3;

import lombok.Getter;

@Getter
public class Person {

    private final String name;

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