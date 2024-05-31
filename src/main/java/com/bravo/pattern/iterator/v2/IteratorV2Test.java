package com.bravo.pattern.iterator.v2;

import com.bravo.pattern.iterator.v2.container.BinarySearchTree;
import com.bravo.pattern.iterator.v2.iterator.Iterator;
import com.bravo.pattern.iterator.v2.iteratorfactory.InOrderIteratorFactory;

/**
 * V2版本：由于迭代器从容器分离出去了，如果想对容器进行遍历，需要在创建容器时手动组合一个迭代器。
 * 在V1版本中，BinarySearchTree中已经封装好了迭代器，无需组合，却也无法替换。
 * 而V2版本则更灵活，想要新的迭代算法，只需实现Iterator和IteratorFactory即可。
 * 但坏处是，Node被独立出来，暴露了BinarySearchTree的具体结构。
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
