package com.bravo.pattern.strategy.impl2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

public class SortTest {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("刘备", 60, 160));
        list.add(new Person("关羽", 58, 180));
        list.add(new Person("张飞", 56, 170));

        // 场景1：按身高从低到高（可以借助IDEA优化成方法引用）
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.height - o2.height;
            }
        });
        System.out.println(list);

        // 场景2：按年龄从大到小（可以借助IDEA优化成方法引用）
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.age - o1.age;
            }
        });
        System.out.println(list);
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer age;
        private Integer height;
    }
}