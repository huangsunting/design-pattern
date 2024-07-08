package com.bravo.pattern.singleton.impl4;

import lombok.Getter;

/**
 * 此种写法仍然有缺陷。
 * 除了impl5提到的volatile，还可以使用静态内部类：把鼠标移到第19行if关键字，跟随IDEA提示完成优化即可。
 */
@Getter
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