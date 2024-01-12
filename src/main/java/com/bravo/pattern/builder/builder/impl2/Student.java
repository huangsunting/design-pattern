package com.bravo.pattern.builder.builder.impl2;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Student {

    private final String name;
    private final Integer age;
    private final String address;

    // 修改1：公开的静态方法，作为Student的创建入口，符合直觉
    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    // 但禁止直接使用构造函数（包访问权限即可，给Builder留个后门）
    Student(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}