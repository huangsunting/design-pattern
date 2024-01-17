package com.bravo.pattern.chain.filter.array_impl.filter;


import com.bravo.pattern.chain.filter.array_impl.chain.FilterChain;
import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;

public interface Filter {
    void doFilter(Request req, Response res, FilterChain filterChain);
}