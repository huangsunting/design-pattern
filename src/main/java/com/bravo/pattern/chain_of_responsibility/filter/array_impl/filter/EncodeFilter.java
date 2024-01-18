package com.bravo.pattern.chain_of_responsibility.filter.array_impl.filter;

import com.bravo.pattern.chain_of_responsibility.filter.array_impl.chain.FilterChain;
import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;

import java.util.concurrent.ThreadLocalRandom;

public class EncodeFilter implements Filter {

    @Override
    public void doFilter(Request req, Response res, FilterChain chain) {
        // 前置操作
        System.out.println("encode start ...");

        // 随机拦截，阻止请求到达Servlet
        if (ThreadLocalRandom.current().nextInt(10) > 5) {
            chain.doFilter(req, res);
        } else {
            System.out.println("encodeFilter 终止...");
            return;
        }

        // 后置处理
        System.out.println("encode end ...");
    }

}