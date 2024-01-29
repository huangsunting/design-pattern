package com.bravo.pattern.iterator.v3;


import com.bravo.pattern.iterator.v3.container.BinarySearchTree;
import com.bravo.pattern.iterator.v3.iterator.InOrderIterator;

/**
 * 独立的迭代器：将容器注入到迭代器中
 */
public class IteratorV3Test {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);

        InOrderIterator<Integer> iterator = new InOrderIterator<>(tree);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
