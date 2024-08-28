package com.bravo.pattern.iterator.v2;

import com.bravo.pattern.iterator.v2.container.BinarySearchTree;
import com.bravo.pattern.iterator.v2.iterator.Iterator;
import com.bravo.pattern.iterator.v2.iteratorfactory.InOrderIteratorFactory;

/**
 * V2版本：将迭代器从容器内部分离出去。如果想对容器进行遍历，需要在创建容器时手动组合。
 * - V1版本的BinarySearchTree内部封装了迭代器，无需组合，却也无法替换。
 * - V2版本的BinarySearchTree内部没有具体迭代器实现，需要在创建容器时传入IteratorFactory，当客户程序需要遍历元素时生成一个Iterator。
 * V2版本显然更灵活。但坏处是，Node被独立出来，暴露了BinarySearchTree的具体结构。
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
