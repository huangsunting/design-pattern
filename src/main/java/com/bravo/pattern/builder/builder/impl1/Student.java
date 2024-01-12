package com.bravo.pattern.builder.builder.impl1;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Student {

    // 为了简化代码，省略其他字段
    private final String name;
    private final Integer age;
    private final String address;

    // 仍然提供全参构造，但是私有的：1.客户程序看不到，不会有选择困难 2.客户程序无法直接创建Student
    private Student(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // ------- Builder相关代码：客户程序可以通过StudentBuilder创建Student -------
    public static class StudentBuilder {
        // Builder内部维护了与Student相同的字段
        private String name;
        private Integer age;
        private String address;

        // 分步收集属性值
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
            // 收集完毕创建真正的Student对象（Student私有构造对Builder可见，因为Builder是其内部成员）
            return new Student(name, age, address);
        }
    }
}