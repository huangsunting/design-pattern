package com.bravo.pattern.iterator.v3.container;

import lombok.Getter;

public class BinarySearchTree<E extends Comparable<E>> {
    /**
     * 为了让迭代器能够遍历容器内部的元素，需要将root节点暴露出去，这破坏了容器的封装性
     */
    @Getter
    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(E data) {
        root = insertRec(root, data);
    }

    public boolean search(E data) {
        return searchRec(root, data);
    }

    private Node<E> insertRec(Node<E> root, E data) {
        if (root == null) {
            root = new Node<E>(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    private boolean searchRec(Node<E> root, E data) {
        if (root == null) {
            return false;
        }

        if (data.compareTo(root.data) == 0) {
            return true;
        }

        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
}
