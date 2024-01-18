package com.bravo.pattern.chain_of_responsibility.filter.node_impl.chain;

import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;
import com.bravo.pattern.chain_of_responsibility.filter.Servlet;
import com.bravo.pattern.chain_of_responsibility.filter.node_impl.filter.Filter;

public class FilterChain {

    private Servlet servlet;
    private Node<Filter> current;

    public void doFilter(Request req, Response res) {
        if (current != null) {
            Filter filter = current.getValue();
            current = current.getNext();
            filter.doFilter(req, res, this);
        } else {
            servlet.service(req, res);
        }
    }

    public void addFilter(Filter filter) {
        if (current == null) {
            // 每添加一个Filter，都会创建一个新的Node包裹它
            current = new Node<>(filter);
        } else {
            current.setNext(filter);
        }
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(T data) {
            Node<T> newNode = new Node<>(data);
            Node<T> current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}