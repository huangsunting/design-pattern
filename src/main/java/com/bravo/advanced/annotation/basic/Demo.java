package com.bravo.advanced.annotation.basic;

// 给类上的注解属性赋值
@MyAnnotation(getValue = "annotation on class")
public class Demo {

    // 给字段上的注解属性赋值
    @MyAnnotation(getValue = "annotation on field")
    public String name;

    // 给方法上的注解属性赋值
    @MyAnnotation(getValue = "annotation on method")
    public void hello() {}

    @MyAnnotation // 没有指定getValue，使用默认值
    public void defaultMethod() {}
}