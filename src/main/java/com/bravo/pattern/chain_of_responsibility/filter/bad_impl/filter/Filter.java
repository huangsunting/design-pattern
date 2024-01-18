package com.bravo.pattern.chain_of_responsibility.filter.bad_impl.filter;

import com.bravo.pattern.chain_of_responsibility.filter.Request;
import com.bravo.pattern.chain_of_responsibility.filter.Response;

public interface Filter {

    boolean doFilter(Request req, Response res);

    void setNext(Filter filter);

    Filter getNext();
}