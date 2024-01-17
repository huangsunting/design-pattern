package com.bravo.pattern.chain.filter.bad_impl.filter;


import com.bravo.pattern.chain.filter.Request;
import com.bravo.pattern.chain.filter.Response;

public class AFilter extends AbstractFilter {
    @Override
    protected boolean judge(Request req, Response res) {
        System.out.println("AFilter");
        return true;
    }
}
