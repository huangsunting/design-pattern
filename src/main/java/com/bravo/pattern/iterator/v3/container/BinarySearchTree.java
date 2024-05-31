package com.bravo.pattern.iterator.v3.container;

import lombok.Getter;

/**
 * V3版本中，容器与迭代器也是分离的，但不同的是V2是容器组合迭代器，而V3是迭代器组合容器。
 * 具体差异请比对V2和V3的测试用例。
 */
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

    public boolean search(E data) {
        return searchRec(root, data);
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
