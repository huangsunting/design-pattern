package com.bravo.pattern.iterator.v3;


import com.bravo.pattern.iterator.v3.container.BinarySearchTree;
import com.bravo.pattern.iterator.v3.iterator.InOrderIterator;

/**
 * V3版本 对比 V2版本
 * - 相同点：都实现了容器与迭代器的分离，方便后续通过组合的方式替换迭代算法。
 * - 不同点：V2版本将迭代器传入容器，而V3版本将容器传入迭代器（攻守之势异也）。
 * 从封装的角度来说，V2优于V3。因为V3需要将容器传入迭代器，此时对于容器而言迭代器是“外部”。为了让迭代器能遍历元素，容器必须采取更开放的控制权限，即对外暴露结构。
 * 如此一来，不仅是迭代器，其他客户程序也可以轻易地获取容器的结构，甚至对结构进行修改和破坏。
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

        // tree.getRoot(); 可以轻易获取根节点，破坏了封装性

        InOrderIterator<Integer> iterator = new InOrderIterator<>(tree);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
