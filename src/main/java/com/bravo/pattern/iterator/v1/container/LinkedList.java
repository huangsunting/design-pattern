package com.bravo.pattern.iterator.v1.container;

import com.bravo.pattern.iterator.v1.iterator.Iterable;
import com.bravo.pattern.iterator.v1.iterator.Iterator;

import java.util.NoSuchElementException;

/**
 * 底层是链表
 */
public class LinkedList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    public int size() {
        return size;
    }

    public void add(E element) { // 首次添加元素时，first和last指向同一节点
        Node<E> newNode = new Node<>(element);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;
    }

    public boolean remove(Object obj) {
        Node<E> currentNode = first;
        // 遍历链表
        while (currentNode != null) {
            if (obj.equals(currentNode.data)) {
                // 找到以后，解除当前元素与prev、next的关联
                unlink(currentNode);
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    private void unlink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        size--;
    }

    private Node<E> getNode(int index) {
        Node<E> currentNode;
        // 判断index是否小于size的一半
        if (index < (size >> 1)) {
            // 从前开始遍历，直到循环条件不满足，说明找到index位置的元素了
            currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            // 从后开始遍历
            currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    // 链表的节点，多个节点之间通过prev、next关联
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E element) {
            data = element;
            next = null;
            prev = null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }
}