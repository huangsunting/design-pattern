package com.bravo.advanced.fluent.chain;

import lombok.Getter;
import lombok.ToString;

public class ChainCallByNew {
    public static void main(String[] args) {
        Person person = new Person().setName("bravo1988").setAge(18).setMoney(1000.0);
        System.out.println(person);
    }

    @Getter
    @ToString
    static class Person {
        private String name;
        private Integer age;
        private Double money;

        public Person() {
        }

        public Person(String name, Integer age, Double money) {
            this.name = name;
            this.age = age;
            this.money = money;
        }

        public Person setName(String name) {
            return new Person(name, this.age, this.money);
        }

        public Person setAge(Integer age) {
            return new Person(this.name, age, this.money);
        }

        public Person setMoney(Double money) {
            return new Person(this.name, this.age, money);
        }
    }
}

