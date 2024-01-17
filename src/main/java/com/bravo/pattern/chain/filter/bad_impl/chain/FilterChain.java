package com.bravo.pattern.chain.filter.bad_impl.chain;

import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;
import com.bravo.pattern.chain.filter.Servlet;
import com.bravo.pattern.chain.filter.bad_impl.filter.Filter;

public class FilterChain {

    private Servlet servlet;

    private Filter firstFilter;

    public void doFilter(Request req, Response res) {
        if (firstFilter != null) {
            Filter filter = firstFilter;
            firstFilter = firstFilter.getNext();
            filter.doFilter(req, res);
        } else {
            servlet.service(req, res);
        }
    }

    public void addFilter(Filter filter) {
        if (firstFilter == null) {
            firstFilter = filter;
        } else {
            // 遍历找到最后一个节点，把最新的Filter追加上去
            Filter currentFilter = firstFilter;
            while (currentFilter.getNext() != null) {
                currentFilter = currentFilter.getNext();
            }
            currentFilter.setNext(filter);
        }
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

}