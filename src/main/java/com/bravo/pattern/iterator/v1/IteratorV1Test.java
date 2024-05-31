package com.bravo.pattern.iterator.v1;


import com.bravo.pattern.iterator.v1.container.ArrayList;
import com.bravo.pattern.iterator.v1.container.BinarySearchTree;
import com.bravo.pattern.iterator.v1.container.LinkedList;
import com.bravo.pattern.iterator.v1.iterator.Iterator;


/**
 * V1版本：迭代器集成在容器内部，可以通过container.iterator()方法直接获取现成的Iterator进行元素遍历，屏蔽具体的数据结构。
 */
public class IteratorV1Test {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        System.out.println(search(arrayList.iterator(), "a"));

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(search(linkedList.iterator(), "b"));

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(9);
        System.out.println(search(binarySearchTree.iterator(), 8));

        // 未来可能新增的容器...
    }

    // 共同的行为抽象：Iterator
    public static boolean search(Iterator<?> iterator, Object targetItem) {
        while (iterator.hasNext()) {
            if (iterator.next().equals(targetItem)) {
                return true;
            }
        }
        return false;
    }
}
