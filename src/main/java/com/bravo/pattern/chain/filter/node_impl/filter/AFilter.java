package com.bravo.pattern.chain.filter.node_impl.filter;

import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;
import com.bravo.pattern.chain.filter.node_impl.chain.FilterChain;


public class AFilter implements Filter {
    @Override
    public void doFilter(Request req, Response res, FilterChain filterChain) {
        System.out.println("AFilter");
        filterChain.doFilter(req, res);
    }
}
