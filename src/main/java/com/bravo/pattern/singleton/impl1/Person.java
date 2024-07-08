package com.bravo.pattern.singleton.impl1;

import lombok.Getter;

@Getter
public class Person {

    private final String name;
    
    // 私有构造器，防止外界new
    private Person(String name) {
        this.name = name;
    }

    // 静态变量，在类加载时就会初始化。由于类加载是单线程的，保证了对象的唯一性（上来就创建，迫不及待，谓之“饿”）
    private static final Person INSTANCE = new Person("bravo1988");

    // 在外界拿到实例对象之前，是无法调用普通方法的，所以这里必须是静态的
    public static Person getInstance() {
        return INSTANCE;
    }
}