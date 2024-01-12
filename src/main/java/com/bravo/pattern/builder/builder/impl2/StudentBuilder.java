package com.bravo.pattern.builder.builder.impl2;

public class StudentBuilder {
    private String name;
    private Integer age;
    private String address;

    // 修改2：改为包访问权限，外界没必要直接访问Builder
    StudentBuilder() {
    }

    public StudentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public StudentBuilder address(String address) {
        this.address = address;
        return this;
    }

    public Student build() {
        return new Student(name, age, address);
    }
}