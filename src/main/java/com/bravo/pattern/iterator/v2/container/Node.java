package com.bravo.pattern.iterator.v2.container;

/**
 * 在V1版本中，Node和迭代器都被定义在BinarySearchTree中，都是内部类。这种设计的好处在于：
 * - 对外屏蔽容器和迭代器的具体实现细节
 * - 迭代器可以访问容器的私有成员（内部类的特性，此时Node、迭代器、BinarySearchTree都是自己人）
 * <p>
 * 但在V2版本中，我们将迭代器分离出去，不再是BinarySearchTree的内部类。
 * 如果继续维持Node作为内部类，则迭代器无法访问Node，也就无法迭代元素。
 * 为了让迭代器继续访问容器，必须把Node也独立出来：容器 ==> Node <== 迭代器，此时Node就像一块跳板，迭代器通过它访问容器。
 */
public class Node<E> {
    // public，需要暴露实现
    public E data;
    public Node<E> left;
    public Node<E> right;

    public Node(E data) {
        this.data = data;
        left = null;
        right = null;
    }
}