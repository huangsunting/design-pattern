package com.bravo.pattern.strategy.impl1;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SortTest {

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("刘备", 60, 160));
        list.add(new Person("关羽", 58, 180));
        list.add(new Person("张飞", 56, 170));
        list.sort();
        System.out.println(list);
    }

    @Data
    @AllArgsConstructor
    static class Person implements Comparable<Person> {
        private String name;
        private Integer age;
        private Integer height;

        @Override
        public int compareTo(Person otherPerson) {
            return this.height - otherPerson.height;
        }
    }
}