package com.bravo.pattern.iterator.v3.container;

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