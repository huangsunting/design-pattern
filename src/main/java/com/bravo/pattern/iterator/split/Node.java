package com.bravo.pattern.iterator.split;

public class Node<E> {
    public E data;
    public Node<E> left;
    public Node<E> right;

    public Node(E data) {
        this.data = data;
        left = null;
        right = null;
    }
}