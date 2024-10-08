package com.bravo.pattern.chain_of_responsibility.filter.bad_impl;

import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;
import com.bravo.pattern.chain_of_responsibility.filter.Servlet;
import com.bravo.pattern.chain_of_responsibility.filter.bad_impl.chain.FilterChain;
import com.bravo.pattern.chain_of_responsibility.filter.bad_impl.filter.AFilter;
import com.bravo.pattern.chain_of_responsibility.filter.bad_impl.filter.BFilter;
import com.bravo.pattern.chain_of_responsibility.filter.bad_impl.filter.CFilter;

public class BadFilterChainTest {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new AFilter());
        filterChain.addFilter(new BFilter());
        filterChain.addFilter(new CFilter());
        filterChain.setServlet(new Servlet());

        filterChain.doFilter(new Request(), new Response());
    }
}