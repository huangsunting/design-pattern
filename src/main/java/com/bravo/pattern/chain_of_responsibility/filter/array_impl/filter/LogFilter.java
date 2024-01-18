package com.bravo.pattern.chain_of_responsibility.filter.array_impl.filter;


import com.bravo.pattern.chain_of_responsibility.filter.array_impl.chain.FilterChain;
import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;

public class LogFilter implements Filter {

    @Override
    public void doFilter(Request req, Response res, FilterChain chain) {
        // 前置操作
        System.out.println("log start ...");

        // 直接放行到下一个Filter
        chain.doFilter(req, res);

        // 后置处理
        System.out.println("log end ...");
    }

}
