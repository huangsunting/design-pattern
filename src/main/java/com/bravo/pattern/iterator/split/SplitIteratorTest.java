package com.bravo.pattern.iterator.split;


public class SplitIteratorTest {

    public static void main(String[] args) {
        SimpleBinarySearchTree<Integer> tree = new SimpleBinarySearchTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);
        // 组合容器与迭代器
        InOrderIterator<Integer> iterator = new InOrderIterator<>(tree);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
