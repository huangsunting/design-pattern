package com.bravo.pattern.builder.builder.impl2;


public class Builder2Client {

    public static void main(String[] args) {
        // 客户程序由Student入手创建对象，但无法直接创建对象，必须通过Builder
        Student student = Student.builder()
                .name("bravo")
                .age(18)
                .address("杭州")
                .build();
        System.out.println(student);
    }
}
