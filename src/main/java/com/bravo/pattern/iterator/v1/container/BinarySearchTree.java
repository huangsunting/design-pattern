package com.bravo.pattern.iterator.v1.container;

import com.bravo.pattern.iterator.v1.iterator.Iterable;
import com.bravo.pattern.iterator.v1.iterator.Iterator;

import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {
    private Node root; // 根节点

    public BinarySearchTree() {
        root = null;
    }

    public void insert(E data) {
        // 插入新元素，返回根节点
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, E data) {
        if (root == null) {
            // 递归的结束条件：到了某个分支末尾，构建节点并插入
            root = new Node(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            // 递归：数据比当前节点小，往左继续比较插入
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            // 递归：数据比当前节点大，往右继续比较插入
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean search(E data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, E data) {
        if (root == null) {
            return false;
        }

        if (data.compareTo(root.data) == 0) {
            // 递归结束条件：找到相等的节点
            return true;
        }

        if (data.compareTo(root.data) < 0) {
            // 递归：数据比当前节点小，往左继续比较
            return searchRec(root.left, data);
        } else {
            // 递归：数据比当前节点大，往右继续比较
            return searchRec(root.right, data);
        }
    }

    private class Node {
        E data;
        Node left;
        Node right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        // 按顺序遍历的迭代器
        return new InOrderIterator(root);
    }

    private class InOrderIterator implements Iterator<E> {
        private final Stack<Node> stack;

        public InOrderIterator(Node root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            Node current = stack.pop();
            pushLeft(current.right);
            return current.data;
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}