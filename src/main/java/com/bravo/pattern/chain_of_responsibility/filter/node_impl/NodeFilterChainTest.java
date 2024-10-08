package com.bravo.pattern.chain_of_responsibility.filter.node_impl;

import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;
import com.bravo.pattern.chain_of_responsibility.filter.Servlet;
import com.bravo.pattern.chain_of_responsibility.filter.node_impl.chain.FilterChain;
import com.bravo.pattern.chain_of_responsibility.filter.node_impl.filter.AFilter;
import com.bravo.pattern.chain_of_responsibility.filter.node_impl.filter.BFilter;
import com.bravo.pattern.chain_of_responsibility.filter.node_impl.filter.CFilter;
import com.bravo.pattern.chain_of_responsibility.filter.node_impl.filter.DFilter;

public class NodeFilterChainTest {

    public static void main(String[] args) {
        // 默认单例bean
        AFilter aFilter = new AFilter();
        BFilter bFilter = new BFilter();
        CFilter cFilter = new CFilter();
        DFilter dFilter = new DFilter();

        // 业务1：注入a、b、c
        FilterChain filterChain1 = new FilterChain();
        filterChain1.addFilter(aFilter);
        filterChain1.addFilter(bFilter);
        filterChain1.addFilter(cFilter);
        filterChain1.setServlet(new Servlet());

        // 业务2：注入a和d（复用了a）
        FilterChain filterChain2 = new FilterChain();
        filterChain2.addFilter(aFilter);
        filterChain2.addFilter(bFilter);
        filterChain2.addFilter(dFilter);
        filterChain2.setServlet(new Servlet());

        // filterChain1和filterChain2互不影响
        filterChain1.doFilter(new Request(), new Response());
    }
}