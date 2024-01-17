package com.bravo.pattern.chain.filter.node_impl.filter;

import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;
import com.bravo.pattern.chain.filter.node_impl.chain.FilterChain;


public class DFilter implements Filter {
    @Override
    public void doFilter(Request req, Response res, FilterChain filterChain) {
        System.out.println("CFilter");
        filterChain.doFilter(req, res);
    }
}
