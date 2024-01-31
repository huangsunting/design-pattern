package com.bravo.advanced.generics.wildcard;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest {

    public static void main(String[] args) {
        List<Father> list1 = new ArrayList<>();
        print(list1);

        List<Son> list2 = new ArrayList<>();
        print(list2);

        List<Daughter> list3 = new ArrayList<>();
        print(list3);

        List<String> list4 = new ArrayList<>();
        print(list4);
    }

    private static <T> void print(List<T> list) {
        System.out.println(list.getClass());
    }

    @Getter
    static class GrandPa {

    }

    @Getter
    static class Father extends GrandPa {
        private final String name;

        public Father(String name) {
            this.name = name;
        }
    }

    @Getter
    static class Son extends Father {
        private final Integer height;

        public Son(String name, Integer height) {
            super(name);
            this.height = height;
        }
    }

    @Getter
    static class Daughter extends Father {
        private final Integer height;

        public Daughter(String name, Integer height) {
            super(name);
            this.height = height;
        }
    }
}