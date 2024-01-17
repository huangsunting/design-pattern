package com.bravo.pattern.iterator.split;

import com.bravo.pattern.iterator.pattern.iterator.Iterator;

import java.util.Stack;

public class InOrderIterator<E extends Comparable<E>> implements Iterator<E> {
    private final Stack<Node<E>> stack;

    public InOrderIterator(SimpleBinarySearchTree<E> tree) {
        stack = new Stack<>();
        pushLeft(tree.getRoot());
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
