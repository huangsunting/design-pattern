package com.bravo.advanced.fluent.test;


import com.bravo.advanced.fluent.stream.LazyFluentStream;

import java.util.Arrays;
import java.util.List;

public class FluentStreamTest {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person(1L, "周星驰", 61),
                new Person(2L, "李健", 49),
                new Person(3L, "张学友", 100),
                new Person(4L, "张学友", 62)
        );

        List<String> result = LazyFluentStream.from(list)
                .first(3)
                .last(2)
                .map(Person::getName)
                .toList();
        System.out.println(result);
    }

}
