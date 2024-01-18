package com.bravo.pattern.chain_of_responsibility.filter.array_impl;

import com.bravo.pattern.chain_of_responsibility.filter.array_impl.chain.FilterChain;
import com.bravo.pattern.chain_of_responsibility.filter.array_impl.filter.EncodeFilter;
import com.bravo.pattern.chain_of_responsibility.filter.array_impl.filter.LogFilter;
import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;
import com.bravo.pattern.chain_of_responsibility.filter.Servlet;

public class ArrayFilterChainTest {
    public static void main(String[] args) {
        FilterChain chain = new FilterChain();
        chain.addFilter(new LogFilter());
        chain.addFilter(new EncodeFilter());
        chain.setServlet(new Servlet());

        // 模拟一个请求，要经过Filter
        chain.doFilter(new Request(), new Response());
    }
}