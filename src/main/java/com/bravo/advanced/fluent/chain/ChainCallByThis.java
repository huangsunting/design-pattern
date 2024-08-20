package com.bravo.advanced.fluent.chain;

import lombok.Getter;
import lombok.ToString;

public class ChainCallByThis {
    public static void main(String[] args) {
        // 最常见的一种链式调用，可类比Lombok插件的@Accessors(chain = true)
        Person person = new Person().setName("bravo1988").setAge(18).setMoney(1000.0);
        System.out.println(person);
    }

    @Getter
    @ToString
    static class Person {
        private String name;
        private Integer age;
        private Double money;

        public Person setName(String name) {
            this.name = name;
            // set方法要返回this，方便继续调用下一个set
            return this;
        }

        public Person setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Person setMoney(Double money) {
            this.money = money;
            return this;
        }
    }
}

