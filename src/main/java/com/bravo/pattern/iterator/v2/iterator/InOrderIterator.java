package com.bravo.pattern.iterator.v2.iterator;

import com.bravo.pattern.iterator.v2.container.Node;

import java.util.Stack;

/**
 * 从BinarySearchTree独立出来的迭代器
 */
public class InOrderIterator<E extends Comparable<E>> implements Iterator<E> {
    private final Stack<Node<E>> stack;

    public InOrderIterator(Node<E> root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public E next() {
        Node<E> current = stack.pop();
        pushLeft(current.right);
        return current.data;
    }

    private void pushLeft(Node<E> node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}