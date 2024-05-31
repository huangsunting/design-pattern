package com.bravo.pattern.iterator.v3;


import com.bravo.pattern.iterator.v3.container.BinarySearchTree;
import com.bravo.pattern.iterator.v3.iterator.InOrderIterator;

/**
 * V3版本 对比 V2版本
 * - 相同点：都实现了容器与迭代器的分离，可以通过组合切换迭代算法
 * - 不同点：V2版本将迭代器传入容器，而V3版本将容器传入迭代器（攻守之势异也）
 * 相比之下，V2优于V3，因为V3对容器结构的破坏更大，此时客户端可以轻易地获取容器的结构，比如tree.getRoot()。
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

        // tree.getRoot();

        InOrderIterator<Integer> iterator = new InOrderIterator<>(tree);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
