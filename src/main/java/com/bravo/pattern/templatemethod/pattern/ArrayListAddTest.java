package com.bravo.pattern.templatemethod.pattern;

import java.util.ArrayList;

public class ArrayListAddTest extends AbstractCodeTestTemplate {

    @Override
    protected void executeCode() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
    }

}