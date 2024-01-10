package com.bravo.advanced.reflection;

public class BaseClassTest {
    public static void main(String[] args) {
        // 当我们new B()时，A构造器中的this指代谁？
        new B();
    }

    static class A<T> {
        // 构造器
        public A() {
            Class<?> clazz = this.getClass();
            System.out.println(clazz.getName());
        }
    }

    static class B extends A<String> {
    }
}