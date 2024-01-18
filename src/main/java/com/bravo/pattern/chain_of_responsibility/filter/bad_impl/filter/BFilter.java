package com.bravo.pattern.chain_of_responsibility.filter.bad_impl.filter;


import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;

import java.util.concurrent.ThreadLocalRandom;

public class BFilter extends AbstractFilter {
    @Override
    protected boolean judge(Request req, Response res) {
        System.out.println("BFilter");
        return ThreadLocalRandom.current().nextBoolean();
    }
}
