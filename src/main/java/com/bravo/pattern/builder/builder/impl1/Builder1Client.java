package com.bravo.pattern.builder.builder.impl1;


public class Builder1Client {

    public static void main(String[] args) {
        Student student = new Student.StudentBuilder() // StudentBuilder是静态内部类
                .name("bravo")
                .age(18)
                .address("杭州")
                .build(); // 最后必须调用build()，否则返回的是Builder而非Student
        System.out.println(student);
    }
}
