package com.bravo.pattern.iterator.v3.container;

/**
 * 和V2一样，由于迭代器不再是BinarySearchTree的内部类，所以需要把Node处理出来
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