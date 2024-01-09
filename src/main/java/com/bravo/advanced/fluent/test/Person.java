package com.bravo.advanced.fluent.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private Long id;
    private String name;
    private int age;

    public int getAge() {
        System.out.println("调用age了");
        return age;
    }

    public String getName() {
        System.out.println("调用name了");
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}