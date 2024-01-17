package com.bravo.pattern.chain.filter.array_impl.chain;

import com.bravo.pattern.chain.filter.array_impl.filter.Filter;
import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;
import com.bravo.pattern.chain.filter.Servlet;

public class FilterChain {

    // 执行目标：servlet
    private Servlet servlet;

    // 拦截组件：Filter
    private Filter[] filters = new Filter[0];

    // 游标：记录FilterChain执行到哪个Filter了
    private int pos = 0;
    // 数量：记录添加的Filter数量
    private int n = 0;


    public void doFilter(Request req, Response res) {
        // 判断是否还有要执行的filter
        if (pos < n) {
            // 每次调用过滤器链的doFilter时，都要将pos游标+1
            Filter filter = filters[pos++];
            filter.doFilter(req, res, this);
        } else {
            // 如果所有的过滤器都执行完成则执行servlet
            servlet.service(req, res);
        }
    }

    public void addFilter(Filter filter) {
        // 防止重复添加
        for (Filter existingFilter : filters) {
            if (existingFilter == filter) {
                return;
            }
        }

        if (n == filters.length) {
            // 数组扩容
            Filter[] newFilters = new Filter[n + 10];
            System.arraycopy(filters, 0, newFilters, 0, n);
            filters = newFilters;
        }

        filters[n++] = filter;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}