package com.bravo.pattern.chain_of_responsibility.filter.bad_impl.filter;


import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;

public class CFilter extends AbstractFilter {
    @Override
    protected boolean judge(Request req, Response res) {
        System.out.println("CFilter");
        return true;
    }
}
