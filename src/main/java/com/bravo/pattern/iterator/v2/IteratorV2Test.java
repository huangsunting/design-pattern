package com.bravo.pattern.iterator.v2;

import com.bravo.pattern.iterator.v2.container.BinarySearchTree;
import com.bravo.pattern.iterator.v2.iterator.Iterator;
import com.bravo.pattern.iterator.v2.iteratorfactory.InOrderIteratorFactory;

/**
 * 独立的迭代器：将迭代器注入到容器中
 */
public class IteratorV2Test {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new InOrderIteratorFactory<Integer>());
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(9);

        Iterator<Integer> iterator = tree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
