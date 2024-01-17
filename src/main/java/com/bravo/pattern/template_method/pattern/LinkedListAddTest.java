package com.bravo.pattern.template_method.pattern;

import java.util.LinkedList;

public class LinkedListAddTest extends AbstractCodeTestTemplate {

    @Override
    protected void executeCode() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
    }

}