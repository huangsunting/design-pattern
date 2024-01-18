package com.bravo.pattern.chain_of_responsibility.filter.array_impl.filter;


import com.bravo.pattern.chain_of_responsibility.filter.array_impl.chain.FilterChain;
import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;

public interface Filter {
    void doFilter(Request req, Response res, FilterChain filterChain);
}