package com.bravo.pattern.chain_of_responsibility.filter.node_impl.filter;

import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;
import com.bravo.pattern.chain_of_responsibility.filter.node_impl.chain.FilterChain;


public class CFilter implements Filter {
    @Override
    public void doFilter(Request req, Response res, FilterChain filterChain) {
        System.out.println("CFilter");
        filterChain.doFilter(req, res);
    }
}
