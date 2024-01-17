package com.bravo.pattern.iterator.pattern;


import com.bravo.pattern.iterator.pattern.container.ArrayList;
import com.bravo.pattern.iterator.pattern.container.LinkedList;

public class ContainerTest {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(search(linkedList, "a"));
    }

    public static boolean search(Object dataList, Object targetItem) {
        // 如果ArrayList和LinkedList没有共同的行为抽象（Iterator），就要通过if-else做类型判断
        if (dataList instanceof ArrayList) {
            ArrayList<?> arrayList = (ArrayList<?>) dataList;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).equals(targetItem)) {
                    return true;
                }
            }
        } else if (dataList instanceof LinkedList) {
            LinkedList<?> linkedList = (LinkedList<?>) dataList;
            for (int i = 0; i < linkedList.size(); i++) {
                if (linkedList.get(i).equals(targetItem)) {
                    return true;
                }
            }
        }
        return false;
    }
}
