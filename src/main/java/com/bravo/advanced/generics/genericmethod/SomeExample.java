package com.bravo.advanced.generics.genericmethod;

import java.util.Objects;

/**
 * 可以在一个普通类中引入泛型方法，不影响类原本的使用方式
 */
public class SomeExample {

    public void someMethod() {
        System.out.println("我是普通方法");
    }

    /*========== 以下引入泛型方法 ==========*/

    /**
     * 泛型方法
     */
    public <T>/*声明类型*/ boolean areEqual(T/*使用类型*/ v1, T v2) {
        return Objects.equals(v1, v2);
    }

    /**
     * 泛型方法（静态）
     */
    public static <T>/*声明类型*/ boolean areEqual2(T/*使用类型*/ v1, T v2) {
        return Objects.equals(v1, v2);
    }
}