package com.bravo.pattern.iterator;


import java.util.ArrayList;

public class OriginTest {

    public static void main(String[] args) {
        // JDK的ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}
