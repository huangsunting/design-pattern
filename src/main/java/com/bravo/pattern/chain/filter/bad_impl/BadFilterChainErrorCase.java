package com.bravo.pattern.chain.filter.bad_impl;

import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;
import com.bravo.pattern.chain.filter.Servlet;
import com.bravo.pattern.chain.filter.bad_impl.chain.FilterChain;
import com.bravo.pattern.chain.filter.bad_impl.filter.AFilter;
import com.bravo.pattern.chain.filter.bad_impl.filter.BFilter;
import com.bravo.pattern.chain.filter.bad_impl.filter.CFilter;
import com.bravo.pattern.chain.filter.bad_impl.filter.DFilter;

public class BadFilterChainErrorCase {

    public static void main(String[] args) {
        // 假设这是在Spring容器中，默认单例bean
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
        // filterChain2.addFilter(bFilter); 放开后，下一步add dFilter会陷入循环依赖
        filterChain2.addFilter(dFilter);
        filterChain2.setServlet(new Servlet());

        filterChain1.doFilter(new Request(), new Response());
    }
}